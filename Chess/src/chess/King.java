// SOROUSH AGHAJANI
package chess;

/**
 *
 * @author aghaj
 */
public class King extends Move{
        private  int i;
    private  int j;

   private static boolean ischeck;
    private boolean neverMoved;
     protected void move(int i, int j, boolean turn, Move king){
         if(globTurn&& Math.abs(getXPos()-i) == 1 || getXPos() == i && Math.abs(getYPos() - j )== 1 || getYPos()== j&& isMovable(i,j,king) && !isOpp(i,j)){
             newPos(i,j,king);
             WXP =i;
             WYP = j;
             neverMoved = false;
         }
         else if(globTurn&& Math.abs(getXPos()-i) == 1 || getXPos() == i && Math.abs(getYPos() - j )== 1 || getYPos()== j &&isMovable(i,j,king)&& !isOpp(i,j)){
             hit(i,j,this.i,this.j,king);
                          WXP =i;
             WYP = j;
             neverMoved = false;
         }
         else if(globTurn&&neverMoved && smallCastlable &&!isCheck()&& i == 6){
            smallCastle(new King(),new Rook(),i,j);
                         WXP =i;
             WYP = j;
             neverMoved = false;
         }
         else if(globTurn&& neverMoved && bigCastlable &&!isCheck()&& i == 1){
             bigCastle(new King(), new bigRook(),i,j);
                          WXP =i;
             WYP = j;
             neverMoved = false;
             
         }
         else 
             wrongMove();
     }
     
     private boolean isCheck(){
         return ischeck;
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
