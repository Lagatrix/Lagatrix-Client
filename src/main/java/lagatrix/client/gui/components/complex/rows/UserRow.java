package lagatrix.client.gui.components.complex.rows;

import lagatrix.client.entities.dto.user.User;

/**
 * This class represents the rows who use to represents users.
 * 
 * @author javierfh03
 * @since 0.1
 */
public class UserRow extends Row {
    
    private User user;

    /**
     * The constructor of the class.
     */
    public UserRow() {
        initComponents();
    }

    /**
     * Establish the information of user.
     * 
     * @param user The User object.
     */
    public void setUser(User user) {
        this.user = user;
        putInfo();
    }

    /**
     * Get the user.
     * 
     * @return The User object.
     */
    public User getUser() {
        return user;
    }
    
    /**
     * This method put the info of event in components.
     */
    private void putInfo() {
        establishText(usernameText, user.getUsername());
        establishText(groupText, user.getGroup());
        establishText(homeText, user.getHome());
        establishText(shellText, user.getShell());
        rootCircle.setStatus(user.isIsRoot());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homeText = new javax.swing.JLabel();
        rootCircle = new lagatrix.client.gui.components.simple.BoleanCircle();
        usernameText = new javax.swing.JLabel();
        groupText = new javax.swing.JLabel();
        shellText = new javax.swing.JLabel();

        homeText.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        homeText.setForeground(new java.awt.Color(128, 128, 128));
        homeText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeText.setText("/home/javier");

        usernameText.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        usernameText.setForeground(new java.awt.Color(128, 128, 128));
        usernameText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameText.setText("javier");

        groupText.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        groupText.setForeground(new java.awt.Color(128, 128, 128));
        groupText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupText.setText("dev");

        shellText.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        shellText.setForeground(new java.awt.Color(128, 128, 128));
        shellText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shellText.setText("/bin/bash");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(groupText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(homeText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(shellText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(rootCircle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rootCircle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(homeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(groupText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shellText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupText;
    private javax.swing.JLabel homeText;
    private lagatrix.client.gui.components.simple.BoleanCircle rootCircle;
    private javax.swing.JLabel shellText;
    private javax.swing.JLabel usernameText;
    // End of variables declaration//GEN-END:variables
}
