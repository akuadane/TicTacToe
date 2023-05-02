package Game_Mechanics;

import Exceptions.InvalidMove;
import Players.Symbol;

import java.util.ArrayList;
import java.util.List;

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

    public Symbol winner(){

        if(board[0][0]!=null && board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]))
            return board[0][0];
        else if(board[0][0]!=null && board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]))
            return board[0][0];
        else if(board[0][0]!=null && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
            return board[0][0];
        else if(board[0][1]!=null && board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]))
            return board[0][1];
        else if(board[0][2]!=null && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
            return board[0][2];
        else if(board[0][2]!=null && board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]))
            return board[0][2];
        else if(board[1][0]!=null && board[1][0]!=null && board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]))
            return board[1][0];
        else if(board[2][0]!=null && board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]))
            return board[2][0];
        return null;
    }

    public boolean shouldContinueGame(){

        boolean hasEmptySquare = false;

        for (Symbol[] symbols :
                board) {
            for (Symbol square : symbols){
                if(square==null){
                    hasEmptySquare = true;
                    break;
                }
                if(hasEmptySquare)
                    break;
            }

        }

        return hasEmptySquare && winner()==null;

    }

    public List<Position> getFreeSquares() throws InvalidMove {
        List<Position> freeSquares = new ArrayList<>();
        for(int i=0;i< board.length;i++)
            for(int j=0;j< board.length;j++)
                if(board[i][j]==null)
                    freeSquares.add(new Position(i,j));

        return freeSquares;
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
