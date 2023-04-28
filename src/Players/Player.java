package Players;

import Exceptions.InvalidMove;
import Game_Mechanics.Board;
import Game_Mechanics.Position;

;
public abstract class Player {
    public Symbol turn;

    public abstract Position selectMove(Board b) throws InvalidMove;
}
