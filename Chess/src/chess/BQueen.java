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
public class BQueen extends Move{
    private static boolean empt = true;
    private int i;
    private int j;

    protected void move(int i, int j, boolean turn, Move BQueen) {

        if (!globTurn && Math.abs(i - getXPos()) == Math.abs(j - getYPos()) && isMovable(i, j, BQueen) && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            System.out.println(isMovable(i, j, BQueen));
            marker(i, j, BQueen);
        } else if ( !globTurn && getXPos() == i && getYPos() < j && j < 8 && j >= 0 && isMovable(i, j, BQueen)  && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {

            marker(i, j, BQueen);
         
        } 
        else if ( !globTurn && getXPos() == i && getYPos() > j && j < 8 && j >= 0 && isMovable(i, j, BQueen)  && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            marker(i, j, BQueen);
        } 
        else if (!globTurn && getYPos() == j && getXPos() > i && i < 8 && i >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            System.out.println(isMovable(i, j, BQueen));
            marker(i, j, BQueen);
            
        } 
                else if (!globTurn && getYPos() == j && getXPos() < i && i < 8 && i >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) &&  isEmpty(i,j) ) {
            System.out.println(isMovable(i, j, BQueen));
            marker(i, j, BQueen);
            
        }else if (!globTurn && getYPos() == j && getXPos() > i && i < 8 && i >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) && isOpp(i, j)) {
            hit(i, j,this.i,this.j,BQueen);
        } 
        else if (!globTurn && getYPos() == j && getXPos() < i  && i < 8 && i >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) && isOpp(i, j)) {
            hit(i, j,this.i,this.j,BQueen);
        } 
        else if (!globTurn && getXPos() == i && getYPos() < j  && j < 8 && j >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) && isOpp(i, j)) {
            hit(i, j,this.i,this.j,BQueen);

        } 
        else if (!globTurn && getXPos() == i && getYPos() > j && j < 8 && j >= 0 && isMovable(i, j, BQueen) && notPinned(this.i,this.j) && isOpp(i, j)) {
            hit(i, j,this.i,this.j,BQueen);

        } 
        else if (!globTurn && Math.abs(i - getXPos()) == Math.abs(j - getYPos()) && isOpp(i, j) && isMovable(i, j, BQueen) && notPinned(this.i,this.j)) {
            hit(i, j,this.i,this.j,BQueen);
        } else {
            wrongMove();
        }

    }

    protected boolean isMovable(int i, int j, Move BQueen) {
        boolean isempty = false;

        if (this.i < i && this.j < j) {
               if(Math.abs(this.i-i)==1&& Math.abs(this.j-j)== 1&&(isEmpty(i,j)||isOpp(i,j))){
                    isempty = true;
                }
 int p = this.j + 1;
            for (int d = this.i + 1; d < i; d++) {
               
                if (!isEmpty(d, p)) {
                   isempty = false;
                    break;
                }
                isempty = true;
                p++;
            }
        } else if (getYPos() > j && getXPos() == i) {
if(Math.abs(this.j-j)== 1&&(isEmpty(i,j)||isOpp(i,j))){
    isempty = true;
}
            for (int d = getYPos() - 1; d > j; d--) {
                if (!isEmpty(i, d)) {
                    isempty = false;
                    //System.out.println(isEmpty(i,d));
                    
                }
                isempty = true;
            }

        }else if (this.i > i && this.j < j) {
            int p = this.j + 1;
            for (int d = this.i - 1; d > i; d--) {
                if (!isEmpty(d, p)) {
                    isempty = false;
                    // System.out.println(isEmpty(d,p));
                    break;
                }
                
                isempty = true;
                p++;
            }
        } else if (this.i > i && this.j > j) {
            for (int d = this.i - 1; d > i; d--) {
                if (!isEmpty(d, d)) {
                    isempty = false;
                    // System.out.println(isEmpty(d,d));
                    break;
                }
                isempty = true;
            }
        } else if (this.i < i && this.j > j) {
            int q = this.j - 1;
            for (int d = this.i + 1; d < i; d++) {
                if (!isEmpty(d, q)) {
                    isempty = false;
                    //   System.out.println(isEmpty(d,q));
                    break;
                }
                isempty = true;
                q--;
            }
        } else if (this.i < i && this.j == j) {
            for (int d = i; d > this.i; d--) {
                if (!isEmpty(d, j)) {
                    //System.out.println(isEmpty(d,j));
                    isempty = false;
                    break;
                }
                isempty = true;
            }
        } else if (getXPos() > i && getYPos() == j) {
            for (int d = getXPos() - 1; d > i; d--) {
                if (!isEmpty(d, j)) {
                   isempty = false;
                    //System.out.println(isEmpty(d,j));
                    break;
                }
                isempty = true;
            }
        } else if (this.j < j && this.i == i) {

            for (int d = this.j + 1; d < j; d++) {
                if (!isEmpty(i, d)) {
                    isempty = false;
break;
                 
                }
isempty = true;
            }

        } 

        return isempty;
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
        this.i = i;
    }

    @Override
    protected void setYPos(int j) {
        this.j = j;
    }

}
