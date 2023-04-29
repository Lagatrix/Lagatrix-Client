package lagatrix.gui.views.main.getters;

import java.util.List;
import lagatrix.connection.RequesterManager;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.dto.event.Event;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.components.complex.rows.EventRow;
import lagatrix.gui.views.main.form.EventView;

/**
 * Obtain the events for the event view.
 *
 * @author javierfh03
 * @since 0.2
 */
public class EventGetter extends Getter {

    public EventGetter(EventView view, RequesterManager requester, int pause) {
        super(view, requester, pause);
    }

    @Override
    public void getsInformation() throws ConnectionException, BadExecutionException {
        List<Event> events = (List) requester.makeRequest(ActionsEnum.GET, Event.class).getResponse();
        EventRow row;
        
        // Gets the event, add in row and sets in the container of view.
        for (Event event : events) {
            row = new EventRow();
            
            row.setEntity(event);
            
            ((EventView) view).getRowContainer().addRow(row);
        }
    }

}
