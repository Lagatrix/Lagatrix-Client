package lagatrix.client.gui.views.main.form;

import lagatrix.client.gui.views.main.getters.Getter;
import javax.swing.JPanel;
import lagatrix.client.connection.RequesterManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * This class represents the views of the main program, initialises the getter 
 * object.
 *
 * @author javierfh03
 * @since 0.2
 */
public abstract class MainView extends JPanel {
    
    protected Getter getter;
    protected RequesterManager requester;

    /**
     * Constructor of the class.
     */
    public MainView() {
    }
    
    /**
     * Instancie a new getter of threads.
     * 
     * @return The class instancied.
     */
    public abstract Getter inicialiceGetter();
    
    /**
     * Set the requester to make calls.
     * 
     * @param requester The requester.
     */
    public void setRequester(RequesterManager requester) {
        this.requester = requester;
    }
    
    /**
     * Start the view.
     */
    public void start() {
        getter = inicialiceGetter();
        
        if (getter != null) {
            getter.start();
        }
    }
    
    /**
     * Stop the view.
     */
    public void stop() {
        if (getter != null){
            getter.kill();
        }
    }
}
