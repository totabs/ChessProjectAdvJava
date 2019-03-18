/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import static chess.Move.isEmpty;
import static chess.Move.smallCastle;

/**
 *
 * @author aghaj
 */
public class BKing extends Move {
            private  int i;
    private  int j;

   private static boolean ischeck;
    private boolean neverMoved;
     protected void move(int i, int j, boolean turn,  Move bking){
         if(!globTurn && Math.abs(getXPos()-i) == 1 || getXPos() == i && Math.abs(getYPos() - j )== 1 || getYPos()== j&& isMovable(i,j,bking) && !isOpp(i,j)){
             marker(i,j,bking);
             BXP = i;
             BYP = j;
             neverMoved = false;
         }
         else if(!globTurn && Math.abs(getXPos()-i) == 1 || getXPos() == i && Math.abs(getYPos() - j )== 1 || getYPos()== j &&isMovable(i,j,bking)&& !isOpp(i,j)){
             hit(i,j,this.i,this.j,bking);
                          BXP = i;
             BYP = j;
             neverMoved = false;
         }
         //Should be adjusted to black King pos
         else if(!globTurn &&neverMoved && smallCastlable &&!isCheck(BXP,BYP,false)&& i == 6){
            smallCastle(new King(),new Rook(),i,j);
                         BXP = i;
             BYP = j;
             neverMoved = false;
         }
         //Should be adjusted to black King pos
         else if(!globTurn &&neverMoved && bigCastlable &&!isCheck(BXP,BYP,false)&& i == 1){
             bigCastle(new King(), new bigRook(),i,j);
                          BXP = i;
             BYP = j;
             neverMoved = false;
             
         }
         else 
             wrongMove();
     }
     

/*
     private boolean isSmallCastlable(){
         boolean bool = false;
         if(neverMoved && smallRCastlable(smallCastlable)){
            bool = true;
         }
         return bool;
     }
     */

    protected boolean isMovable(int i,int j,Move king){
        //check to see if the new place is under the range of opponent
        //check to make sure there is not the same type of pice on that spot
        boolean returnval = false;
        if((Math.abs(i-this.i)==1&&Math.abs(j-this.j) == 1)||(Math.abs(i-this.i)==1&& this.j ==j)||(Math.abs(j-this.j)==1&& this.i ==i)){
        if(isEmpty(i,j))
            returnval = true;
        
        
        }
return returnval;
}

    @Override
    protected int getXPos() {
return this.i;
    }

    @Override
    protected int getYPos() {
return this.j;    }

    @Override
    protected void setXPos(int i) {
         this.i =i;
    }

    @Override
    protected void setYPos(int j) {
        this.j = j;
    }


}
