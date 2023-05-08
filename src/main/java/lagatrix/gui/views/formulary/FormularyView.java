package lagatrix.gui.views.formulary;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Represents the views of formularys of program.
 * 
 * @author javierfh03
 * @since 0.2
 */
public abstract class FormularyView extends JPanel {
    
    protected boolean edit, resoult;

    public FormularyView() {
        setBackground(new Color(235, 235, 235));
        edit = false;
    }
    
    /**
     * Get the established entity.
     * 
     * @return The entity.
     */
    public abstract Object getEntity();
    
    /**
     * Create an entity with the inputs fields.
     * 
     * @return The entity generated in inputs fields.
     */
    public abstract Object obtainEntity();
    
    /**
     * Make the acction to add the entity.
     */
    public abstract void makeAdd();
    
    /**
     * Make the acction to edit the entity.
     */
    public abstract void makeEdit();

    /**
     * If the last action exec correctly.
     * 
     * @return Boolean.
     */
    public boolean isCorrectLastResoult() {
        return resoult;
    }
    
    /**
     * If the form edit entitys.
     * 
     * @return Boolean.
     */
    public boolean isEdit() {
        return edit;
    }
}
