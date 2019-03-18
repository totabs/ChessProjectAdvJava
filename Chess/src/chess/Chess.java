//SOROUSH AGHAJANI open the template in the editor.

package chess;

import static chess.Move.BXP;
import static chess.Move.BYP;
import static chess.Move.ColorOfPice;
import static chess.Move.WXP;
import static chess.Move.WYP;
import static chess.Move.board;
import static chess.Move.empty;
import static chess.Move.falser;
import static chess.Move.isEmpty;
import static chess.Move.isCheck;
import static chess.Move.traverser;
import static chess.Move.truer;

/**
 *
 * @author aghaj
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
Pawn pawn1 = new Pawn();
Pawn pawn2 = new Pawn();
Pawn pawn3 = new Pawn();
Pawn pawn4 = new Pawn();
Pawn pawn5 = new Pawn();
Pawn pawn6 = new Pawn();
Pawn pawn7 = new Pawn();
Pawn pawn8 = new Pawn();
        // TODO code application logic here
BPawn bpawn1 = new BPawn();
BPawn bpawn2 = new BPawn();
BPawn bpawn3 = new BPawn();
BPawn bpawn4 = new BPawn();
BPawn bpawn5 = new BPawn();
BPawn bpawn6 = new BPawn();
BPawn bpawn7 = new BPawn();
BPawn bpawn8 = new BPawn();
bigRook bigrook = new bigRook();
horse bigHorse = new horse();
Bishop bigBishop = new Bishop();
Queen queen = new Queen();
King king = new King();
Bishop smallBishop= new Bishop();
horse smallHorse = new horse();
Rook smallRook = new Rook(); 
//black
BBigRook bbigrook = new BBigRook();
BHorse bbigHorse = new BHorse();
BBishop bbigBishop = new BBishop();
BQueen bqueen = new BQueen();
BKing bking = new BKing();
BBishop bsmallBishop= new BBishop();
BHorse bsmallHorse = new BHorse();
BRook bsmallRook = new BRook(); 
pawn1.marker(0,1,pawn1);
pawn2.marker(1, 1, pawn2);
pawn3.marker(2, 1, pawn3);
pawn4.marker(3, 1, pawn4);
pawn5.marker(4, 1, pawn5);
pawn6.marker(5, 1, pawn6);
pawn7.marker(6, 1, pawn7);
pawn8.marker(7, 1, pawn8);
bigrook.marker(0,0,bigrook);
bigHorse.marker(1,0,bigHorse);
bigBishop.marker(2,0,bigBishop);
queen.marker(3, 0, queen);
king.marker(4, 0, king);
smallBishop.marker(5,0,smallBishop);
smallHorse.marker(6, 0, smallHorse);
smallRook.marker(7,0,smallRook);
// black marker
bpawn1.marker(0,6,bpawn1);
bpawn2.marker(1, 6, bpawn2);
bpawn3.marker(2, 6, bpawn3);
bpawn4.marker(3, 6, bpawn4);
bpawn5.marker(4, 6, bpawn5);
bpawn6.marker(5, 6, bpawn6);
bpawn7.marker(6, 6, bpawn7);
bpawn8.marker(7, 6, bpawn8);
bbigrook.marker(0,7,bbigrook);
bbigHorse.marker(1,7,bbigHorse);
bbigBishop.marker(2,7,bbigBishop);
bqueen.marker(3, 7, bqueen);
bking.marker(4, 7, bking);
bsmallBishop.marker(5,7,bsmallBishop);
bsmallHorse.marker(6, 7, bsmallHorse);
bsmallRook.marker(7,7,bsmallRook);
        traverser();
        truer();
        falser();




//smallBishop.move(4,1,true,smallBishop);

//pawn4.move(3,3,true,pawn4);
//smallHorse.move(5, 2, true, smallHorse);
//bigHorse.move(0,2,true,bigHorse);
//smallRook.move(6,0,true,smallRook);
//bigrook.move(4, 0, true, bigrook);
//System.out.println(isEmpty(6,0));

//queen.move(3,1,true,queen);





//pawn6.move(5, 2, true,pawn6);
//bpawn6.move(5, 4, true,bpawn6);

//bigBishop.move(3,1,true,bigBishop);
//pawn5.move(3,0,true);
System.out.println(empty[3][1] + "is");
pawn4.move(3, 3, true,pawn4);
bpawn4.move(3, 4, true, bpawn4);

pawn5.move(4,3,true,pawn5);

System.out.println(WXP+" moshkele to injast" + WYP);
//smallHorse.move(7,2,true,smallHorse);

bpawn3.move(2,5,true,bpawn3);
bigHorse.move(0,2,true,bigHorse);
//bpawn8.move(7,4,true,bpawn8);
bsmallHorse.move(7, 5, true, bsmallHorse);
queen.move(4,1,true,queen);
bsmallHorse.move(6, 7, true, bsmallHorse);
queen.move(3,0,true,queen);
bpawn2.move(1, 4, true,bpawn2);

System.out.println(empty[3][1]);
queen.move(7,4,true,queen);
bsmallHorse.move(7, 5, true, bsmallHorse);

//smallHorse.move(7,2,true,smallHorse);
queen.move(6, 3, true, queen);
bpawn6.move(5, 5, true, bpawn6);
queen.move(3, 6, true, queen);
bpawn5.move(4, 5, true, bpawn5);
queen.move(2, 5, true, queen);
//queen.move(4,7,true,queen);
//bpawn6.move(5,5,true,bpawn6);
    }
    
}
