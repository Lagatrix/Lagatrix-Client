package lagatrix.gui.views.main.form;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.components.PackageManagerComponents;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.gui.views.main.getters.ApplicationGetter;
import lagatrix.gui.views.main.getters.Getter;
import lagatrix.gui.components.complex.panels.ApplicationPanel;
import lagatrix.gui.window.WaitWindow;

/**
 * This view display the applications of server and manage it.
 * 
 * @author javierfh03
 * @since 0.2
 */
public class ApplicationView extends MainView {

    /**
     * The constructor of the class.
     */
    public ApplicationView() {
        initComponents();
    }
    
    @Override
    public Getter inicialiceGetter() {
        return new ApplicationGetter(this, requester, 100000);
    }

    /**
     * Set the package manager in the panels.
     * 
     * @param packageManager The package manager.
     */
    public void setPackageManager(PackageManagerComponents packageManager) {
        phpApplicationPanel.setWorkComponents(packageManager, requester);
        pythonApplicationPanel.setWorkComponents(packageManager, requester);
        vsftpdApplicationPanel.setWorkComponents(packageManager, requester);
        apacheApplicationPanel.setWorkComponents(packageManager, requester);
        bindApplicationPanel.setWorkComponents(packageManager, requester);
        mariaDBApplicationPanel.setWorkComponents(packageManager, requester);
    }

    public ApplicationPanel[] getPanels() {
        ApplicationPanel[] array = {phpApplicationPanel, pythonApplicationPanel, vsftpdApplicationPanel, 
        apacheApplicationPanel, bindApplicationPanel, mariaDBApplicationPanel};
        
        return array;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upgradeButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        updateButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        jScrollPane = new javax.swing.JScrollPane();
        panelContainer = new lagatrix.gui.components.complex.containers.PanelContainer();
        phpApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();
        mariaDBApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();
        apacheApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();
        bindApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();
        vsftpdApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();
        pythonApplicationPanel = new lagatrix.gui.components.complex.panels.ApplicationPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(885, 552));

        upgradeButton.setText("Actualizar sistema");
        upgradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Actualizar repositorios");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jScrollPane.setBorder(null);
        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        phpApplicationPanel.setAptName("php");
        phpApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/php.png"))); // NOI18N
        phpApplicationPanel.setName("php"); // NOI18N
        phpApplicationPanel.setPacmanName("php");
        phpApplicationPanel.setTitleLabel("PHP");
        phpApplicationPanel.setYumName("php");
        phpApplicationPanel.setZypperName("php");
        panelContainer.add(phpApplicationPanel);

        mariaDBApplicationPanel.setAptName("mariadb-server");
        mariaDBApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/mariadb.png"))); // NOI18N
        mariaDBApplicationPanel.setPacmanName("mariadb");
        mariaDBApplicationPanel.setTitleLabel("MariaDB");
        mariaDBApplicationPanel.setYumName("mariadb-server");
        mariaDBApplicationPanel.setZypperName("mariadb-server");
        panelContainer.add(mariaDBApplicationPanel);

        apacheApplicationPanel.setAptName("apache2");
        apacheApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/apache2.png"))); // NOI18N
        apacheApplicationPanel.setPacmanName("apache");
        apacheApplicationPanel.setTitleLabel("Apache 2");
        apacheApplicationPanel.setYumName("httpd");
        apacheApplicationPanel.setZypperName("httpd");
        panelContainer.add(apacheApplicationPanel);

        bindApplicationPanel.setAptName("bind9");
        bindApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/bind9.png"))); // NOI18N
        bindApplicationPanel.setPacmanName("bind");
        bindApplicationPanel.setTitleLabel("Bind9");
        bindApplicationPanel.setYumName("bind");
        bindApplicationPanel.setZypperName("bind");
        panelContainer.add(bindApplicationPanel);

        vsftpdApplicationPanel.setAptName("vsftpd");
        vsftpdApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/vsftpd.png"))); // NOI18N
        vsftpdApplicationPanel.setPacmanName("vsftpd");
        vsftpdApplicationPanel.setTitleLabel("VSFTP");
        vsftpdApplicationPanel.setYumName("vsftpd");
        vsftpdApplicationPanel.setZypperName("vsftpd");
        panelContainer.add(vsftpdApplicationPanel);

        pythonApplicationPanel.setAptName("python3");
        pythonApplicationPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/software/python.png"))); // NOI18N
        pythonApplicationPanel.setPacmanName("python3");
        pythonApplicationPanel.setTitleLabel("Python");
        pythonApplicationPanel.setYumName("python3");
        pythonApplicationPanel.setZypperName("python3");
        panelContainer.add(pythonApplicationPanel);

        jScrollPane.setViewportView(panelContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(upgradeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1671, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 2394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upgradeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(577, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 687, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upgradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeButtonActionPerformed
        WaitWindow w = new WaitWindow((JFrame) SwingUtilities.getWindowAncestor(this), "Actualizando sistema...");

            new Thread(() -> {
                try {
                    requester.makeRequest(ActionsEnum.MODIFY,
                            PackageManagerComponents.class,"upgrade");
                } catch (BadExecutionException ex) {
                    System.out.println("No se pudo actualizar el sistema");
                } catch (ConnectionException ex) {
                    System.out.println("Error de conexión al actualizar el sistema");
                }
            
                SwingUtilities.invokeLater(() -> {
                        w.dispose();
                });
            }).start();
            
            w.setVisible(true);
    }//GEN-LAST:event_upgradeButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        WaitWindow w = new WaitWindow((JFrame) SwingUtilities.getWindowAncestor(this), "Actualizando repositorios...");

            new Thread(() -> {
                try {
                    requester.makeRequest(ActionsEnum.MODIFY,
                            PackageManagerComponents.class,"update");
                } catch (BadExecutionException ex) {
                    System.out.println("No se puedieron actualizar los repositorios");
                } catch (ConnectionException ex) {
                    System.out.println("Error de conexión al actualizar los respositorios");
                }
            
                SwingUtilities.invokeLater(() -> {
                        w.dispose();
                });
            }).start();
            
            w.setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.gui.components.complex.panels.ApplicationPanel apacheApplicationPanel;
    private lagatrix.gui.components.complex.panels.ApplicationPanel bindApplicationPanel;
    private javax.swing.JScrollPane jScrollPane;
    private lagatrix.gui.components.complex.panels.ApplicationPanel mariaDBApplicationPanel;
    private lagatrix.gui.components.complex.containers.PanelContainer panelContainer;
    private lagatrix.gui.components.complex.panels.ApplicationPanel phpApplicationPanel;
    private lagatrix.gui.components.complex.panels.ApplicationPanel pythonApplicationPanel;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton updateButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton upgradeButton;
    private lagatrix.gui.components.complex.panels.ApplicationPanel vsftpdApplicationPanel;
    // End of variables declaration//GEN-END:variables

}
