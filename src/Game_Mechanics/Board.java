package Game_Mechanics;

import Exceptions.InvalidMove;
import Players.Symbol;

public class Board {
    private Symbol[][] board;
    private Symbol turn;

    public Board(){
        this.board = new Symbol[3][3];
        this.turn = Symbol.X;
    }

    public void display(){
        for (int i = 0; i < board.length; i++) {
            for(Symbol symb: board[i]){
                System.out.printf("%s ",symb);
            }
            System.out.println();
        }
    }

    public void makeMove(Move mv) throws InvalidMove{
        int r = mv.getR(), c = mv.getC();

        if(board[r][c]!=null)
            throw new InvalidMove("Square already occupied."); // check if the square is empty

        board[r][c] = turn;
        turn = (turn==Symbol.O)? Symbol.X : Symbol.O; // Changes the turn after making a move
    }
}