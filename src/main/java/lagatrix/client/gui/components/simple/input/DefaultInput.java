package lagatrix.client.gui.components.simple.input;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * This component represents a input field personalized.
 *
 * @author javierfh03
 * @since 0.1
 */
public class DefaultInput extends JPanel {
    
    private javax.swing.JLabel description;
    private javax.swing.JSeparator line;
    private javax.swing.JTextField textField;

    /**
     * The constructor of the class.
     */
    public DefaultInput() {
        isPassword(false);
        style();
    }
    
    /**
     * The constructor of the class.
     * 
     * @param password If the input is an password field.
     */
    public DefaultInput(boolean password) {
        isPassword(password);
        style();
    }
    
    /**
     * Set the description.
     * 
     * @param text The text of description.
     */
    public void setDescriptionText(String text){
        description.setText(text);
    }
    
    /**
     * Set the value of input.
     * 
     * @param text The value of input.
     */
    public void setDefaultValue(String text){
        textField.setText(text);
    }
    
    /**
     * Get the value of the input.
     * 
     * @return The value.
     */
    public String getValue() {
        return textField.getText();
    }
    
    /**
     * Initializes the text field depending on whether it is a password or not.
     * 
     * @param password The boolean.
     */
    private void isPassword(boolean password) {
        if (password) {
            textField = new JPasswordField();
        } else {
            textField = new JTextField();
        }
    }
    
    private void style() {
        description = new JLabel();
        line = new JSeparator();

        setLayout(null);

        description.setForeground(Color.GRAY);
        description.setText("DESCRIPTION");
        add(description);
        description.setBounds(0, 0, 120, 17);

        textField.setBackground(null);
        textField.setFont(new Font("sansserif", 0, 14));
        textField.setForeground(new Color(160, 160, 160));
        textField.setText("");
        textField.setBorder(null);
        add(textField);
        textField.setBounds(0, 13, 200, 30);

        line.setBackground(new Color(192, 192, 192));
        line.setForeground(new Color(192, 192, 192));
        line.setToolTipText("");
        line.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192)));
        add(line);
        line.setBounds(0, 43, 200, 3);
        setSize(200,46);
    }  
}