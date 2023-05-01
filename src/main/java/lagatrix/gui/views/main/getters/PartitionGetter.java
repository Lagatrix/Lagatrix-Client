package lagatrix.gui.views.main.getters;

import java.util.Set;
import lagatrix.connection.RequesterManager;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.dto.partition.Partition;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.components.complex.panels.PartitionPanel;
import lagatrix.gui.views.main.form.MainView;
import lagatrix.gui.views.main.form.PartitionView;

/**
 * Obtain the partitions for the partition view.
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
        Set<Partition> partitions =  (Set) requester.makeRequest(ActionsEnum.GET, Partition.class).getResponse();
        PartitionPanel panel;
        
        ((PartitionView) view).getPanelContainer().clearContainer();
        
        // Gets the partitions, add in panel and sets in the container of view.
        for (Partition partition : partitions) {
            panel = new PartitionPanel();
            
            panel.setPartition(partition);
            
            ((PartitionView) view).getPanelContainer().add(panel);
        }
    }

}
