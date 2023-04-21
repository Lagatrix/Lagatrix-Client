package lagatrix.client.connection.communicators;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Request;
import lagatrix.client.entities.connection.Response;
import lagatrix.client.exceptions.connection.AlgorithmException;
import lagatrix.client.exceptions.connection.BadClassFormatException;
import lagatrix.client.exceptions.connection.ConnectionInOutException;

/**
 * This class manage the Request and Response objects with AES encryption.
 *
 * @author javierfh03
 * @since 0.2
 */
public class AESCommunicator extends CommunicatorBase {
    
    private SecretKey key;

    /**
     * The constructor of the class.
     * 
     * @param socket The client socket.
     * @param key The AES key.
     * @throws ConnectionInOutException If have an I/O error when create 
     * connection.
     */
    public AESCommunicator(Socket socket, SecretKey key) throws ConnectionInOutException {
        super(socket);
        this.key = key;
        this.socket = socket;
    }

    @Override
    public void sendRequest(Request request) throws ConnectionInOutException, AlgorithmException {
        Cipher encryptCipher;
        SealedObject sealedObject;
        
        try {
            encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);
            
            sealedObject = new SealedObject( (Serializable) request, encryptCipher);
            
            out.writeObject(sealedObject);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            throw new AlgorithmException("AES");
        }  catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.SEND, ex));
        }
    }

    @Override
    public Response obtainResponse() throws ConnectionInOutException, AlgorithmException, BadClassFormatException {
        Cipher encryptCipher;
        SealedObject sealedObject;
        try {
            encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            
            encryptCipher.init(Cipher.DECRYPT_MODE, key);
            
            sealedObject = (SealedObject) in.readObject();
        
            return (Response) sealedObject.getObject(encryptCipher);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            throw new AlgorithmException(AlgorithmException.getMessageAlgorithm(ex, "AES"));
        } catch (ClassNotFoundException | BadPaddingException ex) {
            throw new BadClassFormatException();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.RECEIVE, ex));
        }
    }

}