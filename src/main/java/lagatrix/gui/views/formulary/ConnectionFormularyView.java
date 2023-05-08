package lagatrix.gui.views.formulary;

import java.net.UnknownHostException;
import lagatrix.entities.dto.Connection;
import lagatrix.file.ConnectionReader;

/**
 * This forms represents the manage of connections.
 * 
 * @author javierfh03
 * @since 0.2
 */
public class ConnectionFormularyView extends FormularyView {

    private Connection connection;
    private ConnectionReader reader;

    public ConnectionFormularyView(ConnectionReader reader) {
        this.reader = reader;
        initComponents();
    }
    
    /**
     * Constructor of the class.
     * 
     * @param reader
     * @param connection
     */
    public ConnectionFormularyView(ConnectionReader reader, Connection connection) {
        this(reader);
        this.connection = connection;
        
        nameInput.setDefaultValue(connection.getName());
        ipInput.setDefaultValue(connection.getIp().getHostAddress());
        portInput.setDefaultValue(connection.getPort() + "");
        
        edit = true;
    }
    
    @Override
    public Object obtainEntity() {
        Connection connection = new Connection();
        
        check(connection);
        
        return connection;
    }

    @Override
    public Object getEntity() {
        return connection;
    }
    
    @Override
    public void makeAdd() {
        Connection con = (Connection) obtainEntity();
        
        reader.insertConnection(con);
        
        if (resoult) {
            connection = con;
        }
    }

    @Override
    public void makeEdit() {
        Connection con = (Connection) obtainEntity();
        
        reader.modifyConnection(connection, con);
        
        if (resoult) {
            connection = con;
        }
    }
    
    private void check(Connection connection) {
        try {
            connection.setName(nameInput.getValue());
            connection.setIp(ipInput.getValue());
            connection.setPort(Integer.parseInt(portInput.getValue()));
            resoult = true;
        } catch (NumberFormatException e) {
            System.out.println("Puerto inválido");
            resoult = false;
        } catch (UnknownHostException ex) {
            System.out.println("IP inválido");
            resoult = false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameInput = new lagatrix.gui.components.simple.input.DefaultInput();
        ipInput = new lagatrix.gui.components.simple.input.DefaultInput();
        portInput = new lagatrix.gui.components.simple.input.DefaultInput();

        setPreferredSize(new java.awt.Dimension(536, 212));

        nameInput.setDefaultValue("");
        nameInput.setDescriptionText("NOMBRE");

        ipInput.setDefaultValue("");
        ipInput.setDescriptionText("IP");

        portInput.setDefaultValue("");
        portInput.setDescriptionText("PUERTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(ipInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(portInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ipInput, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(portInput, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.gui.components.simple.input.DefaultInput ipInput;
    private lagatrix.gui.components.simple.input.DefaultInput nameInput;
    private lagatrix.gui.components.simple.input.DefaultInput portInput;
    // End of variables declaration//GEN-END:variables

}
