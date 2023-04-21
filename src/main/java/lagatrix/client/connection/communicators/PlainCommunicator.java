package lagatrix.client.connection.communicators;

import java.io.IOException;
import java.net.Socket;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Request;
import lagatrix.client.entities.connection.Response;
import lagatrix.client.exceptions.connection.AlgorithmException;
import lagatrix.client.exceptions.connection.BadClassFormatException;
import lagatrix.client.exceptions.connection.ConnectionInOutException;

/**
 * This class manage the Request and Response objects without encryption.
 *
 * @author javierfh03
 * @since 0.2
 */
public class PlainCommunicator extends CommunicatorBase {
    
    /**
     * The constructor of the class.
     * 
     * @param socket The client socket.
     * @throws ConnectionInOutException If have an I/O error when create 
     * connection.
     */
    public PlainCommunicator(Socket socket) throws ConnectionInOutException {
        super(socket);
    }

    @Override
    public void sendRequest(Request request) throws ConnectionInOutException, AlgorithmException {
        try {
            out.writeObject(request);
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.SEND, ex));
        }
    }

    @Override
    public Response obtainResponse() throws ConnectionInOutException, AlgorithmException, BadClassFormatException {
        try {
            return (Response) in.readObject();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.RECEIVE, ex));
        } catch (ClassNotFoundException ex) {
            throw new BadClassFormatException();
        }
    }

}
