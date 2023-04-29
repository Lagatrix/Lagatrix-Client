package lagatrix.connection.communicators;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import lagatrix.connection.server.ObjectSocket;
import lagatrix.entities.actions.ActionsEnum;
import lagatrix.entities.connection.Request;
import lagatrix.entities.connection.Response;
import lagatrix.exceptions.connection.AlgorithmException;
import lagatrix.exceptions.connection.BadClassFormatException;
import lagatrix.exceptions.connection.ConnectionInOutException;

/**
 * This class manage the Request and Response objects with RSA encryption.
 *
 * @author javierfh03
 * @since 0.2
 */
public class RSACommunicator extends CommunicatorBase {
    
    private PrivateKey privateKey;
    private PublicKey publicKey;

    /**
     * The constructor of the class.
     * 
     * @param socket The client socket.
     * @param pair The pair of RSA keys.
     * @throws ConnectionInOutException If have an I/O error when create 
     * connection.
     */
    public RSACommunicator(ObjectSocket socket, KeyPair pair) throws ConnectionInOutException {
        super(socket);
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public RSACommunicator(ObjectSocket socket, PublicKey publicKey) throws ConnectionInOutException {
        super(socket);
        this.publicKey = publicKey;
    }

    @Override
    public void sendRequest(Request request) throws ConnectionInOutException, AlgorithmException {
        Cipher encryptCipher;
        SealedObject sealedObject;
        
        try {
            encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            
            sealedObject = new SealedObject( (Serializable) request, encryptCipher);
            
            socket.getOut().writeObject(sealedObject);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            throw new AlgorithmException("RSA");
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
            encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            sealedObject = (SealedObject) socket.getIn().readObject();

            return (Response) sealedObject.getObject(encryptCipher);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException ex) {
            throw new AlgorithmException(AlgorithmException.getMessageAlgorithm(ex, "RSA"));
        } catch (ClassNotFoundException | BadPaddingException ex) {
            throw new BadClassFormatException();
        } catch (IOException ex) {
            throw new ConnectionInOutException(ConnectionInOutException.getMessageIO(
                    this.getClass(), ActionsEnum.RECEIVE, ex));
        }
    }

}
