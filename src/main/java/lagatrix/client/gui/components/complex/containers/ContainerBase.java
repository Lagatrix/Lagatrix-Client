package lagatrix.client.gui.components.complex.containers;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Displays the containers with a scroll pane.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class ContainerBase extends JPanel {
    
    private JScrollPane scroll;
    private JPanel container;

    /**
     * Te constructor of the class.
     */
    public ContainerBase() {
        styles();
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resize();
            }
        });
    }

    /**
     * Add the container who siplay.
     * 
     * @param container The container
     */
    public void setContainer(JPanel container) {
        this.container = container;
        
        add(scroll);
        scroll.add(container);
        scroll.setViewportView(container);
        resize();
    }
    
    /**
     * Sets the size of the panels based on the parent.
     */
    private void resize(){
        scroll.setBounds(0, 0, getWidth(), getHeight());
        
        if (container != null) {
            container.setBounds(0, 0, getWidth(), getHeight());
        }
    }
    
    private void styles() {
        scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBorder(null);
    }
}
