package lagatrix.client.tools;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * This class set string of graphic in the center of x possition.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class CenterPossitionFactory {
    
    private Graphics g;

    /**
     * The constructor of the class
     * 
     * @param g 
     */
    public CenterPossitionFactory(Graphics g) {
        this.g = g;
    }
    
    /**
     * This method obtain the exact position to center a text in a java graph.
     * 
     * @param font The style of font.
     * @param text The text who display.
     * @param panelSize The sice of the panel who paint it.
     * @return The correct dimension to center in x.
     */
    public Dimension getCenterString(Font font, String text, Dimension panelSize) {
        Dimension centerDimension = getDimensionString(font, text);
        int x = panelSize.width / 2 - centerDimension.width / 2;
        int y = panelSize.height / 2 + centerDimension.height / 2;
        
        return new Dimension(x, y);
    }
    
    /**
     * This method obtain the size of the dimension of text,
     * 
     * @param font The style of font.
     * @param text The text who display.
     * @return His dimension.
     */
    private Dimension getDimensionString(Font font, String text) {
        FontMetrics fm = g.getFontMetrics(font);
        
        return new Dimension(fm.stringWidth(text), fm.getAscent());
    }
}
