package lagatrix.client.exceptions.connection;

/**
 * This error is used if the server sends an invalid object.
 *
 * @author javierfh03
 * @since 0.2
 */
public class BadClassFormatException extends ConnectionException {

    public BadClassFormatException() {
        super("Unexpected class");
    }

}
