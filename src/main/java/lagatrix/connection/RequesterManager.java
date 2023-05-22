package lagatrix.connection;

import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lagatrix.connection.communicators.AESCommunicator;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.connection.Request;
import lagatrix.entities.connection.Response;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.dialog.status.CorrectDialog;
import lagatrix.gui.dialog.status.ErrorDialog;
import lagatrix.gui.dialog.WaitDialog;

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
     * @param errMsg The message error who display if have an error.
     * @param sucessMsg The message who display if the action make it.
     * @param waitMsg The message of the wait dialog.
     * @return If the request have changes.
     */
    synchronized public boolean makeWriteRequest(JPanel component, Request request, String errMsg, String sucessMsg, String waitMsg) {
        return makeWriteRequest(SwingUtilities.getWindowAncestor(component), request, errMsg, sucessMsg, waitMsg);
    }

    /**
     * Make perform write commands on the server and see dialog when wait.
     *
     * @param window The father of dialog.
     * @param request The request who send to the server,
     * @param errMsg The message error who display if have an error.
     * @param sucessMsg The message who display if the action make it.
     * @param waitMsg The message of the wait dialog.
     * @return If the request have changes.
     */
    synchronized public boolean makeWriteRequest(Window window, Request request, String errMsg, String sucessMsg, String waitMsg) {
        WaitDialog w = new WaitDialog(window, waitMsg);

        new Thread(() -> {
            try {
                makeRequest(request.getAction(), request.getObjectWhoRequest(),
                        request.getParams());
            } catch (BadExecutionException ex) {
                new ErrorDialog(window, errMsg, false).setVisible(true);
            } catch (ConnectionException ex) {
                new ErrorDialog(window, "Ocurrió un error de red al enviar datos", true).setVisible(true);
            }

            SwingUtilities.invokeLater(() -> {
                w.dispose();
            });
        }).start();

        w.setVisible(true);
        
        if (lastExec) {
            new CorrectDialog(window, sucessMsg).setVisible(true);
        }

        return lastExec;
    }
    
    /**
     * If communicator is active.
     * 
     * @return Flag.
     */
    public boolean isActive() {
        return communicator.isActive();
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
