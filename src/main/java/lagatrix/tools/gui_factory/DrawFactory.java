package lagatrix.tools.gui_factory;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
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
        component.setOpaque(false);
    }
    
    /**
     * This method performs corner bending to the components.
     *
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundComponent(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        upgradeScaling(g);
        
        g.setColor(component.getBackground());
        
        g2.fill(new RoundRectangle2D.Double(0, 0, component.getWidth(), 
                component.getHeight(), radius, radius));
    }
    
    /**
     * This method performs corner in right side bending to the components.
     *
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundTop(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        upgradeScaling(g);
        
        g.setColor(component.getBackground());
        
        g2.fill(new RoundRectangle2D.Float(0, 0,
                component.getWidth(), component.getHeight(), radius, radius));
        g2.fill(new Rectangle(0, 20, component.getWidth(), component.getHeight()));
    }
    
    /**
     * This method performs corner in right side bending to the components.
     *
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundRight(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        upgradeScaling(g);
        
        g.setColor(component.getBackground());
        
        g2.fill(new RoundRectangle2D.Float(0, 0,
                component.getWidth(), component.getHeight(), radius, radius));
        g2.fill(new Rectangle(100, 0, component.getWidth(), component.getHeight()));
    }
    
    /**
     * This method performs corner in right buttom side bending to the 
     * components.
     *
     * @param g The grafic object.
     * @param radius Degree of curvature.
     */
    public void roundRightBottom(Graphics g, int radius) {
        Graphics2D g2 = (Graphics2D) g;
        upgradeScaling(g);
        
        g.setColor(component.getBackground());
        
        g2.fill(new RoundRectangle2D.Float(0, 0,
                component.getWidth(), component.getHeight(), radius, radius));
        g2.fill(new Rectangle(0, 0, component.getWidth(), 100));
        g2.fill(new Rectangle(100, 0, component.getWidth(), component.getHeight()));
    }
    
    /**
     * This method improvement the drawing of component.
     *
     * @param g The grafic object.
     */
    private void upgradeScaling(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHints(hints);
    }

}
