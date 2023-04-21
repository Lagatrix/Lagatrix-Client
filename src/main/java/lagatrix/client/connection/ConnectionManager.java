package lagatrix.client.connection;

import java.io.IOException;
import java.net.Socket;
import lagatrix.client.connection.communicators.AESCommunicator;
import lagatrix.client.connection.server.AuthInServer;
import lagatrix.client.connection.server.EstablishConnection;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Response;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.exceptions.connection.ConnectionInOutException;
import static lagatrix.client.exceptions.connection.ConnectionInOutException.getMessageIO;

/**
 * This class make the connection of client and server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class ConnectionManager {
    
    private Socket socket;
    private AESCommunicator communicator;

    /**
     * The constructor of the class.
     * 
     * @param ip The ip of server,
     * @param port The port who connect.
     * @throws ConnectionInOutException If can connect to the server.
     */
    public ConnectionManager(String ip, int port) throws ConnectionInOutException {
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException ex) {
            throw new ConnectionInOutException(getMessageIO(ConnectionManager.class, 
                    ActionsEnum.OPEN, ex));
        }
    }

    /**
     * Obtain the AESCommunicator when the client and server establish the 
     * connection.
     * 
     * @return The communicator.
     */
    public AESCommunicator getCommunicator() {
        return communicator;
    }
    
    /**
     * This method make the exchanging the keys RSA and AES with the server.
     * 
     * @throws ConnectionException If raise an connection error.
     */
    public void establishConnection() throws ConnectionException{
        EstablishConnection establish = new EstablishConnection(socket);
        
        establish.obtainRSA();
        establish.sendAES();
        
        this.communicator = new AESCommunicator(socket, establish.getAESKey());
    }

    /**
     * This method make the login of the user.
     * 
     * @param user The user who auth.
     * @param password The password of the user.
     * @return The Respose object of the server.
     * @throws ConnectionException If have an error connection.
     */
    public Response authUser(String user, String password) throws ConnectionException {
        AuthInServer auth = new AuthInServer(communicator);
        
        return auth.makeLogin(user, password);
    }
}
