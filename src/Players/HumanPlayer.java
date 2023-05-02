package Players;

import Exceptions.InvalidMove;
import Game_Mechanics.Board;
import Game_Mechanics.Position;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private String name;
    private Scanner scanner;

    public HumanPlayer(String name){
        this.name = name;
        this.scanner = new Scanner(System.in);
    }
    @Override
    public Position selectMove(Board b) throws InvalidMove {

        System.out.print("> ");
        int square = scanner.nextInt();
        int r = square/3;
        int c = square%3;

        Position mv = new Position(r,c);
        if(b.isEmpty(mv))
            return mv;

        throw new InvalidMove("Square is already occupied");

    }
}
