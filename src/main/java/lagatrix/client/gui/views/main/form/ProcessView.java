package lagatrix.client.gui.views.main.form;

import lagatrix.client.connection.RequesterManager;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.dto.process.UnixProcess;
import lagatrix.client.entities.dto.user.User;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.gui.components.complex.containers.RowContainer;
import lagatrix.client.gui.components.complex.rows.ProcessRow;
import lagatrix.client.gui.views.main.getters.Getter;
import lagatrix.client.gui.views.main.getters.ProcessGetter;

/**
 * This view display and manage the proces of server.
 * 
 * @author javierfh03
 * @since 0.2
 */
public class ProcessView extends MainView {
    
    private RequesterManager requester;

    /**
     * The constructor of the class.
     */
    public ProcessView() {
        initComponents();
    }
    
    @Override
    public Getter inicialiceGetter() {
        return new ProcessGetter(this, requester, 5000);
    }

    public RowContainer getRowContainer() {
        return rowContainer;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userLabel = new javax.swing.JLabel();
        cpuLabel = new javax.swing.JLabel();
        ramLabel = new javax.swing.JLabel();
        pidLabel = new javax.swing.JLabel();
        commandLabel = new javax.swing.JLabel();
        killButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();
        jScrollPane = new javax.swing.JScrollPane();
        rowContainer = new lagatrix.client.gui.components.complex.containers.RowContainer();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(885, 552));

        userLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("USUARIO");

        cpuLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        cpuLabel.setForeground(new java.awt.Color(0, 0, 0));
        cpuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpuLabel.setText("USO CPU");

        ramLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        ramLabel.setForeground(new java.awt.Color(0, 0, 0));
        ramLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ramLabel.setText("USO RAM");

        pidLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        pidLabel.setForeground(new java.awt.Color(0, 0, 0));
        pidLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pidLabel.setText("PID");

        commandLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        commandLabel.setForeground(new java.awt.Color(0, 0, 0));
        commandLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commandLabel.setText("COMANDO");

        killButton.setText("Matar");
        killButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killButtonActionPerformed(evt);
            }
        });

        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(rowContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(commandLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(pidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(cpuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(ramLabel)
                .addGap(64, 64, 64))
            .addComponent(jScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(killButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(commandLabel)
                    .addComponent(pidLabel)
                    .addComponent(cpuLabel)
                    .addComponent(ramLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(killButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void killButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killButtonActionPerformed
        rowContainer.addRow(new ProcessRow());
        try {
            requester.makeRequest(ActionsEnum.DELETE, User.class, 
                    ((UnixProcess) rowContainer.getSelectedRow().getEntity()).getPID());
        } catch (BadExecutionException ex) {
            
        } catch (ConnectionException ex) {
            
        }
    }//GEN-LAST:event_killButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commandLabel;
    private javax.swing.JLabel cpuLabel;
    private javax.swing.JScrollPane jScrollPane;
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton killButton;
    private javax.swing.JLabel pidLabel;
    private javax.swing.JLabel ramLabel;
    private lagatrix.client.gui.components.complex.containers.RowContainer rowContainer;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

}
