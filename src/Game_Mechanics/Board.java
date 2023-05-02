package Game_Mechanics;

import Exceptions.InvalidMove;
import Players.Symbol;

public class Board {
    private Symbol[][] board;


    public Board() {
        this.board = new Symbol[3][3];

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

    public void makeMove(Position mv,Symbol turn) throws InvalidMove {
        int r = mv.getR(), c = mv.getC();

        if (board[r][c] != null)
            throw new InvalidMove("Square already occupied."); // check if the square is empty

        board[r][c] = turn;

    }

    public boolean isGameOver(){
        return false; // TODO implement this method
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
