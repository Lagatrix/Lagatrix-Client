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

    public ChangeColorFactory(JComponent component, Color colorToChange) {
        this.component = component;
        this.normalColor = component.getBackground();
        this.colorToChange = colorToChange;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        component.setBackground(colorToChange);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        component.setBackground(normalColor);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}  
}
