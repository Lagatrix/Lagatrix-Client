package lagatrix.entities.connection;

import java.io.Serializable;
import java.util.Arrays;
import lagatrix.entities.actions.ActionsEnum;

/**
 * This class is used to send requests to the server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class Request implements Serializable {
    
    private ActionsEnum action;
    private Class objectWhoRequest;
    private Object[] params;

    /**
     * The constructor of the class.
     * 
     * @param action The action to exec.
     * @param objectWhoRequest The item who manage.
     * @param params If the execuniton need params.
     */
    public Request(ActionsEnum action, Class objectWhoRequest, Object... params) {
        this.action = action;
        this.objectWhoRequest = objectWhoRequest;
        this.params = params;
    }
    
    public Request(ActionsEnum action) {
        this.action = action;
        this.params = null;
    }

    public ActionsEnum getAction() {
        return action;
    }

    public Class getObjectWhoRequest() {
        return objectWhoRequest;
    }
    
    public Object[] getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "Request{" + "action=" + action + ", objectWhoRequest=" + objectWhoRequest.getSimpleName()
                + ", params=" + Arrays.toString(params) + '}';
    }
}
