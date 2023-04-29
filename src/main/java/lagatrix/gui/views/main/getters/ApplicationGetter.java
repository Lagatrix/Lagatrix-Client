package lagatrix.gui.views.main.getters;

import lagatrix.connection.RequesterManager;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.dto.os.PackageManagerComponents;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.components.complex.panels.ApplicationPanel;
import lagatrix.gui.views.main.form.ApplicationView;

/**
 * Obtain the status of aplication in the server.
 *
 * @author javierfh03
 * @since 0.2
 */
public class ApplicationGetter extends Getter {

    public ApplicationGetter(ApplicationView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        // Obtain the application panels and set if is instaled consulting if is it.
        for (ApplicationPanel application : ((ApplicationView) view).getPanels()) {
            application.isApplicationInstaled(((Boolean) requester.makeRequest(ActionsEnum.GET, 
                    PackageManagerComponents.class, application.getApplicationName()).getResponse()));
        }
    }

}
