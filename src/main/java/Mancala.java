public class Mancala {
    int[] board;
    boolean playerOne;
    int winner;

    public Mancala() {
        board = new int[]{0, 4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4,};
        playerOne = true;
        winner = -1;
    }

    public void play(int where) {
        if (where < 1 || where > 6) {
            return;
        }
        if (!playerOne) {
            where += 7;
        }
        int numAt = board[where];
        int index = -1;
        for (int i = 0; i < numAt; i++) {
            index = where + i + 1;
            if (index > 13) {
                index -= 14;
            }
            if (index == 0 || index == 7) {
                if (playerOne && index == 7) {
                    board[index]++;
                } else if (index == 7) {
                    index++;
                    i++;
                    board[index]++;
                }
                if (!playerOne && index == 0) {
                    board[index]++;
                } else if (index == 0) {
                    index++;
                    i++;
                    board[index]++;
                }
            } else {
                board[index]++;
            }
        }
        if (index == -1) {
            return;
        }
        if (isWon()) {
            determineWinner();
            return;
        }
        board[where] = 0;
        if (index == 0 || index == 7)
            return;
        if (playerOne && index < 7 && board[index] == 1) {
            board[7] += board[14 - index] + 1;
            board[14 - index] = 0;
            board[index] = 0;
        }
        if (!playerOne && index > 7 && board[index] == 1) {
            board[0] += board[14 - index] + 1;
            board[14 - index] = 0;
            board[index] = 0;
        }
        playerOne = !playerOne;
    }

    public boolean isWon() {
        boolean won = true;
        for (int i = 1; i < 7; i++) {
            if (board[i] != 0) {
                won = false;
                break;
            }
        }
        if (won) {
            return true;
        }
        won = true;
        for (int i = 8; i < 14; i++) {
            if (board[i] != 0) {
                won = false;
                break;
            }
        }
        return won;

    }

    public int addRow(boolean one) {
        int sum = 0;
        if (one) {
            for (int i = 0; i < 7; i++) {
                sum += board[i];
            }
            return sum;
        }
        for (int i = 7; i < 14; i++) {
            sum += board[i];
        }
        return sum;
    }

    public void determineWinner() {
        if (addRow(true) == addRow(false)) {
            winner = 0;
        } else if (addRow(true) > addRow((false))) {
            winner = 1;
        } else
            winner = 2;
    }

    public int getWinner() {
        return winner;
    }

    public String toString() {
        String ret = "    [";
        for (int i = 1; i < 7; i++) {
            ret += " " + board[i];
        }
        ret += "]" + "[" + board[7] + "]" + "\n[" + board[0] + "][";
        for (int i = 13; i > 7; i--) {
            ret += " " + board[i];
        }
        return ret + "]";
    }

}
