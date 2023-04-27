import Exceptions.InvalidMove;
import Game_Mechanics.Board;
import Game_Mechanics.Move;

public class Main {
    public static void main(String[] args) throws InvalidMove {
        Board board = new Board();
        board.display();
        board.makeMove(new Move(1,1));
        board.display();
    }
}