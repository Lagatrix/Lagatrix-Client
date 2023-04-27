package lagatrix.client.gui.window;

import java.awt.Color;
import lagatrix.client.connection.RequesterManager;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.exceptions.BadExecutionException;
import lagatrix.client.exceptions.connection.ConnectionException;
import lagatrix.client.gui.views.formulary.FormularyView;

/**
 * Represents the window who see the formularys.
 * 
 * @author javierfh03
 * @since 0.2
 */
public class FormularyWindow extends javax.swing.JFrame {

    private RequesterManager requester;
    private FormularyView formulay;

    /**
     * Constructor of the class.
     */
    public FormularyWindow() {
        setUndecorated(true);
        initComponents();
        setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
    }

    public void setFormulay(FormularyView formulay) {
        this.formulay = formulay;
        containerPanel.add(formulay);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new lagatrix.client.gui.components.simple.RoundPanel();
        header = new lagatrix.client.gui.components.complex.fragment.Header();
        cancelButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();
        actionButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lagatrix");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setRadius(61);

        header.setFather(this);

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        actionButton.setText("Añadir");
        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        containerPanel.setLayout(new javax.swing.OverlayLayout(containerPanel));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(actionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionButtonActionPerformed
        try {
            if (formulay.isEdit()) {
                requester.makeRequest(ActionsEnum.MODIFY, formulay.getEntity().getClass(), 
                    formulay.getEntity(), formulay.obtainEntity());
            } else {
                requester.makeRequest(ActionsEnum.INSERT, formulay.getEntity().getClass(), 
                        formulay.obtainEntity());
            }
        } catch (ConnectionException e) {
            
        } catch (BadExecutionException ex) {
            
        }
    }//GEN-LAST:event_actionButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton actionButton;
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton cancelButton;
    private javax.swing.JPanel containerPanel;
    private lagatrix.client.gui.components.complex.fragment.Header header;
    private lagatrix.client.gui.components.simple.RoundPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
