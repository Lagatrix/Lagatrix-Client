package lagatrix.gui.views.main.form;

import lagatrix.gui.components.complex.containers.PanelContainer;
import lagatrix.gui.views.main.getters.Getter;
import lagatrix.gui.views.main.getters.PartitionGetter;

/**
 * This view display the partitions of server.
 * 
 * @author javierfh03
 * @since 0.2
 */
public class PartitionView extends MainView {

    /**
     * The constructor of the class.
     */
    public PartitionView() {
        initComponents();
    }
    
    @Override
    public Getter inicialiceGetter() {
        return new PartitionGetter(this, requester, 10000);
    }

    public PanelContainer getPanelContainer() {
        return panelContainer;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        panelContainer = new lagatrix.gui.components.complex.containers.PanelContainer();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(885, 552));

        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setViewportView(panelContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private lagatrix.gui.components.complex.containers.PanelContainer panelContainer;
    // End of variables declaration//GEN-END:variables

}
