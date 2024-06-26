package lagatrix.gui.window;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lagatrix.connection.RequesterManager;
import lagatrix.connection.communicators.AESCommunicator;
import lagatrix.entities.dto.Connection;
import lagatrix.entities.dto.hardware.CPU;
import lagatrix.entities.dto.hardware.GPU;
import lagatrix.entities.dto.hardware.RAM;
import lagatrix.entities.dto.os.OSInformation;
import lagatrix.exceptions.BadExecutionException;
import lagatrix.exceptions.connection.ConnectionException;
import lagatrix.exceptions.connection.ConnectionInOutException;
import lagatrix.gui.components.simple.MenuLabel;
import lagatrix.gui.dialog.status.ErrorDialog;
import lagatrix.gui.views.main.form.MainView;
import lagatrix.tools.detector.DistroImageDetector;

/**
 * This windows represents the main window of the program.
 *
 * @author javierfh03
 * @since 0.1
 */
public class MainWindow extends javax.swing.JFrame {

    private MainView selectedView;
    private AESCommunicator communicator;
    private RequesterManager requester;
    private Connection connection;

    /**
     * Constructor of the class.
     *
     * @param communicator The communicator with the server.
     * @param connection The connection with server entity.
     */
    public MainWindow(AESCommunicator communicator, Connection connection) {
        this.communicator = communicator;
        this.connection = connection;
        this.requester = new RequesterManager(communicator);

        setUndecorated(true);
        initComponents();
        setBackground(new Color(0.0F, 0.0F, 0.0F, 0.0F));
        header.seeDimiss(true);
        
        inicialiceViews();
        setListener();
    }

    /**
     * Change the view with menu components.
     *
     * @param view The view to see.
     * @param menuLabel The label who add listener.
     */
    private void changeView(MainView view, MenuLabel menuLabel) {
        selectedView.stop();
        selectedView.setVisible(false);

        selectedView = view;

        menu.selectLabel(menuLabel);
        view.setVisible(true);
        view.start();
    }
    
    /**
     * Obtain the system information.
     */
    private void inicialiceViews() {
        CPU cpu;
        RAM ram;
        GPU gpu;
        OSInformation information;
        
        try {
            information = (OSInformation) requester.makeReadRequest(OSInformation.class).getResponse();
            cpu = (CPU) requester.makeReadRequest(CPU.class).getResponse();
            ram = (RAM) requester.makeReadRequest(RAM.class).getResponse();
            gpu = (GPU) requester.makeReadRequest(GPU.class).getResponse();
            
            information.setDistroImage(new DistroImageDetector(information).getImage());
            connection.setImage(information.getDistroImage());
            
            monitoringView.setInformation(information, cpu, ram, gpu);
            applicationView.setPackageManager(information.getPackageManager());
            actionsView.setInformation(information, cpu, ram, gpu);
        } catch (BadExecutionException ex) {
            new ErrorDialog(this, "No se obtuvieron los datos del sistema", 
                    false).setVisible(true);
        } catch (ConnectionException ex) {
            new ErrorDialog(this, "Ocurrió un error de red al obtener datos del sistema", 
                    true).setVisible(true);
        }
        
        selectedView = monitoringView;
        selectedView.start();
    }

    private void setListener() {
        menu.getMonitoringLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(monitoringView, menu.getMonitoringLabel());
            }
        });

        menu.getPartitionLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(partitionView, menu.getPartitionLabel());
            }
        });

        menu.getUserLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(userView, menu.getUserLabel());
            }
        });

        menu.getEventLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(eventView, menu.getEventLabel());
            }
        });

        menu.getProcessLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(processView, menu.getProcessLabel());
            }
        });

        menu.getApplicationLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(applicationView, menu.getApplicationLabel());
            }
        });

        menu.getActionsLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeView(actionsView, menu.getActionsLabel());
            }
        });

        menu.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose();
        
        try {
            selectedView.stop();
            
            if (communicator.isActive()) {
                requester.makeReadRequest(null, null);
            }
        } catch (BadExecutionException | ConnectionException ex) {
             new ErrorDialog(this, "No se cerró la conexión con el servidor correctamente", 
                    false).setVisible(true);
        } finally {
            try {
                communicator.close();
            } catch (ConnectionInOutException ex) {
                new ErrorDialog(this, "No se cerró la conexión correctamente", 
                    false).setVisible(true);
            }
        }
        
        new ConnectionWindow().open(connection);
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
        header = new lagatrix.gui.components.complex.fragment.Header();
        menu = new lagatrix.gui.components.complex.fragment.Menu();
        viewsPanel = new javax.swing.JPanel();
        monitoringView = new lagatrix.gui.views.main.form.MonitoringView();
        actionsView = new lagatrix.gui.views.main.form.ActionsView();
        applicationView = new lagatrix.gui.views.main.form.ApplicationView();
        processView = new lagatrix.gui.views.main.form.ProcessView();
        eventView = new lagatrix.gui.views.main.form.EventView();
        userView = new lagatrix.gui.views.main.form.UserView();
        partitionView = new lagatrix.gui.views.main.form.PartitionView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lagatrix");
        setIconImage(new ImageIcon(getClass().getResource("/logo.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1101, 606));
        setMinimumSize(new java.awt.Dimension(1101, 606));
        setResizable(false);
        setSize(new java.awt.Dimension(1101, 606));

        mainPanel.setBackground(new java.awt.Color(245, 245, 245));
        mainPanel.setRadius(61);

        header.setFather(this);

        viewsPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewsPanel.setPreferredSize(new java.awt.Dimension(885, 552));
        viewsPanel.setLayout(new java.awt.CardLayout());

        monitoringView.setRequester(requester);
        viewsPanel.add(monitoringView, "card8");

        actionsView.setRequester(requester);
        viewsPanel.add(actionsView, "card2");

        applicationView.setRequester(requester);
        viewsPanel.add(applicationView, "card3");

        processView.setRequester(requester);
        viewsPanel.add(processView, "card4");

        eventView.setRequester(requester);
        viewsPanel.add(eventView, "card5");

        userView.setRequester(requester);
        viewsPanel.add(userView, "card6");

        partitionView.setRequester(requester);
        viewsPanel.add(partitionView, "card7");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(viewsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lagatrix.gui.views.main.form.ActionsView actionsView;
    private lagatrix.gui.views.main.form.ApplicationView applicationView;
    private lagatrix.gui.views.main.form.EventView eventView;
    private lagatrix.gui.components.complex.fragment.Header header;
    private lagatrix.gui.components.simple.RoundPanel mainPanel;
    private lagatrix.gui.components.complex.fragment.Menu menu;
    private lagatrix.gui.views.main.form.MonitoringView monitoringView;
    private lagatrix.gui.views.main.form.PartitionView partitionView;
    private lagatrix.gui.views.main.form.ProcessView processView;
    private lagatrix.gui.views.main.form.UserView userView;
    private javax.swing.JPanel viewsPanel;
    // End of variables declaration//GEN-END:variables
}
