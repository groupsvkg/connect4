/**
 * Validator is an abstract class describing validation logic api for user input.
 */
public abstract class Validator {
    protected Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    abstract boolean validate(String value, int min, int max);
}
