package lagatrix.tools.detector;

import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import lagatrix.entities.dto.os.OSInformation;

/**
 * This class detect the image who use an distro of Linux.
 *
 * @author javierfh03
 * @since 0.1
 */
public class DistroImageDetector {
    
    private OSInformation os;

    /**
     * The constructor of the class.
     * 
     * @param os The OSInformation object
     */
    public DistroImageDetector(OSInformation os) {
        this.os = os;
    }
    
    /**
     * Obtain the image of the distro.
     * 
     * @return The image of the distro.
     */
    public ImageIcon getImage(){
        String name = detectDistroImage();
        
        if (name.equals("default")){
            name = detectFamilyImage();
        }
        
        return new ImageIcon(getClass().getResource(String.format(
                "/distros/%s.png", name)));
    }
    
    /**
     * Detect with distro name.
     * 
     * @return The name of image.
     */
    private String detectDistroImage() {
        String distro = os.getDistributionName().toLowerCase();
        
        if (Pattern.compile(".*ubuntu.*").matcher(distro).find()){
            return "ubuntu";
        } else if (Pattern.compile(".*cent.*").matcher(distro).find()) {
            return "centos";
        } else if (Pattern.compile(".*fedora.*").matcher(distro).find()) {
            return "fedora";
        } else if (Pattern.compile(".*raspbian.*").matcher(distro).find()) {
            return "raspbian";
        } else if (Pattern.compile(".*debian.*").matcher(distro).find()) {
            return "debian";
        } else if (Pattern.compile(".*arch.*").matcher(distro).find()) {
            return "arch";
        } else if (Pattern.compile(".*manjaro.*").matcher(distro).find()) {
            return "manjaro";
        } else if (Pattern.compile(".*suse.*").matcher(distro).find()) {
            return "suse";
        } else if (Pattern.compile(".*red hat.*").matcher(distro).find()) {
            return "redhat";
        } else if (Pattern.compile(".*alma.*").matcher(distro).find()) {
            return "alma";
        } else if (Pattern.compile(".*rocky.*").matcher(distro).find()) {
            return "rocky";
        }
        
        return "default";
    }
    
    /**
     * Detect with family name.
     * 
     * @return The name of image.
     */
    private String detectFamilyImage() {
        String family = os.getDistributionFamily().toLowerCase();
        
        if (Pattern.compile(".*debian.*").matcher(family).find()){
            return "debian";
        } else if (Pattern.compile(".*rhel.*").matcher(family).find()) {
            return "redhat";
        } else if (Pattern.compile(".*arch.*").matcher(family).find()) {
            return "arch";
        } else if (Pattern.compile(".*suse.*").matcher(family).find()) {
            return "suse";
        }
        
        return "default";
    }
}
