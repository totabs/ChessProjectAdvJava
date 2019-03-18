/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author aghaj
 */
public class BPawn  extends Move{
        private  int i ;
    private  int j ;
    boolean movable;
    boolean isKing;
    boolean isUnpasan;
    
    private void Promotion(int i,int j){
                if(j==0)
            board[i][j] = new Queen();
    }
    protected boolean isMovable(int i, int j,Move pawn){
       
        boolean isempty = false;
        for(int d = j; d < pawn.getYPos();d++){
            if(!isEmpty(i,d)){
                isempty = false;
                break;
               
            }
            isempty = true;
        }
        return isempty;
    }

    private void unpasan(){
        
    }
     @Override
    public void move(int i, int j, boolean color, Move pawn){
        // Moshkelesh az isMovable() hast
        if(!globTurn &&i ==  pawn.getXPos() &&( j == 5 || j ==4)&& isMovable(i,j,pawn)&& notPinned(this.i,this.j)&& !isOpp(i,j)){
        marker(i,j,pawn);
    }
        else if(!globTurn &&i== getXPos()&& j == getYPos()-1 && j <7 && j >=0&& notPinned(this.i,this.j) && isMovable(i,j,pawn)&& !isOpp(i,j) ){
        marker(i,j,pawn);
        if( j == 0){
            Promotion(i,j);
        }
    }
        else if(!globTurn &&(getXPos() +1) == i&& j ==(getYPos()+1) || i == (getXPos() - 1) && j ==(getYPos()+1) && isOpp(i,j) && notPinned(this.i,this.j) ){
            hit(i,j,this.i,this.j,pawn);
                    if( j == 0){
            Promotion(i,j);
        }
        }

        else 
            wrongMove();
    }

    @Override
    protected int getXPos() {
        
        return i;
    }

    @Override
    protected int getYPos() {
        return j;
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
