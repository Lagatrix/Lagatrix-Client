package lagatrix.client.gui.components.simple.buttons;

import java.awt.Graphics;
import javax.swing.JButton;
import lagatrix.client.tools.DrawFactory;

/**
 * This component is an round button, it's an modification of JButton.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class RoundButton extends JButton{
    
    private int radius;
    private DrawFactory draw;

    /**
     * Constructor of the class.
     */
    public RoundButton() {
        radius = 30;
        draw = new DrawFactory(this);
    }
    
    /**
     * Set the curvature at the corners.
     * 
     * @param radius Degree of curvature.
     */
    public void setRadius(int radius){
        this.radius = radius;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        draw.roundComponent(g, radius);
        draw.upgradeScaling(g);
        super.paintComponent(g);
    }
}
