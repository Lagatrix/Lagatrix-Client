package lagatrix.client.gui.components.simple.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import lagatrix.client.tools.CenterPossitionFactory;
import lagatrix.client.tools.DrawFactory;

/**
 * This is an circular graphic, you can set an percentage and the graphic 
 * intercats with his value.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class CircleGraphic extends JPanel{

    protected int percentaje;
    private int percentajeInGraphic;
    protected Color mainColor, secondaryColor, backgroundCircleColor;
    private String descriptiveMessage, unitPercentaje;
    protected Font percentajeFont, useTextFont;
    private DrawFactory draw;
    
    public CircleGraphic() {
        draw = new DrawFactory(this);
        styles();
    }
    
    /**
     * Set the percentaje of the graphic.
     * 
     * @param newPercentaje The percentaje who set.
     */
    public void setPercentaje(int newPercentaje) {
        percentaje = newPercentaje;
        percentajeInGraphic = (int) (((float) percentaje / 100) * 360);
        repaint();
    }

    /**
     * Set an help message top of the percentage number.
     * 
     * @param message The message who set.
     */
    public void setDescriptiveMessage(String message) {
        this.descriptiveMessage = message;
        repaint();
    }

    /**
     * Set the unit the percentaje, the default value is % but you can set 
     * another value of percentaje.
     * 
     * @param unitPercentaje The new unit.
     */
    public void setUnitPercentaje(String unitPercentaje) {
        this.unitPercentaje = unitPercentaje;
        repaint();
    }
    
    /**
     * Set the main color, it have this color the percentaje number and arc.
     * 
     * @param mainColor The color who set main.
     */
    public void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
        repaint();
    }
    
    /**
     * Set the color of help message and the external oval.
     * 
     * @param secondaryColor The color who set secondary.
     */
    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
        repaint();
    }

    /**
     * Set the color of the internal circle.
     * 
     * @param backgroundCircleColor The color of the back.
     */
    public void setBackgroundCircleColor(Color backgroundCircleColor) {
        this.backgroundCircleColor = backgroundCircleColor;
        repaint();
    }

    /**
     * Set the font of percentage number.
     * 
     * @param percentajeFont The font style.
     */
    public void setPercentajeFont(Font percentajeFont) {
        this.percentajeFont = percentajeFont;
        repaint();
    }

    /**
     * Set the font of help message.
     * 
     * @param useTextFont The font style.
     */
    public void setUseTextFont(Font useTextFont) {
        this.useTextFont = useTextFont;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw.upgradeScaling(g);
        
        drawCircles(g);
        drawText(g);
    }
    
    /**
     * Draw the ovals and arch.
     * 
     * @param g The Graphics object.
     */
    private void drawCircles(Graphics g) {
        g.setColor(secondaryColor);
        g.fillOval(0, 0, getWidth(), getHeight());
        
        g.setColor(mainColor);
        g.fillArc(0, 0, getWidth(), getHeight(), 90, percentajeInGraphic); 
        
        g.setColor(backgroundCircleColor);
        g.fillOval(10, 10, getWidth() -20, getHeight() -20);
    }

    /**
     * Draw the text of the percentajes.
     * 
     * @param g The Graphics object.
     */
    private void drawText(Graphics g) {
        Dimension dimensionUsePercentaje, dimensionUseText;
        CenterPossitionFactory manager = new CenterPossitionFactory(g);
        String formatedPercentaje =  String.format("%d%s", percentaje, unitPercentaje); 
        
        dimensionUsePercentaje = manager.getCenterString(percentajeFont, formatedPercentaje, getSize());
        dimensionUseText = manager.getCenterString(useTextFont, this.descriptiveMessage, getSize());
        
        g.setColor(mainColor);
        g.setFont(percentajeFont);
        g.drawString(formatedPercentaje, dimensionUsePercentaje.width, dimensionUsePercentaje.height);
        
        g.setColor(secondaryColor);
        g.setFont(useTextFont);
        g.drawString(descriptiveMessage, dimensionUseText.width, dimensionUseText.height - 25);
    }
    
    private void styles() {
        percentaje = 0;
        unitPercentaje = "%";
        descriptiveMessage = "uso";
        mainColor = Color.GRAY;
        secondaryColor = Color.LIGHT_GRAY;
        backgroundCircleColor = new Color(223, 223, 223);
        percentajeFont = new Font("Arial", Font.PLAIN, 36);
        useTextFont = new Font("Arial", Font.PLAIN, 14);
        
        setOpaque(true);
        setBackground(null);
        setSize(130, 130);
    }
    
}
