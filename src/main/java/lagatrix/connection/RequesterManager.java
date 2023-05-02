package lagatrix.connection;

import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import lagatrix.connection.communicators.AESCommunicator;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.connection.Request;
import lagatrix.entities.connection.Response;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.window.WaitWindow;

/**
 * This class make request in the server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class RequesterManager {
    
    private AESCommunicator communicator;
    private boolean lastExec;

    /**
     * The constructor of the class.
     * 
     * @param communicator The communicator object with the server.
     */
    public RequesterManager(AESCommunicator communicator) {
        this.communicator = communicator;
        this.lastExec = false;
    }
    
    /**
     * Make perform get commands on the server.
     * 
     * @param objectWhoRequest The object who request in the server.
     * @param params If the request needs params.
     * @return The response of the server.
     * @throws BadExecutionException If the request not exec.
     * @throws ConnectionException If have an connection problem.
     */
    synchronized public Response makeReadRequest(Class objectWhoRequest, Object... params) throws BadExecutionException, ConnectionException {
        return makeRequest(ActionsEnum.GET, objectWhoRequest, params);
    }
    
    /**
     * Make perform write commands on the server and see dialog when wait.
     * 
     * @param component The father of dialog. 
     * @param request The request who send to the server,
     * @param errMsg The error who display if have an error.
     * @param waitMsg The message of the wait dialog.
     * @return If the request have changes.
     */
    synchronized public boolean makeWriteRequest(JComponent component, Request request, String errMsg, String waitMsg) {
        return makeWriteRequest(SwingUtilities.getWindowAncestor(component), request, errMsg, waitMsg);
    }
    
    /**
     * Make perform write commands on the server and see dialog when wait.
     * 
     * @param window The father of dialog. 
     * @param request The request who send to the server,
     * @param errMsg The error who display if have an error.
     * @param waitMsg The message of the wait dialog.
     * @return If the request have changes.
     */
    synchronized public boolean makeWriteRequest(Window window, Request request, String errMsg, String waitMsg) {
        WaitWindow w = new WaitWindow((JFrame) window, waitMsg);
        
        new Thread(() -> {
                try {
                    makeRequest(request.getAction(), request.getObjectWhoRequest(),
                            request.getParams());
                } catch (BadExecutionException ex) {
                    System.out.println(errMsg);
                } catch (ConnectionException ex) {
                    System.out.println("Ocurrió un error de red al envir datos");
                }
                
                SwingUtilities.invokeLater(() -> {
                        w.dispose();
                });
            }).start();
        
        w.setVisible(true);
        
        return lastExec;
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
    private Response makeRequest(ActionsEnum action, Class objectWhoRequest, Object... params) throws BadExecutionException, ConnectionException {
        Response response;
        
        communicator.sendRequest(new Request(action, objectWhoRequest, params));
        
        response = communicator.obtainResponse();
        
        if (response.isCorrectResult()) {
            lastExec = true;
            return response;
        } else {
            lastExec = false;
            throw new BadExecutionException(BadExecutionException.getMessage(action, objectWhoRequest));
        }
    }
}
