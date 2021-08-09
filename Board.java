import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Board is an abstract class which holds the application state which is manupulated by Controller
 * and rendered by View.
 */
public abstract class Board {
    protected Token[][] board;
    protected int rows;
    protected int columns;
    protected List<Player> players;
    protected int currentPlayerIndex;
    protected State currentState;
    protected int matchLength;
    protected int tokenFillCount;
    protected int lastFilledRow;
    protected int lastFilledColumn;

    /**
     * Constructor for Board class
     * 
     * @param rows          is the total number of rows in the board
     * @param columns       is the total number of column in the board
     * @param players       is the total number of players playing this game
     * @param matchLength   is the match lenght for wining condition
     */
    public Board(int rows, int columns, List<Player> players, int matchLength) {
        Random random = new Random();
        this.board = new Token[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.players = players;
        this.currentPlayerIndex = random.nextInt(players.size());
        this.currentState = State.INIT;
        this.matchLength = matchLength;
        this.tokenFillCount = 0;
    }

    /**
     * @return the number of rows in current board
     */
    int getRows() {
        return this.rows;
    }

    /**
     * @return the number of columns in current board
     */
    int getCoulmns() {
        return this.columns;
    }

    /**
     * @return the current player who has to make a move
     */
    Player getCurrentPlayer() {
        return this.players.get(this.currentPlayerIndex);
    }

    /**
     * @return the next player who has to make a move
     */
    Player getNextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % players.size();
        return this.players.get(this.currentPlayerIndex);
    }

    /**
     * @return the 2D array of Tokens maintained by Board class
     */
    Token[][] getBoard() {
        return board;
    }

    /**
     * @return total number of players playing the Game.
     */
    List<Player> getPlayers() {
        return players;
    }

    /**
     * @return the matching length for wining condition i.e. Connect4 means matchLength = 4
     * and ConnectN means matchingLength = N
     */
    int getMatchLength() {
        return matchLength;
    }

    /**
     * getColumnEmptyCell finds the first empty cell in a column from bottom to up.
     * 
     * @param column    This is the column entered by end user.
     * @return          The row number of the first empty cell in "column".
     */
    int getColumnEmptyCell(int column) {
        for (int i = rows - 1; i >= 0; i--) {
            if (this.board[i][column].getToken() == ' ') {
                return i;
            }
        }
        return -1;
    }

    /**
     * getTopNeighbour finds the coordinates of cell on top of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "top" cell as two element integer array
     */
    int[] getTopNeighbour(int row, int column) {
        int[] topNeighbour = null;
        if (row - 1 >= 0)
            topNeighbour = new int[] { row - 1, column };
        return topNeighbour;
    }

    /**
     * getBottomNeighbour finds the coordinates of cell on bottom of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "bottom" cell as two element integer array
     */
    int[] getBottomNeighbour(int row, int column) {
        int[] bottomNeighbour = null;
        if (row + 1 < rows)
            bottomNeighbour = new int[] { row + 1, column };
        return bottomNeighbour;
    }

    /**
     * getRightNeighbour finds the coordinates of cell to the right of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "right" cell as two element integer array
     */
    int[] getRightNeighbour(int row, int column) {
        int[] rightNeighbour = null;
        if (column + 1 < columns)
            rightNeighbour = new int[] { row, column + 1 };
        return rightNeighbour;
    }

    /**
     * getLeftNeighbour finds the coordinates of cell to the left of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "left" cell as two element integer array
     */
    int[] getLeftNeighbour(int row, int column) {
        int[] leftNeighbour = null;
        if (column - 1 >= 0)
            leftNeighbour = new int[] { row, column - 1 };
        return leftNeighbour;
    }

    /**
     * getTopRightNeighbour finds the coordinates of cell to the top right of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "top right" cell as two element integer array
     */
    int[] getTopRightNeighbour(int row, int column) {
        int[] topRightNeighbour = null;
        if (row - 1 >= 0 && column + 1 < columns) {
            topRightNeighbour = new int[] { row - 1, column + 1 };
        }
        return topRightNeighbour;
    }

    /**
     * getTopLeftNeighbour finds the coordinates of cell to the top left of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "top left" cell as two element integer array
     */
    int[] getTopLeftNeighbour(int row, int column) {
        int[] topLeftNeighbour = null;
        if (row - 1 >= 0 && column - 1 >= 0) {
            topLeftNeighbour = new int[] { row - 1, column - 1 };
        }
        return topLeftNeighbour;
    }

    /**
     * getBottomRightNeighbour finds the coordinates of cell to the bottom right of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "bottom right" cell as two element integer array
     */
    int[] getBottomRightNeighbour(int row, int column) {
        int[] bottomRightNeighbour = null;
        if (row + 1 < rows && column + 1 < columns) {
            bottomRightNeighbour = new int[] { row + 1, column + 1 };
        }
        return bottomRightNeighbour;
    }

    /**
     * getBottomLeftNeighbour finds the coordinates of cell to the bottom left of input cordinate (row, column)
     * 
     * @param row       A valid row number
     * @param column    A valid column number
     * @return          The coordinate of "bottom left" cell as two element integer array
     */
    int[] getBottomLeftNeighbour(int row, int column) {
        int[] bottomLeftNeighbour = null;
        if (row + 1 < rows && column - 1 >= 0) {
            bottomLeftNeighbour = new int[] { row + 1, column - 1 };
        }
        return bottomLeftNeighbour;
    }

    /**
     * init method initializes Boards 2D array with default token and sets current state to INIT.
     * 
     * @param defaultToken  default Token object with blank character.
     */
    abstract void init(Token defaultToken);

    /**
     * @return  the current state of Board
     */
    abstract State getState();

    /**
     * setToken abstract method updates the Board by finding row first and then using input 
     * colum to identify the cell coordinates.
     * 
     * @param column    Cell in the colum to be updated
     * @return boolean to indicate update status. true means successfull and false means update failed.
     */
    abstract boolean setToken(int column);

    @Override
    public String toString() {
        return "Board [board=" + Arrays.toString(board) + ", columns=" + columns + ", currentPlayerIndex="
                + currentPlayerIndex + ", currentState=" + currentState + ", lastFilledColumn=" + lastFilledColumn
                + ", lastFilledRow=" + lastFilledRow + ", matchLength=" + matchLength + ", players=" + players
                + ", rows=" + rows + ", tokenFillCount=" + tokenFillCount + "]";
    }

}
