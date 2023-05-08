package lagatrix.gui.window;

import java.awt.Color;
import javax.swing.ImageIcon;
import lagatrix.entities.dto.Connection;
import lagatrix.exceptions.FileException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.file.ConnectionReader;
import lagatrix.gui.components.complex.rows.ConnecionRow;
import lagatrix.gui.views.formulary.ConnectionFormularyView;

/**
 * Represents the window who see the formularys.
 *
 * @author javierfh03
 * @since 0.2
 */
public class ConnectionWindow extends javax.swing.JFrame {

    private ConnectionReader reader;

    /**
     * Constructor of the class.
     */
    public ConnectionWindow() {
        this.reader = new ConnectionReader();

        setUndecorated(true);
        initComponents();
        setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
    }

    /**
     * Open the window and reader.
     */
    public void open() {
        try {
            reader.open();
            refresh();
            
            setVisible(true);
        } catch (FileException ex) {
            setVisible(false);
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Open the window and reader.
     * 
     * @param connection The last connection who use.
     */
    public void open(Connection connection) {
        open();
        reader.deleteConnection(connection);
        reader.insertConnection(connection);
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new lagatrix.gui.components.simple.RoundPanel();
        deleteButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        addButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        header = new lagatrix.gui.components.complex.fragment.Header();
        editButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();
        jScrollPane = new javax.swing.JScrollPane();
        rowContainer = new lagatrix.gui.components.complex.containers.RowContainer();
        connectButton = new lagatrix.gui.components.simple.buttons.DefaulRoundButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lagatrix");

        mainPanel.setBackground(new java.awt.Color(245, 245, 245));
        mainPanel.setRadius(61);

        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Añadir");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        header.setFather(this);

        editButton.setText("Editar");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jScrollPane.setBorder(null);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setViewportView(rowContainer);

        connectButton.setText("Conectar");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ConnectionFormularyView formView;

        try {
            formView = new ConnectionFormularyView(reader);

            new FormularyWindow(this, formView).setVisible(true);

            if (formView.isCorrectLastResoult()) {
                rowContainer.addRow(new ConnecionRow((Connection) formView.getEntity()));
            }
        } catch (NullPointerException e) {
            System.out.println("No hay ninguna conexión seleccionada");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            reader.deleteConnection((Connection) rowContainer.getSelectedRow().getEntity());
            rowContainer.setSelectedRow(null);
            refresh();
        } catch (NullPointerException ex) {
            System.out.println("No hay ninguna conexión seleccionada");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        ConnectionFormularyView formView;

        try {
            formView = new ConnectionFormularyView(reader,
                    (Connection) rowContainer.getSelectedRow().getEntity());

            new FormularyWindow(this, formView).setVisible(true);

            rowContainer.getSelectedRow().setEntity(formView.getEntity());
            refresh();
        } catch (NullPointerException e) {
            System.out.println("No hay ninguna conexión seleccionada");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        try {
            reader.writeChanges();
            new LoginWindow(this, (Connection) rowContainer.getSelectedRow().getEntity()).setVisible(true);
        } catch (NullPointerException ex) {
            System.out.println("No hay ninguna conexión seleccionada");
        } catch (ConnectionException ex) {
            System.out.println("Error al connectarse con el servidor");
        } catch (FileException ex) {
            System.out.println("Error al guardar las conexiones");
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    @Override
    public void dispose() {
        super.dispose();

        try {
            reader.close();
        } catch (FileException ex) {
            System.out.println("Can't save the changes");
        }
    }

    private void refresh() {
        rowContainer.clearContainer();

        for (Connection con : reader.getsConnections()) {
            rowContainer.addRow(new ConnecionRow(con));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton addButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton connectButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton deleteButton;
    private lagatrix.gui.components.simple.buttons.DefaulRoundButton editButton;
    private lagatrix.gui.components.complex.fragment.Header header;
    private javax.swing.JScrollPane jScrollPane;
    private lagatrix.gui.components.simple.RoundPanel mainPanel;
    private lagatrix.gui.components.complex.containers.RowContainer rowContainer;
    // End of variables declaration//GEN-END:variables
}
