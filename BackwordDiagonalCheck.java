/**
 * BackwordDiagonalCheck checks user input for win condition across backword diagonal.
 */
public class BackwordDiagonalCheck extends WinCheckStrategy {

    /**
     * check method is to check for win condition across backword diagonal.
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

        int[] topLeftNeighbour = board.getTopLeftNeighbour(row, column);

        while (topLeftNeighbour != null && currentMatchCount <= matchLength) {
            int topLeftRow = topLeftNeighbour[0];
            int topLeftColumn = topLeftNeighbour[1];
            char topLeftToken = board.getBoard()[topLeftRow][topLeftColumn].getToken();
            if (playerToken == topLeftToken) {
                currentMatchCount++;
                topLeftNeighbour = board.getTopLeftNeighbour(topLeftRow, topLeftColumn);
                continue;
            } else
                break;
        }

        int[] bottomRightNeighbour = board.getBottomRightNeighbour(row, column);

        while (bottomRightNeighbour != null && currentMatchCount <= matchLength) {
            int bottomRightRow = bottomRightNeighbour[0];
            int bottomRightColumn = bottomRightNeighbour[1];
            char bottomRightToken = board.getBoard()[bottomRightRow][bottomRightColumn].getToken();
            if (playerToken == bottomRightToken) {
                currentMatchCount++;
                bottomRightNeighbour = board.getBottomRightNeighbour(bottomRightRow, bottomRightColumn);
                continue;
            } else
                break;
        }

        if (currentMatchCount >= matchLength)
            return true;

        return false;
    }

}
