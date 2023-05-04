package lagatrix.entities.dto;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * This entity represents an connection of server.
 * 
 * @author javierfh03
 * @since 0.3
 */
public class Connection implements Serializable {
    
    private ImageIcon image;
    private String name;
    private InetAddress ip;
    private int port;

    public Connection() {
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Connection other = (Connection) obj;
        if (this.port != other.port) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return Objects.equals(this.ip, other.ip);
    }

    @Override
    public String toString() {
        return "Connection{" + "name=" + name + ", ip=" + ip + ", port=" + port + '}';
    }

    
    
}
