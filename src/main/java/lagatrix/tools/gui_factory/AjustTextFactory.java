package lagatrix.tools.gui_factory;

/**
 * Ajust text in dialog.
 *
 * @author javierfh03
 * @since 0.3
 */
public class AjustTextFactory {
    
    /**
     * AJust text to see in dialog.
     * 
     * @param text The text who ajust.
     * @return The text formated.
     */
    public static String ajust(String text) {
        int pointer = 26;
        
        if (text.length() > 27) {
            
            // Avoid cutting words.
            while (text.charAt(pointer) != ' ') {                
                pointer--;
            }
            
            return String.format("<html>%s<br>%s</html>", 
                    text.substring(0, pointer),
                        text.substring(pointer, text.length()));
        }
        
        return text;
    }
}
