/**
 * RangeValidator is a concrete class holding logic for column range validation.
 */
public class RangeValidator extends Validator {

    /**
     * @param value is the value to be validated for range min and max
     * @param min is the minimum column value
     * @param max is the total number of columns in board
     * @return true if value is within the range else false.
     */
    @Override
    boolean validate(String value, int min, int max) {
        int column = Integer.parseInt(value);
        if (column >= min && column <= max)
            return true;
        return false;
    }

}
