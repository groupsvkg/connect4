/**
 * ColoredToken is a concrete class which hold the Token in colored form.
 */
public class ColoredToken extends Token {
    String color;

    /**
     * ColoredToken is default constructor with pre-initialized token value.
     */
    public ColoredToken() {
        super(' ');
        this.color = Colors.BACKGROUND_BRIGHT_WHITE;
    }

    /**
     * Constructor which accepts token character as input
     * 
     * @param token is a token character.
     */
    public ColoredToken(char token) {
        super(token);
        this.color = Colors.BACKGROUND_BRIGHT_WHITE + Colors.BRIGHT_GREEN;
    }

    /**
     * Constructor which accepts both token character and color.
     * 
     * @param token is a token character
     * @param color is a color to be applied during rendering.
     */
    public ColoredToken(char token, String color) {
        super(token);
        this.color = color;
    }

    @Override
    public String toString() {
        return color + token + Colors.RESET;
    }

}
