package lagatrix.gui.components.complex.panels;

import lagatrix.entities.dto.os.OSInformation;
import lagatrix.gui.components.simple.RoundPanel;

/**
 * This components represents an panel who represents the data of operative 
 * system.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class OSPanel extends RoundPanel {
    
    private OSInformation os;

    /**
     * Constructor of the class.
     */
    public OSPanel() {
        initComponents();
    }

    /**
     * Establish the information of operative system.
     * 
     * @param os The OSInformation object.
     */
    public void setOs(OSInformation os) {
        this.os = os;
        putInfo();
    }
    
    /**
     * This method put the info of OS in components.
     */
    private void putInfo() {
        nameLabel.setText(os.getDistribution());
        hostname.setText(String.format("Hostname: %s", os.getHostname()));
        kernel.setText(String.format("Kérnel: %s", os.getKernel()));
        
        distroImage.setIcon(os.getDistroImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        kernel = new javax.swing.JLabel();
        distroImage = new javax.swing.JLabel();
        hostname = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(189, 189));

        nameLabel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(128, 128, 128));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Distribución");

        kernel.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        kernel.setForeground(new java.awt.Color(128, 128, 128));
        kernel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kernel.setText("Desconocido");

        distroImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        distroImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/distros/default.png"))); // NOI18N

        hostname.setBackground(new java.awt.Color(0, 204, 0));
        hostname.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        hostname.setForeground(new java.awt.Color(128, 128, 128));
        hostname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hostname.setText("Desconocido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kernel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(hostname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distroImage, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distroImage, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostname)
                .addGap(2, 2, 2)
                .addComponent(kernel)
                .addContainerGap())
        );

        nameLabel.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel distroImage;
    private javax.swing.JLabel hostname;
    private javax.swing.JLabel kernel;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
