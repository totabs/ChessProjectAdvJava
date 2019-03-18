//SOROUSH AGHAJANI
package chess;

/**
 *
 * @author aghaj
 */
public class Bishop extends Move{
    private  int i;
    private  int j;
    protected boolean isMovable(int i, int j,Move Bishop){
        boolean isempty = false;
        if(this.i < i && this.j < j&&Math.abs(i-this.i) == Math.abs(j-this.j)){
            int p = this.j;
            for(int d = this.i +1; d < i ;d++){
                if(!isEmpty(d,p)){
                    // injash kharabe bepa
                    isempty = false;
                break;
                }
                isempty = true;
                p++;
            }
        }
        else if (this.i > i && this.j <j&&Math.abs(i-this.i) == Math.abs(j-this.j)){
            int p = this.j +1;
            for(int d = this.i -1 ; d> i; d--){
                if(!isEmpty(d,p)){
                    isempty = false;
                    break;
                }
                isempty = true;
            p++;
        }
        }
        else if(this.i > i && this.j> j&&Math.abs(i-this.i) == Math.abs(j-this.j)){
            for(int d = this.i -1;d>i;d--){
                if(!isEmpty(d,d)){
                    isempty = false;
                    break;
                }
                isempty = true;
            }
        }
        else if(this.i<i && this.j>j&&Math.abs(i-this.i) == Math.abs(j-this.j)){
            int q = this.j -1;
            for(int d = this.i +1; d < i;d++){
                if(!isEmpty(d,q)){
                    isempty = false;
                    break;
                }
                isempty = true;
            q--;
            }
        }
        return isempty;
    }
    public void move(int i , int j, boolean turn,Move Bishop){
    if(globTurn&& Math.abs(i - getXPos()) == Math.abs(j - getYPos())&&isMovable(i,j,Bishop)&& notPinned(this.i,this.j) &&  isEmpty(i,j) ){
        marker(i,j,Bishop);

       
    }
    else if (globTurn && Math.abs(i - getXPos()) == Math.abs(j - getYPos())&& isOpp(i,j)&& isMovable(i,j,Bishop)&& notPinned(this.i,this.j)){
            
        hit(i,j,this.i,this.j,Bishop);

    }
    else
        wrongMove();
}


    @Override
    protected int getXPos() {
        return this.i;
    }

    @Override
    protected int getYPos() {
return this.j;
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
