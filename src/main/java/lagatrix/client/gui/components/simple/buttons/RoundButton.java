package lagatrix.client.gui.components.simple.buttons;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * This component is an round button, it's an modification of JButton.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class RoundButton extends JButton{
    
    private int radius;

    /**
     * Constructor of the class.
     */
    public RoundButton() {
        radius = 30;
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
        Graphics2D g2 = (Graphics2D) g;
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        // Define details in the drawing.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Sets the round rectangle in the button
        g2.setClip(shape);
        
        super.paintComponent(g);
    }
}
