/**
 * HorizontalWinCheck checks user input for win condition across horizontal direction.
 */
public class HorizontalWinCheck extends WinCheckStrategy {

    /**
     * check method is to check for win condition across horizontal direction.
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

        // Counts matching tokens to the right.
        int[] rightNeighbour = board.getRightNeighbour(row, column);

        while (rightNeighbour != null && currentMatchCount <= matchLength) {
            int rightRow = rightNeighbour[0];
            int rightColumn = rightNeighbour[1];
            char rightToken = board.getBoard()[rightRow][rightColumn].getToken();
            if (playerToken == rightToken) {
                currentMatchCount++;
                rightNeighbour = board.getRightNeighbour(rightRow, rightColumn);
                continue;
            } else
                break;
        }

        // Counts matching tokens to the left.
        int[] leftNeighbour = board.getLeftNeighbour(row, column);

        while (leftNeighbour != null && currentMatchCount <= matchLength) {

            int leftRow = leftNeighbour[0];
            int leftColumn = leftNeighbour[1];
            char leftToken = board.getBoard()[leftRow][leftColumn].getToken();
            if (playerToken == leftToken) {
                currentMatchCount++;
                leftNeighbour = board.getLeftNeighbour(leftRow, leftColumn);
                continue;
            } else
                break;
        }

        if (currentMatchCount >= matchLength)
            return true;

        return this.winCheckStrategy.check(board);
    }

}
