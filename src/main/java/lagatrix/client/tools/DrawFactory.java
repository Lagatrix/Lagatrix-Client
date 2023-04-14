package lagatrix.client.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
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
        Shape shape = new RoundRectangle2D.Float(0, 0,
                component.getWidth(), component.getHeight(), radius, radius);
       
        g2.setClip(shape);
    }
   
    /**
     * This method performs corner in right side bending to the components.
     *
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundRight(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        Area shape1 = new Area(new RoundRectangle2D.Float(0, 0,
                component.getWidth(), component.getHeight(), radius, radius));
        Area shape2 = new Area(new Rectangle(100, 0, component.getWidth() - 100 , component.getHeight()));
       
        shape1.add(shape2);
       
        g2.setClip(shape1);
    }
}
