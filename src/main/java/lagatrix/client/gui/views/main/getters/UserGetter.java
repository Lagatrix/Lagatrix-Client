package lagatrix.client.gui.views.main.getters;

import java.util.List;
import lagatrix.client.connection.RequesterManager;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.dto.user.User;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.gui.components.complex.rows.UserRow;
import lagatrix.client.gui.views.main.form.UserView;

/**
 * Obtain the users for the user view.
 *
 * @author javierfh03
 * @since 0.2
 */
public class UserGetter extends Getter {

    public UserGetter(UserView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        List<User> users = (List) requester.makeRequest(ActionsEnum.GET, User.class).getResponse();
        UserRow row;
        
        // Gets the user, add in row and sets in the container of view.
        for (User user : users) {
            row = new UserRow();
            
            row.setEntity(user);
            
            ((UserView) view).getRowContainer().addRow(row);
        }
    }

}
