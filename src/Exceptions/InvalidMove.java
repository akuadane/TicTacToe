package Exceptions;

public class InvalidMove extends Exception{

    public InvalidMove(String exception){
        super(exception);
    }

    public InvalidMove(){
        super("Invalid move");
    }
}
