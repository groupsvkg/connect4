/**
 * BoardController is a concrete class which takes inputs from View and performs validation.
 * Once validation is done it updates the model.
 */
public class BoardController implements Controller {
    private View view;
    private Board board;
    private Validator validator;

    /**
     * Constructor method which creates BoardController object.
     * 
     * @param board         Holds application state
     * @param boardDisplay  it holds the logic of Board rendering
     */
    public BoardController(Board board, BoardDisplay boardDisplay) {
        this.view = new ConsoleView(this, board, boardDisplay);
        this.board = board;
        this.validator = new NumericValidator();
        this.validator.setValidator(new RangeValidator());
    }

    /**
     * setToken method updates the board with the player Token.
     * 
     * @param column    It represents the column entered by end user.
     * 
     * @return true if model update succeed's else false.
     */
    @Override
    public boolean setToken(String column) {
        if (validator.validate(column, 1, this.board.getCoulmns())) {
            boolean result = this.board.setToken(Integer.parseInt(column) - 1);
            if (result)
                return true;
            else {
                this.view.displayErrorMessage("Input ignored: '" + column + "'\n");
                return false;
            }
        } else {
            this.view.displayErrorMessage("Incorrect input: '" + column + "'\n");
            return false;
        }
    }

    /**
     * play method initializes the model and triggers view rendering.
     */
    @Override
    public void play() {
        this.board.init(new SimpleToken());
        this.view.play();
    }

}
