package lagatrix.client.gui.components.simple;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import lagatrix.client.tools.ChangeColorFactory;
import lagatrix.client.tools.DrawFactory;

/**
 * This components is an field of menu.
 *
 * @author javierfh03
 * @since 0.1
 */
public class MenuLabel extends JLabel {
   
    private DrawFactory draw;

    /**
     * The constructor of the class.
     */
    public MenuLabel() {
        this.draw = new DrawFactory(this);
        styles();
    }
    
    /**
     * Establish if the label is selected in the menu.
     * 
     * @param select The boolean.
     */
    public void select(boolean select) {
        if (select) {
            setBackground(Color.WHITE);
            ((ChangeColorFactory) getMouseListeners()[0]).setActive(false);
        } else {
            setBackground(Color.DARK_GRAY);
            ((ChangeColorFactory) getMouseListeners()[0]).setActive(true);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        draw.upgradeScaling(g);
        draw.roundRight(g, 50);
        super.paintComponent(g);
    }
    
    private void styles() {
        setFont(new Font("sansserif", 0, 14));
        setBackground(Color.DARK_GRAY);
        setHorizontalAlignment(CENTER);
        setForeground(new Color(160, 160, 160));
        setSize(140, 25);
        addMouseListener(new ChangeColorFactory(this, Color.WHITE));
    }
}
