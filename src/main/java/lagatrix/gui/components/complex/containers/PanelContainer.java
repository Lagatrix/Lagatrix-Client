package lagatrix.gui.components.complex.containers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * This constainer contains panels.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class PanelContainer extends JPanel {
    
    private Box usedBox;
    private boolean notBox;
    
    /**
     * Constructor of the class.
     */
    public PanelContainer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(245, 245, 245));
        notBox = true;
    }

    @Override
    public Component add(Component comp) {
        // Manage if the row box is clear.
        if (notBox) {
            usedBox = new Box(BoxLayout.X_AXIS);
            usedBox.add(Box.createHorizontalGlue());
            usedBox.add(comp);
            usedBox.add(Box.createHorizontalStrut(25));
            usedBox.add(Box.createHorizontalGlue());
            super.add(Box.createVerticalStrut(25));
            
            notBox = false;
        } else {
            usedBox.add(comp);
            usedBox.add(Box.createHorizontalGlue());
            
            notBox = true;
        }
        
        return super.add(usedBox);
    }
    
    /**
     * Remove the panels.
     */
    public void clearContainer() {
        removeAll();
        revalidate();
        repaint();
        notBox = true;
    }
}