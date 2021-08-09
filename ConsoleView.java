import java.util.List;

/**
 * ConsoleView is a concrete class which encapsulate rendering of View in console.
 */
public class ConsoleView implements View {
    private Controller controller;
    private Board board;
    private BoardDisplay boardDisplay;
    private String error;

    /**
     * Constructor to create View
     * 
     * @param controller    takes inputs from View and updates with as well
     * @param board         holds application state
     * @param boardDisplay  holds rendering logic i.e. Simple or Colored
     */
    public ConsoleView(Controller controller, Board board, BoardDisplay boardDisplay) {
        this.controller = controller;
        this.board = board;
        this.boardDisplay = boardDisplay;
        this.error = "";
    }

    /**
     * Displays welcome message to player.
     */
    @Override
    public void displayWelcomeMessage() {
        int matchLendth = this.board.getMatchLength();
        List<Player> players = this.board.getPlayers();
        System.out.println("Welcome to Connect " + matchLendth + "\n");
        System.out.println("There are " + players.size() + " players");
        for (Player player : players) {
            System.out.println(player.getName() + ", Token - " + player.getToken());

        }
        System.out.println("\nTo play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting " + matchLendth
                + " counters in a row - vertically, horizontally or diagonally\n");
        if (this.error != "") {
            System.out.println(Colors.BRIGHT_RED + "Error: " + this.error + Colors.RESET);
        }
    }

    /**
     * displayBoard method renders the welcome message and the board as well.
     */
    @Override
    public void displayBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("");
        this.displayWelcomeMessage();
        this.boardDisplay.display(this.board);
    }

    /**
     * displayErrorMessage method is called by Controller to update View in case of error.
     * 
     * @param error contains error message recieved from Controller
     */
    @Override
    public void displayErrorMessage(String error) {
        this.error = error;
    }

    /**
     * getUserInput method recieves player input.
     */
    @Override
    public String getUserInput() {
        Player player = this.board.getCurrentPlayer();
        System.out.print("\n" + player.getName() + " to move: ");
        String move = player.getMove(this.board.getCoulmns());
        System.out.println("");
        return move;
    }

    /**
     * play method is the starting point for board rendering and collects player input
     * until Game is WON or DRAW.
     */
    @Override
    public void play() {
        while (true) {
            this.displayBoard();
            String column = this.getUserInput();
            boolean result = this.controller.setToken(column);

            if (result) {
                this.error = "";
                Player player = this.board.getCurrentPlayer();
                State state = this.board.getState();

                if (state == State.DRAW) {
                    this.displayBoard();
                    System.out.println("\nGame ended in a DRAW\n");
                    break;
                }

                if (state == State.WON) {
                    this.displayBoard();
                    System.out.println("\n" + player.getName() + " WON!\n");
                    break;
                }
                this.board.getNextPlayer();
            }
        }
    }

}
