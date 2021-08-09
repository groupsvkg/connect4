/**
 * Controller is an interface to capture processing logic for inputs from View.
 */
public interface Controller {

    /**
     * setToken updated the model after getting input from View
     * 
     * @param column is the column number input by player
     * @return a boolean. true means success else failure
     */
    boolean setToken(String column);

    /**
     * play method triggers game start, model initialization and View rendering
     */
    void play();
}
