package lagatrix.client.gui.components.simple.graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import lagatrix.client.tools.CenterPossitionFactory;

/**
 * This is an modification of the CircleGraphic object, it represents an RAM use
 * graphic.
 * 
 * @author javierfh03
 */
public class CircleGraphicRAM extends CircleGraphic {
    
    private float usedMemory;
    private int totalMemory;
    private String unitMemory;

    public CircleGraphicRAM() {
        // Set the default values.
        super();
        this.usedMemory = 0;
        this.totalMemory = 0;
        this.unitMemory = "GB";
    }

    /**
     * Set the total memory of the RAM.
     * 
     * @param totalMemory The total memory.
     */
    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    /**
     * Set the unit of the memory, the default is GB.
     * 
     * @param unitMemory The unit of memory.
     */
    public void setUnitMemory(String unitMemory) {
        this.unitMemory = unitMemory;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        usedMemory =  ((float) percentaje / 100) * totalMemory;
        drawUsedMemory(g);
    }
    
    /**
     * Draw the used memory button the percentaje number.
     * 
     * @param g The Graphics object.
     */
    private void drawUsedMemory(Graphics g) {
        CenterPossitionFactory manager = new CenterPossitionFactory(g);
        Dimension dimensionUsedMemory;
        String usedMemoryMessage = String.format("%.2f%s", usedMemory, unitMemory);
        
        dimensionUsedMemory = manager.getCenterString(useTextFont, usedMemoryMessage, getSize());
        
        g.setColor(secondaryColor);
        g.setFont(useTextFont);
        g.drawString(usedMemoryMessage, dimensionUsedMemory.width, dimensionUsedMemory.height + 30);
    }
}
