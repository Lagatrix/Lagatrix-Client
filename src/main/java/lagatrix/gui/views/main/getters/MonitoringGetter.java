package lagatrix.gui.views.main.getters;

import lagatrix.connection.RequesterManager;
import lagatrix.entities.dto.hardware.CPU;
import lagatrix.entities.dto.hardware.RAM;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.views.main.form.MonitoringView;

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
                ((MonitoringView) view).getCPUPanel().setTemp(Math.round((float) 
                        requester.makeReadRequest(CPU.class, 'T').getResponse()));
            } catch (BadExecutionException ex) {
                getTemp = false;
            }
        }
        
        // Obtain the uses of RAM and CPU.
        ((MonitoringView) view).getCPUPanel().setUse(Math.round((float) 
                requester.makeReadRequest(CPU.class, 'U').getResponse()));
        ((MonitoringView) view).getRAMPanel().setUse(Math.round((float) 
                requester.makeReadRequest(RAM.class, 'U').getResponse()));
    }
}
