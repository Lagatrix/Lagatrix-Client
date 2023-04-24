package lagatrix.client.gui.views.main.form;

import lagatrix.client.gui.views.main.getters.Getter;
import javax.swing.JPanel;

/**
 * This class represents the views of the main program, initialises the getter 
 * object.
 *
 * @author javierfh03
 * @since 0.2
 */
public abstract class MainView extends JPanel {
    
    public Getter getter;

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
     * Start the view.
     */
    public void start() {
        getter = inicialiceGetter();
        getter.start();
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
