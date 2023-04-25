package lagatrix.client.gui.views.main.getters;

import lagatrix.client.connection.RequesterManager;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.dto.hardware.CPU;
import lagatrix.client.entities.dto.hardware.RAM;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.gui.views.main.form.MonitoringView;

/**
 * Obtain the uses and temps for components of the monitoring view.
 *
 * @author javierfh03
 * @since 0.2
 */
public class MonitoringGetter extends Getter {

    private boolean getTemp;

    public MonitoringGetter(MonitoringView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
        getTemp = true;
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        // If fail when get it, the temperature will no longer be obtained,
        if (getTemp) {
            try {
                ((MonitoringView) view).getCPUPanel().setTemp((int) requester.makeRequest(ActionsEnum.GET,
                CPU.class, 'T').getResponse());
            } catch (BadExecutionException ex) {
                getTemp = false;
            }
        }

        // Obtain the uses of RAM and CPU.
        ((MonitoringView) view).getCPUPanel().setUse((int) requester.makeRequest(ActionsEnum.GET,
                CPU.class, 'U').getResponse());
        ((MonitoringView) view).getRAMPanel().setUse((int) requester.makeRequest(ActionsEnum.GET,
                RAM.class, 'U').getResponse());
    }
}
