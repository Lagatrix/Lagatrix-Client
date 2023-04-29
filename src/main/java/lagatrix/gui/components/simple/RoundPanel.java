package lagatrix.gui.components.simple;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import lagatrix.tools.gui_factory.DrawFactory;

/**
 * This component is an round panel, it's an modification of JPanel.
 *
 * @author javierfh03
 * @since 0.1
 */
public class RoundPanel extends JPanel {
    
    private int radius;
    private DrawFactory draw;
    
    /**
     * Constructor of the class.
     */
    public RoundPanel() {
        draw = new DrawFactory(this);
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
        draw.roundComponent(g, radius);
        super.paintComponent(g);
    }
    
    private void styles() {
        radius = 100;
        setBackground(new Color(223, 223, 223));
    }
}
