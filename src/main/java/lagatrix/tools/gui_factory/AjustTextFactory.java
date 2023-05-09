package lagatrix.tools.gui_factory;

/**
 * AJust text in dialog.
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
        if (text.length() > 27) {
            return String.format("<html>%s<br>%s</html>", 
                    text.substring(0, 26),
                        text.substring(26, text.length()));
        }
        
        return text;
    }
}
