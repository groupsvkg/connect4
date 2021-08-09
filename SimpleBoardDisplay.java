/**
 * SimpleBoardDisplay is a concrete class holding board rendering logic without 
 * any colored text or background
 */
public class SimpleBoardDisplay implements BoardDisplay {

    /**
     * display method hold the logic for board rendering
     */
    @Override
    public void display(Board board) {
        int rows = board.getRows();
        int columns = board.getCoulmns();
        Token[][] boardData = board.getBoard();

        for (int i = 0; i < rows; i++) {
            System.out.print((rows - i) + " ");
            System.out.print("|");
            for (int j = 0; j < columns; j++) {
                System.out.print(" " + boardData[i][j] + " |");
            }
            System.out.println("");
        }
        System.out.print("  ");
        for (int i = 0; i < columns; i++) {
            System.out.print("  " + (i + 1) + " ");
        }
        System.out.println();

    }

}
