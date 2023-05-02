package lagatrix.gui.views.main.getters;

import java.util.Set;
import lagatrix.connection.RequesterManager;
import lagatrix.entities.dto.user.User;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.components.complex.rows.UserRow;
import lagatrix.gui.views.main.form.UserView;

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
        Set<User> users = (Set) requester.makeReadRequest(User.class).getResponse();
        UserRow row;
        
        ((UserView) view).getRowContainer().clearContainer();
        
        // Gets the user, add in row and sets in the container of view.
        for (User user : users) {
            row = new UserRow();
            
            row.setEntity(user);
            
            ((UserView) view).getRowContainer().addRow(row);
        }
    }

}
