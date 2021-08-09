/**
 * Player is an abstract class to capture the general idea of a player.
 */
public abstract class Player {

    protected String name;
    protected Token token;

    /**
     * Constructor to be used by subclasses to populate name and token
     * 
     * @param name  is the name of the player
     * @param token is the token associated with the player
     */
    public Player(String name, Token token) {
        this.name = name;
        this.token = token;
    }

    /**
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * @return token associated with the player
     */
    public Token getToken() {
        return token;
    }

    /**
     * getMove is an abstract method to be implemented by subclasses i.e. HumanPlayer and ComputerPlayer
     * 
     * @param column    is the total number of columns in board
     * @return  input recieved from player
     */
    abstract String getMove(int column);

    @Override
    public String toString() {
        return "Player [name=" + name + ", token=" + token + "]";
    }

}
