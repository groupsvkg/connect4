import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Game is the main class to execute the Connect4(N) application.
 * Below setup enables human and computer player to play Connect4 on a 
 * board with 6 rows, 7 column and N equal to 4. board rows, columns and match length
 * can be changed while creating SimpleBoard class object.
 */
public class Connect4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Player> players = new ArrayList<Player>();

        /**
         * One human and one Computer player is created for the board game to match Requirement. 
         * Objects wiring up can be handled by creations patters like Factory method, 
         * Builder, or Abstract Factory patterns.
         */
        players.add(new HumanPlayer("Human", new ColoredToken('R', Colors.BRIGHT_RED)));
        players.add(new ComputerPlayer("Computer", new ColoredToken('B', Colors.BRIGHT_BLUE)));

        Board board = new SimpleBoard(6, 7, players, 4);

        /**
         * ColoredBoardDisplay might not work on Windows
         */
        BoardDisplay boardDisplay = new ColoredBoardDisplay();

        /**
         * SimpleBoardDisplay works on all platform including Windows.
         */
        // BoardDisplay boardDisplay = new SimpleBoardDisplay();

        /**
         * BoardController instantiated which creates game View and hence user input from View
         * is fead to BoardController for validation and model update.
         */
        Controller controller = new BoardController(board, boardDisplay);
        controller.play();
    }
}