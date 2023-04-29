package lagatrix.gui.views.main.getters;

import lagatrix.connection.RequesterManager;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.views.main.form.MainView;

/**
 * This class obtain the infornmation who see in the views of the main views 
 * over a period of time.
 *
 * @author javierfh03
 * @since 0.2
 */
public abstract class Getter extends Thread{
    
    private boolean run;
    private int pause;
    protected RequesterManager requester;
    protected MainView view;
    
    /**
     * The constructor of the class.
     * 
     * @param view The view who assign the getter.
     * @param requester The requester.
     * @param pause The time between one application and another.
     */
    public Getter(MainView view, RequesterManager requester, int pause){
        this.view = view;
        this.run = true;
        this.requester = requester;
        this.pause = pause;
    }

    @Override
    public final void run() {
        while (run) {            
            try {
                getsInformation();
            } catch (ConnectionException ex) {
                
            } catch (BadExecutionException ex) {
                
            }
            try {
                sleep(pause);
            } catch (InterruptedException ex) {
                run = false;
            }
        }
    }
    
    /**
     * Put in the components the information of the server.
     * 
     * @throws ConnectionException If have a error in the connection.
     * @throws BadExecutionException If have a error in the execution of action.
     */
    public abstract void getsInformation() throws ConnectionException, BadExecutionException;
    
    /**
     * Kill the thread.
     */
    public final void kill(){
        run = false;
    }
}
