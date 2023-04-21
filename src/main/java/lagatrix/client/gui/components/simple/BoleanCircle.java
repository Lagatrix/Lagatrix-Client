package lagatrix.client.gui.components.simple;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import lagatrix.client.tools.gui_factory.DrawFactory;

/**
 * This class represents an boolean with simple circle.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class BoleanCircle extends JPanel {
    
    private boolean status;
    private DrawFactory draw;

    public BoleanCircle() {
        status = true;
        draw = new DrawFactory(this);
    }

    /**
     * Set the boolean, if put true it see green and if put false it see red.
     * 
     * @param status The boolean.
     */
    public void setStatus(boolean status) {
        this.status = status;
        setOpaque(false);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (status) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.RED);
        }
        
        g.fillOval(0, 0, getWidth(), getHeight());
    }
}
