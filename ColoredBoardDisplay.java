/**
 * ColoredBoardDisplay is a concrete class which renders the board with different text and background color.
 */
public class ColoredBoardDisplay implements BoardDisplay {

    /**
     * display method renders the 2D array of token with different text and background color.
     * 
     * @param board it hold the complete state of game.
     */
    @Override
    public void display(Board board) {
        int rows = board.getRows();
        int columns = board.getCoulmns();
        Token[][] boardData = board.getBoard();

        for (int i = 0; i < rows; i++) {
            System.out.print(Colors.BACKGROUND_BRIGHT_BLACK + Colors.BRIGHT_WHITE + (rows - i) + Colors.RESET + " ");
            System.out.print(Colors.BACKGROUND_BRIGHT_WHITE + Colors.BRIGHT_CYAN + "|" + Colors.RESET);
            for (int j = 0; j < columns; j++) {
                System.out.print(Colors.BACKGROUND_BRIGHT_WHITE + " " + boardData[i][j] + Colors.BACKGROUND_BRIGHT_WHITE
                        + Colors.BRIGHT_CYAN + " |" + Colors.RESET);
            }
            System.out.println();
        }

        System.out.print(" ");
        for (int i = 0; i < columns; i++) {
            System.out.print(Colors.BACKGROUND_BRIGHT_BLACK + Colors.BRIGHT_WHITE + "   " + (i + 1) + Colors.RESET);
        }
        System.out.println(Colors.BACKGROUND_BRIGHT_BLACK + Colors.BRIGHT_WHITE + "  " + Colors.RESET);
        System.out.println();
    }

}
