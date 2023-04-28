package Game_Mechanics;

import Exceptions.InvalidMove;

public class Position {
    private int r;
    private int c;

    public Position(int r, int c) throws InvalidMove{
        if(r<0 || r>2 || c<0 || c>2)
            throw new InvalidMove("Invalid column or row");

        this.r = r;
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }
}
