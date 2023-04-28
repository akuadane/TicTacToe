package Game_Mechanics;

import Exceptions.InvalidMove;
import Players.Symbol;

public class Board {
    private Symbol[][] board;
    private Symbol turn;

    public Board() {
        this.board = new Symbol[3][3];
        this.turn = Symbol.X;
    }

    public void display() {
        for (Symbol[] symbols : board) {
            System.out.print("|");
            for (Symbol symb : symbols) {
                if (symb == null)
                    System.out.print("   |");
                else
                    System.out.printf(" %s |", symb);
            }
            System.out.println();
        }
    }

    public void makeMove(Position mv) throws InvalidMove {
        int r = mv.getR(), c = mv.getC();

        if (board[r][c] != null)
            throw new InvalidMove("Square already occupied."); // check if the square is empty

        board[r][c] = turn;
        turn = (turn == Symbol.O) ? Symbol.X : Symbol.O; // Changes the turn after making a move
    }

    public Symbol getPiece(Position pos){
        return board[pos.getR()][pos.getC()];
    }

    public boolean isEmpty(Position pos){
        return board[pos.getR()][pos.getC()] == null;
    }

    @Override
    public String toString() {
        String str = "";
        for (Symbol[] symbols : board) {

            for (Symbol symb : symbols) {
                if (symb == null)
                    str += "N";
                else
                    str += symb;
            }
        }
        return str;
    }


}
