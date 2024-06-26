package lagatrix.entities.dto.os;

import java.io.Serializable;
import javax.swing.ImageIcon;
import lagatrix.entities.components.PackageManagerComponents;

/**
 * This entity represents a class of data of Linux OS.
 *
 * @author javierfh03
 * @since 0.1
 */
public class OSInformation implements Serializable {
    
    private String distribution, distributionName, distributionFamily, kernel, hostname;
    private float distributionVersion;
    private PackageManagerComponents packageManager;
    private ImageIcon distroImage;

    public OSInformation() {
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getDistributionFamily() {
        return distributionFamily;
    }

    public void setDistributionFamily(String distributionFamily) {
        this.distributionFamily = distributionFamily;
    }

    public String getKernel() {
        return kernel;
    }

    public void setKernel(String kernel) {
        this.kernel = kernel;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public float getDistributionVersion() {
        return distributionVersion;
    }

    public void setDistributionVersion(float distributionVersion) {
        this.distributionVersion = distributionVersion;
    }

    public PackageManagerComponents getPackageManager() {
        return packageManager;
    }

    public void setPackageManager(PackageManagerComponents packageManager) {
        this.packageManager = packageManager;
    }

    public ImageIcon getDistroImage() {
        return distroImage;
    }

    public void setDistroImage(ImageIcon distroImage) {
        this.distroImage = distroImage;
    }

    @Override
    public String toString() {
        return String.format("\tInformación del sistema operativo:\n\t\t"
                + "Distribución: %s\n\t\tFamilia de la distribución: %s\n\t\tKernel:%s", 
                distribution, distributionFamily, kernel);
    }
}