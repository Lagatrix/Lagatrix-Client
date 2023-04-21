package lagatrix.client.connection.communicators;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Request;
import lagatrix.client.entities.connection.Response;
import lagatrix.client.exceptions.connection.AlgorithmException;
import lagatrix.client.exceptions.connection.BadClassFormatException;
import lagatrix.client.exceptions.connection.ConnectionInOutException;

/**
 * This class is used to apply method to create communication class.
 * 
 * @author javierfh03
 * @since 0.2
 */
public abstract class CommunicatorBase {
    
    protected Socket socket;
    protected ObjectOutputStream out;
    protected ObjectInputStream in;

    public CommunicatorBase(Socket socket) throws ConnectionInOutException {
        this.socket = socket;
        
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.OPEN, ex));
        }
    }
    
    /**
     * This method send an request to the server.
     * 
     * @param request The request to send the server.
     * @throws ConnectionInOutException If have an I/O error in communication.
     * @throws AlgorithmException If have an error related to the cipher.
     */
    public abstract void sendRequest(Request request) throws ConnectionInOutException, AlgorithmException;
    
    /**
     * This method obtain an response of the server.
     * 
     * @return Obtain the response of the server.
     * @throws ConnectionInOutException If have an I/O error in communication.
     * @throws AlgorithmException If have an error related to the cipher.
     * @throws BadClassFormatException If the class who send the server is not 
     * valid.
     */
    public abstract Response obtainResponse() throws ConnectionInOutException, AlgorithmException, BadClassFormatException;
    
    /**
     * Close the connector.
     * 
     * @throws ConnectionInOutException If the connector can't close.
     */
    public void close() throws ConnectionInOutException {
        try {
            out.close();
            in.close();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.CLOSE, ex));
        }
    }
    
    /**
     * Close the connector and client connection.
     * 
     * @throws ConnectionInOutException If the connector can't close.
     */
    public void closeServer() throws ConnectionInOutException {
        try {
            close();
            socket.close();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.CLOSE, ex));
        }
    }
}
