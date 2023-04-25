package lagatrix.client.gui.views.main.getters;

import java.util.List;
import lagatrix.client.connection.RequesterManager;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.dto.partition.Partition;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.gui.components.complex.panels.PartitionPanel;
import lagatrix.client.gui.views.main.form.MainView;
import lagatrix.client.gui.views.main.form.PartitionView;

/**
 * Obtain the partitions for the monitoring view.
 *
 * @author javierfh03
 * @since 0.2
 */
public class PartitionGetter extends Getter {

    public PartitionGetter(MainView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        List<Partition> partitions =  (List) requester.makeRequest(ActionsEnum.GET, PartitionGetter.class).getResponse();
        PartitionPanel panel;
        
        // Get the partitions, add in panel and sets in the container of view.
        for (Partition partition : partitions) {
            panel = new PartitionPanel();
            
            panel.setPartition(partition);
            
            ((PartitionView) view).getPanelContainer().add(panel);
        }
    }

}
