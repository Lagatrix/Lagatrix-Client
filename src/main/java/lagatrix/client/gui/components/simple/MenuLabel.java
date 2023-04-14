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
    
    public void select (boolean select) {
        if (select) {
            setBackground(Color.WHITE);
        } else {
            setBackground(Color.DARK_GRAY);
        }
    }
    
    private void styles() {
        setFont(new Font("sansserif", 0, 14));
        setOpaque(true);
        setBackground(Color.DARK_GRAY);
        setHorizontalAlignment(CENTER);
        setForeground(Color.LIGHT_GRAY);
        setSize(140, 25);
        setBorder(null);
        addMouseListener(new ChangeColorFactory(this, Color.WHITE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        draw.roundRight(g, 50);
        super.paintComponent(g);
    }
}
