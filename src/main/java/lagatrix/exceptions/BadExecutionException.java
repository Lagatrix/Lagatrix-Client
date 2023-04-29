package lagatrix.exceptions;

import lagatrix.entities.actions.ActionsEnum;

/**
 * This error appear if the action executed in the server not exec correctly.
 *
 * @author javierfh03
 * @since 0.2
 */
public class BadExecutionException extends LagatrixException {

    public BadExecutionException(String description) {
        super(description);
    }

    /**
     * Make the error message.
     * 
     * @param action The action who send.
     * @param objectWhoRequest The object who request.
     * @return The message.
     */
    public static String getMessage(ActionsEnum action, Class objectWhoRequest) {
        return String.format("Can't exec %s action in the object", action, objectWhoRequest);
    }
}
