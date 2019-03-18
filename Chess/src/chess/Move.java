//SOROUSH AGHAJANI
package chess;

import static java.nio.file.Files.move;
import chess.Pawn;

/**
 *
 * @author aghaj
 */

abstract public class Move {
    static boolean  BlackKingShouldMove = false;
static boolean notMate = false;
static boolean WhiteKingShouldMove = false;
    static int WcheckCount;
    static int BcheckCount;
    boolean HorizontalCheck;
    boolean VerticalCheck;
    static int WXP;
    static int WYP;
    static int BXP;
    static int BYP;
    public static int counter = 0;
    static int countdebug;
    static Move[][] board = new Move[8][8];
    static int[][] ColorOfPice = new int[8][8];
    static boolean[][] empty = new boolean[8][8];
    int Xpos;
    int Ypos;
    static boolean globTurn = true;
    // boolean empty;
    boolean oppExist;
    boolean pinned;
    protected boolean smallCastlable;
    protected boolean bigCastlable;
    public boolean rNeverMoved;

    static public void truer() {
        for (int m = 0; m < 8; m++) {
            WXP = 4;
            WYP = 0;
            BXP = 4;
            BYP = 7;
            ColorOfPice[m][0] = 1;
            ColorOfPice[m][1] = 1;
            empty[m][0] = false;
            empty[m][1] = false;
            
        }
    }

    static public void falser() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                empty[col][7] = false;
                empty[col][6] = false;
                ColorOfPice[col][7] = -1;
                ColorOfPice[col][6] = -1;

            }
        }
    }

    static public void traverser() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                ColorOfPice[r][c] = 0;
                ColorOfPice[r][c] = 0;
                empty[r][c] = true;
                empty[r][c] = true;
            }
        }
    }

    abstract protected void move(int i, int j, boolean move, Move moved);

    abstract protected boolean isMovable(int i, int j, Move movable);

    abstract protected int getXPos();

    abstract protected int getYPos();

    static protected boolean isEmpty(int i, int j) {

        return empty[i][j];
    }

    protected void newPos(int i, int j, Move move) {

    }

    protected boolean isOpp(int i, int j) {
        boolean opp = false;
        if (globTurn && ColorOfPice[i][j] == -1) {
            opp = true;
        } else if (!globTurn && ColorOfPice[i][j] == 1) {
            opp = true;
        } else {
           opp = false;
        }

        return opp;
    }

    public void marker(int i, int j, Move move) {
//System.out.println("counter is "+ counter);
        int s = move.getXPos();
        int b = move.getYPos();
        System.out.println(s + " " + b );
        // empty[move.getXPos()][move.getYPos()] = true;

        board[i][j] = move;
        empty[i][j] = false;
ColorOfPice[i][j] =ColorOfPice[s][b];
ColorOfPice[s][b] =0;
        //System.out.println("previous pice color is " + ColorOfPice[s][b]);
        ColorOfPice[s][b] = 0;
        if (countdebug > 31) {
            countdebug++;
        }
        board[s][b] = null;
        empty[s][b] = true;

        if (globTurn && ColorOfPice[s][b] == 1) {

            ColorOfPice[i][j] = 1;

        } else if (globTurn && ColorOfPice[s][b] == 2) {
            ColorOfPice[i][j] = 1;
        } else if (!globTurn && ColorOfPice[s][b] == -1) {
            ColorOfPice[i][j] = -1;
        } else if (!globTurn && ColorOfPice[s][b] == -2) {
            ColorOfPice[i][j] = -2;
        }

        move.setYPos(j);
        move.setXPos(i);
        if (globTurn) {
            globTurn = false;
        } else {
            globTurn = true;
        }
    }

    abstract protected void setXPos(int i);

    abstract protected void setYPos(int j);

    protected void hit(int i, int j, int a, int b, Move move) {
        board[i][j] = board[a][b];
        marker(i, j, move);
    }
static boolean isCheck(int xp,int yp, boolean turn){
    int checkCounter = 0;
  boolean  returnVal = false;
  int coun = 0;
    if(globTurn == true){
        for(int i = 0; i < 8;i++){
            for( int j = 0;j < 8;j++){

                if(ColorOfPice[i][j] == -1&& checkCounter < 10){
                                     System.out.println("inisde white check" + coun);
                 coun++;
                   if (board[i][j].isMovable(xp,yp,board[i][j])){
                      System.out.println(i+" kishesh karde"+j);
                       checkCounter++;
                                          returnVal = true;
                                       if(checkCounter >1 ){
                    WhiteKingShouldMove = true;

                   break;
                                       }
                   }
                }
            }
        }
    } else if(globTurn==true){
        for(int y = 0; y < 8;y++){
            for( int u = 0;u < 8;u++){
                System.out.println("inside black check" );
                if(ColorOfPice[y][u] == 1&& checkCounter < 2&&board[y][u].isMovable(xp,yp,board[y][u])){
                       checkCounter++;
                   returnVal = true;
                        if(checkCounter >1 ){
                    BlackKingShouldMove = true;
                break;
                }
                        }
                
                        }
            break;
        }
    }
    return returnVal;
}
/* the isBlackCheck function is temporary 
public boolean isBlackCheck(){
   int counter =0; 
    boolean blackCheck = false;
    for(int d = 0; d < 8;d++){
        for(int p=0; p<8;p++){
                           
                            
                             
            if(ColorOfPice[d][p] == 1){
System.out.println("are miad afarin "+ ""+counter);
counter++;
if(board[d][p].isMovable(BXP,BYP,board[d][p]))
                blackCheck = false;
            }
        }
    }
    return blackCheck;
}*/
    public boolean isCheckMate(boolean turn) {
        boolean bool = true;
        if (turn == true) {
            if(!isCheck(WXP + 1,WYP+1,true))
                bool = false;
            else if(bool == true && !isCheck(WXP +1, WYP,true))
              bool = false;
            else if(bool == true &&!isCheck(WXP +1,WYP-1,true))
               bool = false;
            else if(bool == true &&!isCheck(WXP,WYP-1,true))
                bool = false;
            else if(bool == true &&!isCheck(WXP,WYP+1,true))
                bool = false;
            else if(bool == true &&!isCheck(WXP-1,WYP-1,true))
                    bool = false;
            else if(bool == true &&!isCheck(WXP-1,WYP,true))
                bool = false;
            else if(bool == true &&!isCheck(WXP-1,WYP+1,true))
               bool = false;
                
                if(bool == true && !WhiteKingShouldMove){
            for (int d = 0; d < 8; d++) 
                for (int m = 0; m < 8; m++) {
                    if (ColorOfPice[d][m] == -1 && !(board[d][m] instanceof BPawn) && !(board[d][m] instanceof BHorse) && board[d][m].isMovable(WXP, WYP, board[d][m])) {
                        if (WXP > d && WYP > m) {
                            for (int q = 0; q < 8; q++) {
                                for (int b = 0; b < 8; b++) {
                                    if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                        int p = WYP - 1;
                                        for (int t = WXP - 1; t >= d; t--) {
                                            if (board[q][b].isMovable(t, p, board[t][p])) {
                                                break;
                                            }
                                        }
                                        p--;
                                    }
                                }
                            }
                        
                        } else if (WXP < d && WYP < m) {
                            for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                    if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                        
                                        int p = WYP + 1;
                                        for (int t = WXP + 1; t <= d; t++) {
                                            if (board[q][b].isMovable(t, p, board[t][p])) {
                                                break;
                                            }
                                            p++;
                                        }
                                    }
                                }
                          

                        }
                        else if (WXP < d && WYP > m) {
                           for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                    if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                        int p = WYP - 1;
                                         for (int t = WXP + 1; t <= d; t++) {
                                            if (board[q][b].isMovable(t, p, board[t][p])) {
                                                break;
                                            }
                                            p--;
                                        }
                                    }
                                }
                        } else if (WXP > d && WYP < m) {
                        for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                          if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                        int p = WYP + 1;
                                        for(int t = WXP; t>d;t--)
                                            if (board[q][b].isMovable(t, p, board[t][p])) {
                                                break;
                                            }
                                            p++;
                                }
                        }
                        
                }else if(WXP == d && WYP > m){
                    for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                    if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                         for(int p = m; p<WYP;p++)
                                            if (board[q][b].isMovable(d, p, board[d][p])) {
                                                break;
                                            }
                                    }
                                }
                    
                }else if(WXP == d && WYP < m){
                 for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                  if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                         for(int p = WYP; p<m;p++)
                                            if (board[q][b].isMovable(d, p, board[d][p])) {
                                                break;
                                            }
                                    }
                                
                                }
                
                }else if(WXP > d && WYP == m){
                 for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                             if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                         for(int p = WXP-1; p>d;p--)
                                            if (board[q][b].isMovable(p, m, board[p][m])) {
                                                break;
                                            }
                                    }
                                
                                }
                }else if(WXP < d && WYP == m){
                 for (int q = 0; q < 8; q++) 
                                for (int b = 0; b < 8; b++) {
                                             if (ColorOfPice[q][b] == 1 && !(board[q][b] instanceof King) && notPinned(q, b)) {
                                         for(int p = d; p<d;p--)
                                            if (board[q][b].isMovable(p, m, board[p][m])) {
                                                break;
                                            }
                                    }
                                
                
                                }}
                
                    }}}
       
        }
         return bool;
    }
                    /*else if(turn == false){
                                for(int d = 0;d<8;d++)
                  for(int m = 0;m<8;m++){
              if(ColorOfPice[d][m] == 1&&  (board[d][m] instanceof Queen&&board[d][m].isMovable(BXP, BYP, board[d][m]))){
                  if(BXP> d && BYP >m)
               // MoveShould :     // Move[x] > d &&Move[x] < BXP && Move[y] > m && Move[y] < BYP  && BXP - Move[X] == BYP - Move[y]; 

                   if(true){
                        BcheckCount++;
                     if( board[d][m].isMovable(BXP+1, BYP, board[d][m])||(board[d][m].isMovable(BXP-1, BYP, board[d][m])) )
                         HorizontalCheck = true;
                     if( board[d][m].isMovable(BXP, BYP+1, board[d][m])||(board[d][m].isMovable(BXP, BYP-1, board[d][m])) )
                         VerticalCheck = true;
                     if(BcheckCount == 2)
                       bool = true;
                                break;
                   }
                  }
                  }
              return bool;
          }*/
                
    
    
    public boolean notPinned(int i, int j) {
        boolean check = true;

        empty[i][j] = true;
        if (globTurn == true&&isCheck(WXP,WYP,globTurn)) {
            check = false;
          //  System.out.println(i +"asb " + j + " "+isCheck(WXP,WYP,true));
        }//else if(globTurn==false&&isCheck(BXP,BYP,globTurn))
        else if(globTurn== false&&isCheck(BXP,BYP,globTurn))
        {
            check = false;
        }
        empty[i][j] = false;

        return check;
    }

    //abstract  public void newPos(int i, int j,Move move);
    protected void wrongMove() {
        System.out.println("wrong move");
    }

    public boolean smallRCastlable(boolean small) {
        return small;
    }

    public boolean bigRCastlable(boolean big) {
        return big;
    }

    static public void smallCastle(King king, Rook smallRook, int i, int j) {
        king.newPos(i, j, new King());
        smallRook.newPos(i - 2, j, new Rook());

    }

    public void bigCastle(King king, bigRook bigRook, int i, int j) {
        king.newPos(i, j, new King());
        bigRook.newPos(i + 2, j, new bigRook());

    }
}
