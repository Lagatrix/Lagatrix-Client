package lagatrix.gui.views.main.form;

import javax.swing.SwingUtilities;
import lagatrix.entities.dto.hardware.CPU;
import lagatrix.entities.dto.hardware.GPU;
import lagatrix.entities.dto.hardware.RAM;
import lagatrix.entities.dto.os.OSInformation;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.FileException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.file.InformationWriter;
import lagatrix.gui.dialog.status.CorrectDialog;
import lagatrix.gui.dialog.status.ErrorDialog;
import lagatrix.gui.dialog.status.QuestionDialog;
import lagatrix.gui.views.main.getters.Getter;

/**
 * This view make actions in the server
 * 
 * @author javierfh03
 * @since 0.2
 */
public class ActionsView extends MainView {
    
    private Object[] args;
    
    /**
     * The constructor of the class.
     */
    public ActionsView() {
        initComponents();
    }
    
    @Override
    public Getter inicialiceGetter() {
        return null;  
    }
    
    /**
     * Set the information of the system.
     * 
     * @param args The object who display.
     */
    public void setInformation(Object... args) {
        this.args = args;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        rebootButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        powerOffButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();

        setPreferredSize(new java.awt.Dimension(885, 552));

        infoButton.setText("Informe");
        infoButton.setRadius(70);
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        rebootButton.setText("Reiniciar");
        rebootButton.setRadius(70);
        rebootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebootButtonActionPerformed(evt);
            }
        });

        powerOffButton.setText("Apagar");
        powerOffButton.setRadius(70);
        powerOffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerOffButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(powerOffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(rebootButton, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(powerOffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rebootButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        InformationWriter file = new InformationWriter(this);
            
        file.open();
        
        try {
            if (file.haveSelectedFile()) {
                file.save(args);
            }
        } catch (FileException ex) {
            new ErrorDialog(this, ex.getMessage(), 
                    false).setVisible(true);
        }
    }//GEN-LAST:event_infoButtonActionPerformed

    private void powerOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_powerOffButtonActionPerformed
        QuestionDialog question = new QuestionDialog(this, 
                "¿Seguro que quieres apagar la máquina?");
        
        question.setVisible(true);
        
        try {
            if (question.isAccept()){
                requester.makeReadRequest(null, "off");
                new CorrectDialog(this, "Se apagó la máquina").setVisible(true);
                SwingUtilities.getWindowAncestor(this).dispose();
            }
        } catch (BadExecutionException ex) {
            new ErrorDialog(this, "No se pudo ejecutar el apagado", 
                    false).setVisible(true);
        } catch (ConnectionException ex) {
            new ErrorDialog(this, "Ocurrión un problema de red al apagar", 
                    true).setVisible(true);
        }
    }//GEN-LAST:event_powerOffButtonActionPerformed

    private void rebootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebootButtonActionPerformed
        QuestionDialog question = new QuestionDialog(this, 
                "¿Seguro que quieres reiniciar la máquina?");
        
        question.setVisible(true);
        
        try {
            if (question.isAccept()){
                requester.makeReadRequest(null, "restart");
                new CorrectDialog(this, "Se reinició la máquina").setVisible(true);
                SwingUtilities.getWindowAncestor(this).dispose();
            }
        } catch (BadExecutionException ex) {
            new ErrorDialog(this, "No se pudo ejecutar el reinicio", 
                    false).setVisible(true);
        } catch (ConnectionException ex) {
            new ErrorDialog(this, "Ocurrión un problema de red al reiniciar", 
                    true).setVisible(true);
        }
    }//GEN-LAST:event_rebootButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton infoButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton powerOffButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton rebootButton;
    // End of variables declaration//GEN-END:variables

}
