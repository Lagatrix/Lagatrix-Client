package lagatrix.client.gui.views.main.getters;

import lagatrix.client.gui.views.main.form.MainView;

/**
 * This class obtain the infornmation who see in the views of the main views.
 *
 * @author javierfh03
 * @since 0.2
 */
public abstract class Getter extends Thread{
    
    public boolean run;
    public int pause;
    public MainView view;
    
    /**
     * The constructor of the class.
     * 
     * @param view The view who assign the getter.
     * @param pause The time between one application and another.
     */
    public Getter(MainView view, int pause){
        this.view = view;
        this.run = true;
        this.pause = pause;
    }

    @Override
    public final void run(){
        while (run) {            
            getsInformation();
            try {
                sleep(pause);
            } catch (InterruptedException ex) {
                run = false;
            }
        }
    }
    
    /**
     * Put in the components the information of the server.
     */
    public abstract void getsInformation();
    
    /**
     * Kill the thread.
     */
    public final void kill(){
        run = false;
    }
}
