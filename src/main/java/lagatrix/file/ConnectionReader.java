package lagatrix.file;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Set;
import lagatrix.entities.dto.Connection;
import lagatrix.exceptions.FileException;

/**
 * This class manage the connections file.
 *
 * @author javierfh03
 * @since 0.3
 */
public class ConnectionReader {

    private File file;
    private Set<Connection> set;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    /**
     * The constructor of the class.
     */
    public ConnectionReader() {
        file = new File("connections.dat");
    }

    /**
     * This method open the file.
     *
     * @throws FileException If can't open the connection.
     */
    public void open() throws FileException {
        try {
            if (file.exists()) {
                in = new ObjectInputStream(new FileInputStream(file));
                set = obtainConnections();
                out = new ObjectOutputStream(new FileOutputStream(file));
            } else {
                file.createNewFile();
                
                out = new ObjectOutputStream(new FileOutputStream(file));
                set = new LinkedHashSet<>();
                in = new ObjectInputStream(new FileInputStream(file));
            }
        } catch (IOException ex) {
            throw new FileException("No se pudo abrir el archivo");
        }
    }

    /**
     * This method insert a connection in the file.
     *
     * @param connection The connection who insert.
     * @return If insert.
     */
    public boolean insertConnection(Connection connection) {
        return set.add(connection);
    }
    
    /**
     * Return the set of connections.
     * 
     * @return The set.
     */
    public Set<Connection> getsConnections() {
        return set;
    }

    /**
     * This method modify a connection.
     *
     * @param connection The connection who change.
     * @param connectionChange The new conenction.
     * @return If modify.
     */
    public boolean modifyConnection(Connection connection, Connection connectionChange) {
        if (!set.contains(connection)) {
            return false;
        }

        set.remove(connection);
        set.add(connectionChange);

        return true;
    }

    /**
     * This method delete a connection of the file.
     *
     * @param connection The connection who change.
     * @return If delete.
     */
    public boolean deleteConnection(Connection connection) {
        return set.remove(connection);
    }
    
    /**
     * This method write the connections.
     *
     * @throws FileException If can't obtain the connections.
     */
    public void writeChanges() throws FileException {
        try {
            for (Connection con : set) {
                out.writeObject(con);
                out.flush();
            }
        } catch (IOException ex) {
            throw new FileException("No se pudieron escribir las conexiones");
        }
    }
    
    /**
     * Close the readers and write changes.
     *
     * @throws FileException In can't close.
     */
    public void close() throws FileException {
        try {
            writeChanges();
            out.close();
            in.close();
        } catch (IOException ex) {
            throw new FileException("Error al cerrar el fichero");
        }
    }

    /**
     * This method obtain the connections.
     *
     * @return A Set with connections.
     * @throws FileException If can't obtain the connections.
     */
    private Set<Connection> obtainConnections() throws FileException {
        Connection tmp;
        Set<Connection> connections = new LinkedHashSet<>();

        try {
            while ((tmp = (Connection) in.readObject()) != null) {
                connections.add(tmp);
            }
        } catch (ClassNotFoundException ex) {
            throw new FileException("Clase inesperada");
        } catch (IOException ex) {
            if (ex.getClass() != EOFException.class) {
                throw new FileException("No se pudieron leer las conexiones");
            }
        }

        return connections;
    }
}
