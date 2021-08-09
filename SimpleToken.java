/**
 * SimpleToken is a concrete class holding only Token character
 */
public class SimpleToken extends Token {

    /**
     * default constructor which populates token with blank space.
     */
    public SimpleToken() {
        super(' ');
    }

    /**
     * Constructor taking token character as input
     * @param token
     */
    public SimpleToken(char token) {
        super(token);
    }

    @Override
    public String toString() {
        return String.valueOf(token);
    }
}
