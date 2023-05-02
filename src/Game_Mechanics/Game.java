package Game_Mechanics;

import Exceptions.InvalidMove;
import Players.Player;
import Players.Symbol;

public class Game {



    private Symbol turn;
    private Player player1;
    private Player player2;
    private Board board;
    public Game(Player player1,Player player2){
        this.turn = Symbol.X;
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
    }

    public void play() {

        Position move= null;

        while(board.shouldContinueGame()){
            board.display();
            try{
                if(turn.equals(Symbol.X)){
                    move = player1.selectMove(board);
                }else{
                    move = player2.selectMove(board);
                }
                board.makeMove(move,turn);
                turn = (turn==Symbol.X)? Symbol.O : Symbol.X;
                System.out.printf("%s moved to %s\n",turn,move);
            }catch (InvalidMove e){
                System.out.println(e.getMessage());
                System.out.println("Please try again!");
            }


        }
        board.display();
        Symbol winner = board.winner();

        if(winner==null)
            System.out.println("That was a tie.");
        else
            System.out.printf("Player %d has won.\n",(winner==Symbol.X)?1:2);


    }
}
