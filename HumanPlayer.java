import java.io.BufferedReader;
import java.io.IOException;

/**
 * HumanPlayer is a concrete class representing human player
 */
public class HumanPlayer extends Player {
    private BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

    /**
     * Constructore for creating human object 
     * 
     * @param name      is the name of player
     * @param token     is the token associated with the player and used for rendering
     */
    public HumanPlayer(String name, Token token) {
        super(name, token);
    }

    /**
     * getMove method gets input from human player
     * 
     * @param column    is the total number of column in the board
     * @return  input recieved from human player.
     */
    @Override
    String getMove(int column) {
        String move = "";
        try {
            move = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return move;
    }

}
