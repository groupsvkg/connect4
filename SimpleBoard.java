import java.util.List;

/**
 * SimpleBoard is a concrete class inheriting application state and validation logic.
 */
public class SimpleBoard extends Board {
    private WinCheckStrategy winCheckStrategy;

    /**
     * Constructor to create SimpleBoard object
     * 
     * @param row           is the total number of rows in board
     * @param column        is the total number of columns in board
     * @param players       is the total number of players in the game
     * @param matchLength   is the matching length for win condition
     */
    public SimpleBoard(int row, int column, List<Player> players, int matchLength) {
        super(row, column, players, matchLength);

        this.winCheckStrategy = new HorizontalWinCheck();
        WinCheckStrategy verticalWinCheck = new VerticalWinCheck();
        WinCheckStrategy forwardDiagonalCheck = new ForwardDiagonalCheck();
        WinCheckStrategy backwordDiagonalCheck = new BackwordDiagonalCheck();

        winCheckStrategy.setWinCheckStrategy(verticalWinCheck);
        verticalWinCheck.setWinCheckStrategy(forwardDiagonalCheck);
        forwardDiagonalCheck.setWinCheckStrategy(backwordDiagonalCheck);
    }

    /**
     * init method is to initialize board with default Token.
     * 
     * @param defaultToken is the default token to initialize board
     */
    @Override
    void init(Token defaultToken) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.board[i][j] = defaultToken;
            }
        }
    }

    /**
     * getState method return the state of Game i.e. INIT, IN_PROGRESS, WON, LOST, DRAW.
     * @return Game state
     */
    @Override
    State getState() {
        if (this.tokenFillCount >= rows * columns) {
            this.currentState = State.DRAW;
            return State.DRAW;
        }

        if (this.winCheckStrategy.check(this)) {
            this.currentState = State.WON;
            return State.WON;
        }

        return State.IN_PROGRESS;
    }

    /**
     * setToken method updates model for player input
     * 
     * @param column    is the column input by player
     * @return true if update is successfull else false.
     */
    @Override
    boolean setToken(int column) {
        int row = this.getColumnEmptyCell(column);
        if (row == -1) {
            return false;
        } else {
            this.board[row][column] = this.getCurrentPlayer().getToken();
            this.lastFilledRow = row;
            this.lastFilledColumn = column;
            this.tokenFillCount++;
            return true;
        }

    }

}
