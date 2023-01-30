import java.util.ArrayList;
import java.util.Scanner;
public class Filler {
    //instance variables
    private boolean turnOne;
    private int[][] board;
    public static void main(String[] args){
        Filler filler = new Filler();
        System.out.println(filler.print());
        Scanner in = new Scanner(System.in);
        while(!filler.isWon()){
            filler.play(in.nextInt());
            System.out.println(filler.print());
        }
        int[] win = filler.winner();
        System.out.println(win[0] + "player One: " + win[1] + " player Two: " + win[2]);
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
    public Filler(int x, int y){
        turnOne = true;
        board = new int[x][y];
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
    public int dimension(){
        return board[0].length;
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
    public ArrayList<String> bigToString(){
        ArrayList<String> out = new ArrayList<String>();
        int row = 0;
        while(row < board.length -1) {
            String boardString = "";
            for (int i = row; (i -row) < 9 && i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == 0) {
                        boardString += ":red_square:";
                    } else if (board[i][j] == 1) {
                        boardString += ":green_square:";
                    } else if (board[i][j] == 2) {
                        boardString += ":blue_square:";
                    } else if (board[i][j] == 3) {
                        boardString += ":purple_square:";
                    } else if (board[i][j] == 4) {
                        boardString += ":orange_square:";
                    } else if (board[i][j] == 5) {
                        boardString += ":yellow_square:";
                    }

                }
                boardString += "\n";
            }
            row += 9;
            out.add(boardString);
        }
        return out;
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
    public boolean isWon(){
        int taken = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((valid(i +1, j) == board[i][j])||valid(i -1, j)  == board[i][j] ||valid(i, j +1)  == board[i][j] ||valid(i, j-1)  == board[i][j]){
                    taken++;
                }
            }
        }
        return taken == board.length*board[0].length;
    }
    public int[] winner(){
        int[] winState = new int[3];
        if(!isWon()){
            winState[0] = -1;
            winState[1] = -1;
            winState[2] = -1;
            return winState;
        }
        int scoreOne = 0;
        int scoreTwo = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == board[board.length-1][0]){
                    scoreOne++;
                } else{
                    scoreTwo++;
                }
            }
        }
        winState[1] = scoreOne;
        winState[2] = scoreTwo;
        if(scoreOne > scoreTwo){
            winState[0] = 1;
            return winState;
        }
        winState[0] = 2;
        return winState;
    }
    private int valid(int i, int j){
        if(i < board.length && i > -1 && j < board[0].length && j > -1){
            return board[i][j];
        }
        return -1;
    }
    private void change(int x, int y, int changeTo, int select){
        ///fix score one/score two
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
