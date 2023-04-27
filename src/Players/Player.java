package Players;

import Game_Mechanics.Board;
import Game_Mechanics.Move;

;
public abstract class Player {
    public Symbol turn;

    public abstract Move selectMove(Board b);
}
