package lagatrix.file;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lagatrix.exceptions.FileException;

/**
 * Save the information of the system in file.
 *
 * @author javierfh03
 * @since 0.3
 */
public class InformationWriter {
    
    private FileDialog chooser;

    /**
     * The constructor of the class.
     * 
     * @param father The frame parent.
     */
    public InformationWriter(Frame father) {
        this.chooser = new FileDialog(father, "Guardar informe", FileDialog.SAVE);
    }
    
    /**
     * The constructor of the class.
     * 
     * @param father The panel parent.
     */
    public InformationWriter(JPanel father) {
        this((Frame) SwingUtilities.getWindowAncestor(father));
    }
    
    /**
     * Open the dialog.
     */
    public void open(){
        chooser.setVisible(true);
    }
    
    /**
     * If user select a file.
     * 
     * @return boolean
     */
    public boolean haveSelectedFile() {
        return chooser.getFile() != null;
    }
    
    /**
     * Save in file the toString method of objects.
     * 
     * @param args The object who save.
     * @throws FileException I have a proble when save.
     */
    public void save(Object... args) throws FileException {
        BufferedWriter buffered;
        
        try {
            buffered = new BufferedWriter(new FileWriter(String.format("%s%s", 
                    chooser.getDirectory(), chooser.getFile())));
            
            buffered.write("Información sobre el sistema:\n");
            
            for (Object arg : args) {
                buffered.write(String.format("%s\n", arg.toString()));
            }
            
            buffered.close();
        } catch (FileNotFoundException ex) {
            throw new FileException("No se pudo abrir el archivo");
        } catch (IOException ex) {
            throw new FileException("Error de entrada salida");
        }
    }

}
