package lagatrix.client.gui.components.complex.rows;

import java.awt.Color;
import javax.swing.JLabel;
import lagatrix.client.gui.components.simple.RoundPanel;

/**
 * This class represents the rows who use the program.
 *
 * @author javierfh03
 * @since 0.1
 */
public class Row extends RoundPanel {

    /**
     * The constructor of the class.
     */
    public Row() {
        setRadius(60);
    }

    /**
     * Establish if the label is selected in the menu.
     * 
     * @param select The boolean.
     */
    public void setSelect(boolean select) {
        if (select) {
            setBackground(new Color(190, 190, 190));
        } else {
            setBackground(new Color(223, 223, 223));
        }
    }
    
    /**
     * Sets text of entity into label.
     * 
     * @param label The label.
     * @param text The text entity.
     */
    protected static void establishText(JLabel label, String text) {
        label.setText(text);
        label.setToolTipText(text);
    }
    
}
