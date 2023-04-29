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
    
    protected boolean edit;

    public FormularyView() {
        setBackground(Color.WHITE);
        edit = false;
    }
    
    /**
     * Set the entity in the form.
     * 
     * @param entity The entity who add.
     */
    public abstract void setEntity(Object entity);
    
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
     * If the form edit entitys.
     * 
     * @return Boolean.
     */
    public boolean isEdit() {
        return edit;
    }
}
