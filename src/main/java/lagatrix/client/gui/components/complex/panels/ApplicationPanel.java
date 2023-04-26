package lagatrix.client.gui.components.complex.panels;

import javax.swing.Icon;
import javax.swing.JLabel;
import lagatrix.client.gui.components.simple.RoundPanel;

/**
 * This components represents an panel who manage an application.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class ApplicationPanel extends RoundPanel {
    
    private String aptName, yumName, pacmanName, zypperName;

    /**
     * Constructor of the class.
     */
    public ApplicationPanel() {
        initComponents();
    }

    /**
     * Set the title of the panel.
     * 
     * @param title The name of the application.
     */
    public void setTitleLabel(String title) {
        this.titleLabel.setText(title);
    }
    
    /**
     * Set the image of the application.
     * 
     * @param icon The icon who display.
     */
    public void setIcon(Icon icon) {
        this.appImage.setIcon(icon);
    }

    
    public void setAppImage(JLabel appImage) {
        this.appImage = appImage;
    }

    /**
     * Set the names of APT package manager.
     * 
     * @param aptName The name of package.
     */
    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    /**
     * Set the names of Yum package manager.
     * 
     * @param yumName The name of package.
     */
    public void setYumName(String yumName) {
        this.yumName = yumName;
    }

    /**
     * Set the names of zypper package manager.
     * 
     * @param zypperName The name of package.
     */
    public void setZypperName(String zypperName) {
        this.zypperName = zypperName;
    }

    /**
     * Set the names of pacman package manager.
     * 
     * @param pacmanName The name of package.
     */
    public void setPacmanName(String pacmanName) {
        this.pacmanName = pacmanName;
    }
    
    public void isApplicationInstaled(boolean flag) {
        if (flag) {
            installPanel.setVisible(false);
            managePanel.setVisible(true);
        } else {
            managePanel.setVisible(false);
            installPanel.setVisible(true);
        }
    }

    public String getAptName() {
        return aptName;
    }

    public String getYumName() {
        return yumName;
    }

    public String getPacmanName() {
        return pacmanName;
    }

    public String getZypperName() {
        return zypperName;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        appImage = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        installPanel = new javax.swing.JPanel();
        installButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();
        managePanel = new javax.swing.JPanel();
        updateButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();
        uninstallButton = new lagatrix.client.gui.components.simple.buttons.DefaulRoundButton();

        titleLabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(128, 128, 128));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Aplicación");

        appImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.CardLayout());

        installPanel.setOpaque(false);

        installButton.setText("Instalar");

        javax.swing.GroupLayout installPanelLayout = new javax.swing.GroupLayout(installPanel);
        installPanel.setLayout(installPanelLayout);
        installPanelLayout.setHorizontalGroup(
            installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installPanelLayout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(installButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        installPanelLayout.setVerticalGroup(
            installPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(installButton, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        buttonsPanel.add(installPanel, "card3");

        managePanel.setOpaque(false);

        updateButton.setText("Actualizar");

        uninstallButton.setText("Desinstalar");

        javax.swing.GroupLayout managePanelLayout = new javax.swing.GroupLayout(managePanel);
        managePanel.setLayout(managePanelLayout);
        managePanelLayout.setHorizontalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(uninstallButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        managePanelLayout.setVerticalGroup(
            managePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(uninstallButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonsPanel.add(managePanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(appImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appImage;
    private javax.swing.JPanel buttonsPanel;
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton installButton;
    private javax.swing.JPanel installPanel;
    private javax.swing.JPanel managePanel;
    private javax.swing.JLabel titleLabel;
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton uninstallButton;
    private lagatrix.client.gui.components.simple.buttons.DefaulRoundButton updateButton;
    // End of variables declaration//GEN-END:variables
}
