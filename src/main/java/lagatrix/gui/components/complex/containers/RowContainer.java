package lagatrix.gui.components.complex.containers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import lagatrix.gui.components.complex.rows.Row;

/**
 * This constainer contains rows.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class RowContainer extends JPanel {
    
    private Row selectedRow;
    
    /**
     * Constructor of the class.
     */
    public RowContainer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);
    }
    
    /**
     * Add a row into the container.
     * 
     * @param row The row who add.
     */
    public void addRow(Row row) {
        add(row);
        add(Box.createVerticalStrut(10));
        
        // Select the row.
        row.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (selectedRow != null) {
                    selectedRow.setSelect(false);
                }
                
                selectedRow = row;
                selectedRow.setSelect(true);
            }
        });
        revalidate();
    }

    /**
     * Obtain the row who user selected.
     * 
     * @return The row who selected.
     */
    public Row getSelectedRow() {
        return selectedRow;
    }
    
    /**
     * Remove the rows.
     */
    public void clearContainer() {
        removeAll();
        revalidate();
        repaint();
    }
}
