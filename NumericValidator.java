/**
 * NumericValidator is a concrete class holding logic for number validation.
 */
public class NumericValidator extends Validator {

    /**
     * validate method validated the user input for numberic value.
     * 
     * @param value is the value to be validated.
     * @param min is the minimum column value.
     * @param max is the total number of columns in board.
     */
    @Override
    boolean validate(String value, int min, int max) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return this.validator.validate(value, min, max);
    }

}
