package lagatrix.client.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

/**
 * This class draws common things between components.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class DrawFactory {
    
    private JComponent component;

    /**
     * Constructor of the class.
     * 
     * @param component The component of swing who draw.
     */
    public DrawFactory(JComponent component) {
        this.component = component;
    }
    
    /**
     * This method improvement the drawing of component.
     * 
     * @param g The grafic object.
     */
    public void upgradeScaling(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    /**
     * This method performs corner bending to the components.
     * 
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundComponent(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        Shape shape = new RoundRectangle2D.Float(0, 0, component.getWidth() 
                - 1, component.getHeight() - 1, radius, radius);
        
        g2.setClip(shape);
    }
}
