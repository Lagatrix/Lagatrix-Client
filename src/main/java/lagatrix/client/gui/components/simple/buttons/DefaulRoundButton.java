package lagatrix.client.gui.components.simple.buttons;

import java.awt.Color;

/**
 * This component is an round button with styles. 
 *
 * @author javierfh03
 * @since 0.1
 */
public class DefaulRoundButton extends RoundButton {

    public DefaulRoundButton() {
        super();
        styles();
    }
    
    private void styles() {
        setSize(100, 32);
        setText("Default");
        setFont(new java.awt.Font("sansserif", 0, 16));
        setForeground(Color.DARK_GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBorder(null);
    }
}
