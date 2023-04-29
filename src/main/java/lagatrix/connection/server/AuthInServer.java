package lagatrix.connection.server;

import lagatrix.connection.communicators.AESCommunicator;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.connection.Request;
import lagatrix.entities.connection.Response;
import lagatrix.entities.dto.user.User;
import lagatrix.exceptions.connection.ConnectionException;

/**
 * This class auth a user into the server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class AuthInServer {
    
    private AESCommunicator communicator;

    /**
     * The constructor of the class.
     * 
     * @param communicator The AES Communicator.
     */
    public AuthInServer(AESCommunicator communicator) {
        this.communicator = communicator;
    }
    
    /**
     * This method make the login of the user.
     * 
     * @param user The user who auth.
     * @param password The password of the user.
     * @return The Respose object of the server.
     * @throws ConnectionException If have an error connection.
     */
    public Response makeLogin(String user, String password) throws ConnectionException {
        communicator.sendRequest(new Request(ActionsEnum.SEND, User.class, 
                user, password));
        
        return communicator.obtainResponse();
    }
}
