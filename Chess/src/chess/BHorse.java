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
public class BHorse extends Move {

 private  int i;
    private  int j;
    
    protected boolean isMovable(int i, int j,Move horse){
        boolean isempty= false;
        if(isEmpty(i,j)|| board[i][j] instanceof BKing  ){
            if((Math.abs(this.i - i) == 2 &&Math.abs(this.j - j)==1) ||(Math.abs(this.j - j) == 2 &&Math.abs(this.i - i)==1) )
        isempty = true;
        }
        return isempty;
    }
    public void move(int i,int j,boolean color,Move BHorse){
        if(!globTurn &&(getXPos()+ 2) == i && (getYPos()+1) == j&& notPinned(this.i,this.j)&&isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()+ 2) == i && (getYPos()-1) == j&& notPinned(this.i,this.j)&& isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()+ 1) == i && (getYPos()+2) == j&& notPinned(this.i,this.j)&& isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()+ 1) == i && (getYPos()-2) == j&& isEmpty(i,j)&& notPinned(this.i,this.j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()- 2) == i && (getYPos()-1) == j&& notPinned(this.i,this.j)&& isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()- 2) == i && (getYPos()+1) == j&& notPinned(this.i,this.j)&& isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()- 1) == i && (getYPos()-2) == j&& notPinned(this.i,this.j)&& isEmpty(i,j))
            marker(i,j,BHorse);
        else if(!globTurn &&(getXPos()- 1) == i && (getYPos()+2) == j&& notPinned(this.i,this.j)){
            marker(i,j,BHorse);
        }
               else if(!globTurn &&(getXPos()+ 2) == i && (getYPos()+1) == j&& notPinned(this.i,this.j)&&isOpp(i,j))
            hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()+ 2) == i && (getYPos()-1) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
            hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()+ 1) == i && (getYPos()+2) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
             hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()+ 1) == i && (getYPos()-2) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
            hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()- 2) == i && (getYPos()-1) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
             hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()- 2) == i && (getYPos()+1) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
             hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()- 1) == i && (getYPos()-2) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
             hit(i,j,this.i,this.j,BHorse);
        else if(!globTurn &&(getXPos()- 1) == i && (getYPos()+2) == j&& notPinned(this.i,this.j)&& isOpp(i,j))
             hit(i,j,this.i,this.j,BHorse);
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
