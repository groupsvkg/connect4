import java.util.Random;

/**
 * ComputerPlayer is a concrete class which represents computer as a player
 */
public class ComputerPlayer extends Player {

    /**
     * Constructor which takes player name and token as input
     * 
     * @param name      is the name of player.
     * @param token     is the token associated with player move.
     */
    public ComputerPlayer(String name, Token token) {
        super(name, token);
    }

    /**
     * 
     * @param column is the total number of column in board
     * 
     * @return a random number in the form of String between [ 1 - column ] with a delay of 500 milliseconds
     */
    @Override
    String getMove(int column) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return String.valueOf(random.nextInt(column));
    }

}
