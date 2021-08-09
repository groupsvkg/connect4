/**
 * ForwardDiagonalCheck checks user input for win condition across forward diagonal.
 */
public class ForwardDiagonalCheck extends WinCheckStrategy {

    /**
     * check method is to check for win condition across forward diagonal.
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

        // Counts matching tokens to the right of the diagonal.
        int[] topRightNeighbour = board.getTopRightNeighbour(row, column);

        while (topRightNeighbour != null && currentMatchCount <= matchLength) {
            int topRightRow = topRightNeighbour[0];
            int topRightColumn = topRightNeighbour[1];
            char topRightToken = board.getBoard()[topRightRow][topRightColumn].getToken();
            if (playerToken == topRightToken) {
                currentMatchCount++;
                topRightNeighbour = board.getTopRightNeighbour(topRightRow, topRightColumn);
                continue;
            } else
                break;
        }

        // Counts matching tokens to the left of the diagonal.
        int[] bottomLeftNeighbour = board.getBottomLeftNeighbour(row, column);

        while (bottomLeftNeighbour != null && currentMatchCount <= matchLength) {
            int bottomLeftRow = bottomLeftNeighbour[0];
            int bottomLeftColumn = bottomLeftNeighbour[1];
            char bottomLeftToken = board.getBoard()[bottomLeftRow][bottomLeftColumn].getToken();
            if (playerToken == bottomLeftToken) {
                currentMatchCount++;
                bottomLeftNeighbour = board.getBottomLeftNeighbour(bottomLeftRow, bottomLeftColumn);
                continue;
            } else
                break;
        }

        if (currentMatchCount >= matchLength)
            return true;

        return this.winCheckStrategy.check(board);
    }

}
