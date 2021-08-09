/**
 * Token is an abstract class holding token character associated with player
 */
public abstract class Token {
    protected char token;

    /**
     * Constructor to create Token object for a character input
     * @param token is the character associated with player
     */
    public Token(char token) {
        this.token = token;
    }

    /**
     * @return the token value.
     */
    public char getToken() {
        return token;
    }

}
