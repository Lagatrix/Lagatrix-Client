package lagatrix.client.gui.components.simple.buttons;

import java.awt.Color;

/**
 * This component is an round button with styles, it is intended to be used in 
 * the close or minimize window button.
 *
 * @author javierfh03
 * @since 0.1
 */
public class MiniRoundButton extends RoundButton {

    public MiniRoundButton() {
        super();
        styles();
    }
    
    private void styles() {
        setSize(18, 18);
        setForeground(Color.DARK_GRAY);
        setBackground(Color.RED);
    }
}
