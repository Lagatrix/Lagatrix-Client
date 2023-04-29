package lagatrix.tools.generator;

import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import lagatrix.exceptions.connection.AlgorithmException;

/**
 * This clas generate AES keys pair.
 *
 * @author javierfh03
 * @since 0.2
 */
public class AESGenerator {
    
    /**
     * This method create an AES keys
     * 
     * @return The key.
     * @throws AlgorithmException If can't create the RSA keys.
     */
    public static SecretKey generateKey() throws AlgorithmException {
        KeyGenerator keyGen;
        
        try {
            keyGen = KeyGenerator.getInstance("AES");
            
            keyGen.init(128);
            
            return keyGen.generateKey();
        } catch (NoSuchAlgorithmException ex) {
           throw new AlgorithmException("Can't create RSA keys");
        }
    }
}
