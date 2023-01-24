public class Othello {
    int bScore;
    int wScore;
    private boolean bTurn;
    private int[][] board;
    private boolean[][] legalMoves;

    public Othello() {
        board = new int[8][8];
        bTurn = true;
        legalMoves = new boolean[8][8];
        board[3][3] = 1;
        board[3][4] = 2;
        board[4][3] = 2;
        board[4][4] = 1;
    }

    public void searchMoves() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                legalMoves[i][j] = checkMove(i, j);
            }
        }
    }

    public boolean checkMove(int r, int c) {
        if (board[r][c] != 0) {
            return false;
        }
        int other = 1;
        int self = 2;
        if (bTurn) {
            other = 2;
            self = 1;
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (!(r + i > 7 || r + i < 0 || c + j > 7 || c + j < 0 ||
                        (i == 0 && j == 0))) {
                    if (board[r + i][c + j] == other) {
                        int x = r + i;
                        int y = c + j;
                        while (x < 8 && x > -1 && y < 8 && y > -1 &&
                                board[x][y] != 0) {
                            if (board[x][y] == self) {
                                return true;
                            }
                            x += i;
                            y += j;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void play(int r, int c) {
        int other = 1;
        int self = 2;
        if (bTurn) {
            other = 2;
            self = 1;
        }
        if (checkMove(r, c)) {
            board[r][c] = self;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (!(r + i > 7 || r + i < 0 || c + j > 7 || c + j < 0 ||
                            (i == 0 && j == 0))) {
                        if (board[r + i][c + j] == other) {
                            int x = r + i;
                            int y = c + j;
                            while (x < 8 && x > -1 && y < 8 && y > -1 &&
                                    board[x][y] != 0) {
                                if (board[x][y] == self) {
                                    while (board[x - i][y - j] != self) {
                                        board[x - i][y - j] = self;
                                        x -= i;
                                        y -= j;
                                    }
                                    break;
                                }
                                x += i;
                                y += j;
                            }
                        }
                    }
                }
            }
        } else {
            return;
        }
        bTurn = !bTurn;
        searchMoves();
        for (int i = 0; i < legalMoves.length; i++) {
            for (int j = 0; j < legalMoves[i].length; j++) {
                if (legalMoves[i][j]) {
                    return;
                }
            }
        }
        bTurn = !bTurn;
    }

    public boolean isWon() {
        searchMoves();
        for (int i = 0; i < legalMoves.length; i++) {
            for (int j = 0; j < legalMoves[i].length; j++) {
                if (legalMoves[i][j]) {
                    return false;
                }
            }
        }
        bTurn = !bTurn;
        for (int i = 0; i < legalMoves.length; i++) {
            for (int j = 0; j < legalMoves[i].length; j++) {
                if (legalMoves[i][j]) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    bScore++;
                } else if (board[i][j] == 2) {
                    wScore++;
                }
            }
        }
        return true;
    }


    public int getbScore() {
        return bScore;
    }

    public int getwScore() {
        return wScore;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isbTurn() {
        return bTurn;
    }

    public Othello(String k) {
        board = new int[8][8];
        legalMoves = new boolean[8][8];
        int zeroCount = 0;
        int index = k.length() - 1;
        for (int i = 0; i < 64; i++) {
            if (zeroCount != 0) {
                board[i / 8][i % 8] = 0;
                zeroCount--;
            } else if (Integer.parseInt(k.substring(index, index + 1)) > 2) {
                zeroCount = Integer.parseInt(k.substring(index, index + 1));
                index--;
                i--;
            } else {
                board[i / 8][i % 8] = Integer.parseInt(k.substring(index, index + 1));
                index--;
            }
        }
        bTurn = Integer.parseInt(k.substring(0, 1)) == 1;

    }

    public String generateSave() {
        String k = "";
        if (bTurn) {
            k += 1;
        } else {
            k += 2;
        }
        int zeroCount = 0;
        for (int i = 63; i > -1; i--) {
            k += board[i / 8][i % 8];
            if (board[i / 8][i % 8] == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 2) {
                    k = k.substring(0, k.length() - zeroCount - 1) + zeroCount + board[i / 8][i % 8];
                    ;
                }
                zeroCount = 0;
            }
            if (zeroCount == 9) {
                k = k.substring(0, k.length() - zeroCount) + zeroCount;
                zeroCount = 0;
            }
            System.out.println(k);
        }
        return k;
    }

    public String toString() {
        String s = ":zero::one::two::three::four::five::six::seven:\n";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    s += ":green_square:";
                } else if (board[i][j] == 1) {
                    s += ":purple_circle:";
                } else {
                    s += ":white_circle:";
                }
            }
            s += i + "\n";
        }
        return s;
    }


}
