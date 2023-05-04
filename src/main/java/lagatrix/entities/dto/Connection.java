package lagatrix.entities.dto;

import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * This entity represents an connection of server.
 * 
 * @author javierfh03
 * @since 0.3
 */
public class Connection {
    
    private ImageIcon image;
    private String name, ip;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        return Objects.equals(this.name, other.name);
    }
    
}