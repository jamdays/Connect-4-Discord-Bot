public class Filler {
    //instance variables
    private boolean turnOne;
    private int[][] board;
    public static void main(String[] args){
        Filler filler = new Filler();
        System.out.println(filler.print());
    }
    public Filler(){
        turnOne = true;
        board = new int[7][8];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = (int)(Math.random()*6);
                if(i -1 > -1 && board[i-1][j] == board[i][j]){
                    board[i][j] = (board[i][j] + 1)%6;
                    if(j -1 > -1 && board[i][j-1] == board[i][j]){
                        board[i][j] = (board[i][j] + 1)%6;
                    }
                }
                if(j -1 > -1 && board[i][j-1] == board[i][j]){
                    board[i][j] = (board[i][j] + 1)%6;
                    if(i -1 > -1 && board[i-1][j] == board[i][j]){
                        board[i][j] = (board[i][j] + 1)%6;
                    }
                }

            }
        }
    }
    public String toString(){
        String boardString = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    boardString += ":red_square:";
                }
                else if(board[i][j] == 1){
                    boardString += ":green_square:";
                }
                else if(board[i][j] == 2){
                    boardString += ":blue_square:";
                }
                else if(board[i][j] == 3){
                    boardString += ":purple_square:";
                }
                else if(board[i][j] == 4){
                    boardString += ":orange_square:";
                }
                else if(board[i][j] == 5){
                    boardString += ":yellow_square:";
                }

            }
            boardString += "\n";
        }
        return boardString;

    }
    public String print(){
        String boardString = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boardString += board[i][j] + " ";
            }
            boardString += "\n";
        }
        return boardString;
    }
    public boolean isTurnOne(){
        return turnOne;
    }
    public void play(int changeTo){
        if(changeTo == board[board.length-1][0] || changeTo == board[0][board[0].length -1]){
            return;
        }
        if(turnOne){
            change(0, board.length-1, changeTo, board[board.length-1][0]);
        }
        else{
            change(board[0].length -1,0, changeTo, board[0][board[0].length -1]);
        }
        turnOne = !turnOne;

    }
    private void change(int x, int y, int changeTo, int select){
        board[y][x] = changeTo;
        int[] deltas = {1, -1};
        for(int dx: deltas){
          if((x + dx) < board[0].length && (x + dx) > -1 && board[y][x+dx] == select){
              change(x+dx, y, changeTo, select);
          }
        }
        for(int dy: deltas){
            if(y + dy < board.length && y + dy  > -1 && board[y + dy][x] == select){
                change(x, y + dy, changeTo, select);
            }
        }

    }


}
