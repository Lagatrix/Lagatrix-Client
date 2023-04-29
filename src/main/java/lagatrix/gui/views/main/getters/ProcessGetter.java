package lagatrix.gui.views.main.getters;

import java.util.List;
import lagatrix.connection.RequesterManager;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.dto.process.UnixProcess;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.components.complex.rows.ProcessRow;
import lagatrix.gui.views.main.form.ProcessView;

/**
 * Obtain the processes for the process view.
 *
 * @author javierfh03
 * @since 0.2
 */
public class ProcessGetter extends Getter {

    public ProcessGetter(ProcessView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        List<UnixProcess> processes = (List) requester.makeRequest(ActionsEnum.GET, UnixProcess.class).getResponse();
        ProcessRow row;
        
        // Gets the process, add in row and sets in the container of view.
        for (UnixProcess process : processes) {
            row = new ProcessRow();
            
            row.setEntity(process);
            
            ((ProcessView) view).getRowContainer().addRow(row);
        }
    }

}
