package Players;

import Exceptions.InvalidMove;
import Game_Mechanics.Board;
import Game_Mechanics.Position;

import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player
{
    Random rand ;

    public RandomPlayer(){
        this.rand = new Random();
    }
    @Override
    public Position selectMove(Board b) throws InvalidMove {
        List<Position> freeSquares = b.getFreeSquares();
        int randomIndex = rand.nextInt(freeSquares.size());

        return freeSquares.get(randomIndex);
    }
}
