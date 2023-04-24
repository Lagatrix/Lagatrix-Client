package lagatrix.client.connection;

import lagatrix.client.connection.communicators.AESCommunicator;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Request;
import lagatrix.client.entities.connection.Response;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;

/**
 * This class make request in the server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class RequesterManager {
    
    private AESCommunicator communicator;

    /**
     * The constructor of the class.
     * 
     * @param communicator The communicator object with the server.
     */
    public RequesterManager(AESCommunicator communicator) {
        this.communicator = communicator;
    }
    
    /**
     * This method send the request to the server and get the answer.
     * 
     * @param action The action who exec in the server.
     * @param objectWhoRequest The object who request in the server.
     * @param params If the request needs params.
     * @return The response object.
     * @throws BadExecutionException If the request not exec.
     * @throws ConnectionException If have an connection problem.
     */
    public Response makeRequest(ActionsEnum action, Class objectWhoRequest, Object... params) throws BadExecutionException, ConnectionException {
        Response response;
        
        communicator.sendRequest(new Request(ActionsEnum.GET, objectWhoRequest, params));
        
        response = communicator.obtainResponse();
        
        if (response.isCorrectResult()) {
            return response;
        } else {
            throw new BadExecutionException(BadExecutionException.getMessage(action, objectWhoRequest));
        }
    }
}
