package hello;

public class DepthValidator{

    /**
     * The {@link DepthValidator} class validates that *just* Integer instances are used
     * and that the depth does not go below zero
     */
    public boolean supports(int number) {
        return Integer.class.isInstance(number);
    }

    public boolean positive(Integer number) {
        return number >= 0;
    }
}