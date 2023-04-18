package lagatrix.client.gui.components.simple.buttons;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import lagatrix.client.tools.gui_factory.DrawFactory;

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
        styles();
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
        draw.upgradeScaling(g);
        draw.roundComponent(g, radius);
        super.paintComponent(g);
    }
    
    private void styles() {
        radius = 30;
        setBackground(Color.red);
        setBorder(null);
        setFocusable(false);
    }
}
