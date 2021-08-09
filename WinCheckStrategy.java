/**
 * WinCheckStrategy is the abstract class which defines "check" and setWinCheckStrategy api 
 * to capture the essense of "Chain of Responsibility" pattern.
 */
public abstract class WinCheckStrategy {
    protected WinCheckStrategy winCheckStrategy;

    /**
     * setWinCheckStrategy method sets the next strategy call to form a chain to check 
     * various win scenarios i.e. horizontal, vertical, and diagonal.
     * 
     * @param winCheckStrategy  this point to the next strategy calls in chain of responsibility
     */
    public void setWinCheckStrategy(WinCheckStrategy winCheckStrategy) {
        this.winCheckStrategy = winCheckStrategy;
    }

    /**
     * check is an abstract method to check for win condition across horizontal, vertical,
     * forward diagonal and backword diagonal.
     * 
     * @param board the model to be validated for win condition.
     */
    abstract boolean check(Board board);
}
