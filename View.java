/**
 * View is an interface for describing apis for user input of messages from Controller
 */
public interface View {
    /**
     * Api to display welcome message
     */
    void displayWelcomeMessage();

    /**
     * Api to render game board
     */
    void displayBoard();

    /**
     * Api to recieve error message
     * @param error
     */
    void displayErrorMessage(String error);

    /**
     * Api to recieve player input
     */
    String getUserInput();

    /**
     * Api to start board rendering
     */
    void play();
}
