/**
 * VerticalWinCheck checks user input for win condition across vertical direction.
 */
public class VerticalWinCheck extends WinCheckStrategy {

    /**
     * check function for win condition across vertical direction.
     * Logic is to check first in right direction and count the match and then
     * move to left direction and increment count for the matching token.
     * 
     * @param board the model to be validated for win condition.
     */
    @Override
    boolean check(Board board) {
        int row = board.lastFilledRow;
        int column = board.lastFilledColumn;
        Player player = board.getCurrentPlayer();
        char playerToken = player.getToken().getToken();
        int matchLength = board.matchLength;
        int currentMatchCount = 1;

        // Counts matching tokens to the top.
        int[] topNeighbour = board.getTopNeighbour(row, column);

        while (topNeighbour != null && currentMatchCount <= matchLength) {
            int topRow = topNeighbour[0];
            int topColumn = topNeighbour[1];
            char topToken = board.getBoard()[topRow][topColumn].getToken();
            if (playerToken == topToken) {
                currentMatchCount++;
                topNeighbour = board.getTopNeighbour(topRow, topColumn);
                continue;
            } else
                break;
        }

        // Counts matching tokens to the bottom.
        int[] bottomNeighbour = board.getBottomNeighbour(row, column);

        while (bottomNeighbour != null && currentMatchCount <= matchLength) {
            int bottomRow = bottomNeighbour[0];
            int bottomColumn = bottomNeighbour[1];
            char bottomToken = board.getBoard()[bottomRow][bottomColumn].getToken();
            if (playerToken == bottomToken) {
                currentMatchCount++;
                bottomNeighbour = board.getBottomNeighbour(bottomRow, bottomColumn);
                continue;
            } else
                break;
        }

        if (currentMatchCount >= matchLength)
            return true;
        return this.winCheckStrategy.check(board);
    }

}
