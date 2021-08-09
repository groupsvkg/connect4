import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Game is the main class to execute the ConnectN application.
 * Below setup enables one human and two Computer player to play ConnectN on a 
 * board with 8 rows, 9 column and N equal to 5 . board rows, columns and match length
 * can be changed while creating SimpleBoard class object.
 */
public class ConnectN {
    public static void main(String[] args) throws IOException, InterruptedException {
        int defaultWinLength = 5;

        if(args.length == 1){
            try{
                defaultWinLength = Integer.parseInt(args[0]);
                if(defaultWinLength <= 2 || defaultWinLength >= 7){
                    System.out.println("\njava -cp . ConnectN <N> , where N = (1, 7) is the number for winning condition.");
                    System.exit(0);
                }
            }catch(Exception e){
            }
        }else{
        }

        List<Player> players = new ArrayList<Player>();

        /**
         * One human and one Computer player is created for the board game to match Requirement. 
         * Objects wiring up can be handled by creations patters like Factory method, 
         * Builder, or Abstract Factory patterns.
         */
        players.add(new HumanPlayer("Human", new ColoredToken('R', Colors.BRIGHT_RED)));

        /**
         * If below code is uncommented then it will introduce 4 Coumpter player to the game.
         */
        players.add(new ComputerPlayer("Computer-1", new ColoredToken('B', Colors.BRIGHT_BLUE)));
        players.add(new ComputerPlayer("Computer-2", new ColoredToken('M', Colors.BRIGHT_GREEN)));
        // players.add(new ComputerPlayer("Computer-3", new ColoredToken('C', Colors.BRIGHT_CYAN)));
        // players.add(new ComputerPlayer("Computer-4", new ColoredToken('M', Colors.BRIGHT_BLACK)));

        Board board = new SimpleBoard(8, 9, players, defaultWinLength);

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