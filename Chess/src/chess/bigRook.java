//SOROUSH AGHAJANI
package chess;

/**
 *
 * @author aghaj
 */
public class bigRook extends Move{
    
  private  int i;
    private  int j;
    protected void move(int i, int j, boolean turn ,Move bigRook){
        counter++;
         if ( globTurn&& getXPos() == i && getYPos() < j && j < 8 && j >= 0 && isMovable(i, j, bigRook)  && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            marker(i, j, bigRook);
               bigCastlable = false;
        } 
        else if ( globTurn&& getXPos() == i && getYPos() > j && j < 8 && j >= 0 && isMovable(i, j, bigRook)  && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            marker(i, j, bigRook);
               bigCastlable = false;
        } 
        // inja be baad

        else if(globTurn&&getYPos() == j &&   getXPos() > i && i < 8 && i >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j) &&  isEmpty(i,j)  ){
        marker(i,j,bigRook);
           bigCastlable = false;
        }
             else if(globTurn&&getYPos() == j &&  getXPos() < i  && i < 8 && i >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j) &&  isEmpty(i,j) ){
        marker(i,j,bigRook);
          bigCastlable = false;
        }
                else if(globTurn&&getYPos() == j &&  getXPos() > i && i < 8 && i >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j) &&  isOpp(i,j) ){
        hit(i,j,this.i,this.j,bigRook);
      bigCastlable = false;
                }
                 else if(globTurn&&getYPos() == j &&  getXPos() < i && i < 8 && i >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j) &&  isOpp(i,j) ){
        hit(i,j,this.i,this.j,bigRook);
          bigCastlable = false;
                }
              else if(globTurn&&getXPos()==i && getYPos() < j  && j < 8 && j >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j)&& isOpp(i,j)){
            hit(i,j,this.i,this.j,bigRook);
              bigCastlable = false;
              }
                        else if(globTurn&&getXPos()==i &&  getYPos() > j && j < 8 && j >= 0 &&isMovable(i,j,bigRook)&& notPinned(this.i,this.j)&& isOpp(i,j)){
            hit(i,j,this.i,this.j,bigRook);
               bigCastlable = false;
              }
    }
        // men baad man bad
       
    





    @Override
    protected int getXPos() {
return this.i;
    }

    @Override
    protected int getYPos() {

return this.j;
    }


     protected boolean isMovable(int i,int j, Move bigRook){
         boolean isempty = true;
         if(getXPos() < i && getYPos() == j){
        for(int d = getXPos()+1 ; d < i; d++ ){
            if(!isEmpty(d,j)){
                isempty = false;
                break;
            }     
            isempty = true;
        }
         }
       else if(getXPos() > i && getYPos() == j){
        for(int d = getXPos() - 1 ; d > i; d-- ){
            if(!isEmpty(d,j)){
                isempty = false;
                break;
            }              
            isempty = true;
        }
         }
                else if(getYPos() < j && getXPos() == i){
        for(int d = getYPos() +1 ; d < j; d++ ){
            if(!isEmpty(i,d)){
                isempty = false;
                break;
            }              
            isempty = true;
        }
         }
                else if(getYPos() > j && getYPos() == i){
        for(int d = getYPos() - 1 ; d > j; d-- ){
            if(!isEmpty(i,d)){
                isempty = false;
                break;
            }              
            isempty = true;
        }
         }
         return isempty;
    }


    @Override
    protected void setXPos(int i) {
         this.i =i;
    }

    @Override
    protected void setYPos(int j) {
        this.j = j;
    }




}
