package lagatrix.client.tools;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * This class change the background color of componet when mouse passes over it.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class ChangeColorFactory implements MouseListener {
    
    private JComponent component;
    private Color colorToChange, normalColor;
    private boolean active;

    /**
     * The constructor of the class.
     * 
     * @param component The component to add the facory.
     * @param colorToChange The color who change if mouse enter in his.
     */
    public ChangeColorFactory(JComponent component, Color colorToChange) {
        this.component = component;
        this.normalColor = component.getBackground();
        this.colorToChange = colorToChange;
        this.active = true;
    }
    
    /**
     * Stop or resume its execution.
     * 
     * @param active The boolean.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (active) {
            component.setBackground(colorToChange);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (active) {
            component.setBackground(normalColor);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}  
}
