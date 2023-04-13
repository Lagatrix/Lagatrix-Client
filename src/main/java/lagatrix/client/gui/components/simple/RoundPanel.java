package lagatrix.client.gui.components.simple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 * This component is an round panel, it's an modification of JPanel.
 *
 * @author javierfh03
 * @since 0.1
 */
public class RoundPanel extends JPanel {
    
    private int radius;
    
    public RoundPanel() {
        radius = 30;
        styles();
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
        
        // Sets the round rectangle in the panel.
        g2.setClip(shape);
        
        super.paintComponent(g);
    }
    
    private void styles() {
        setSize(100, 32);
        setBackground(Color.LIGHT_GRAY);
        setBorder(null);
    }
}
