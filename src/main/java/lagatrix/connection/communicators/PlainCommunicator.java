package lagatrix.connection.communicators;

import java.io.IOException;
import java.net.Socket;
import lagatrix.connection.server.ObjectSocket;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.connection.Request;
import lagatrix.entities.connection.Response;
import lagatrix.exceptions.connection.AlgorithmException;
import lagatrix.exceptions.connection.BadClassFormatException;
import lagatrix.exceptions.connection.ConnectionInOutException;

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
    public PlainCommunicator(ObjectSocket socket) throws ConnectionInOutException {
        super(socket);
    }

    @Override
    public void sendRequest(Request request) throws ConnectionInOutException, AlgorithmException {
        try {
            socket.getOut().writeObject(request);
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.SEND, ex));
        }
    }

    @Override
    public Response obtainResponse() throws ConnectionInOutException, AlgorithmException, BadClassFormatException {
        try {
            return (Response) socket.getIn().readObject();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.RECEIVE, ex));
        } catch (ClassNotFoundException ex) {
            throw new BadClassFormatException();
        }
    }

}
