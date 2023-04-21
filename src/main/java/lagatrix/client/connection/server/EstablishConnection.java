package lagatrix.client.connection.server;

import java.net.Socket;
import java.security.KeyPair;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import lagatrix.client.connection.communicators.AESCommunicator;
import lagatrix.client.connection.communicators.PlainCommunicator;
import lagatrix.client.connection.communicators.RSACommunicator;
import lagatrix.client.entities.actions.ActionsEnum;
import lagatrix.client.entities.connection.Request;
import lagatrix.client.exceptions.connection.AlgorithmException;
import lagatrix.client.exceptions.connection.BadClassFormatException;
import lagatrix.client.exceptions.connection.ConnectionInOutException;
import lagatrix.client.tools.generator.AESGenerator;

/**
 * This method establish the communication with the server exchanging the RSA 
 * and AES keys.
 *
 * @author javierfh03
 * @since 0.2
 */
public class EstablishConnection {

    private Socket socket;
    private SecretKey aesKey;
    private PublicKey pubKey;

    /**
     * The constructor of the class.
     * 
     * @param socket The socket of the client.
     * @throws AlgorithmException If can't create an pair.
     */
    public EstablishConnection(Socket socket) throws AlgorithmException {
        this.socket = socket;
        this.aesKey = AESGenerator.generateKey();
    }

    /**
     * Obtain the generated AES key.
     * 
     * @return The key.
     */
    public SecretKey getAESKey() {
        return aesKey;
    }
    
    /**
     * This method obtain the RSA publick key of the server.
     * 
     * @throws ConnectionInOutException If the connection not set.
     * @throws AlgorithmException If an error occurs with the key.
     * @throws BadClassFormatException If the client sends an invalid class.
     */
    public void obtainRSA() throws ConnectionInOutException, AlgorithmException, BadClassFormatException {
        PlainCommunicator pc = new PlainCommunicator(socket);
        
        this.pubKey = (PublicKey) pc.obtainResponse().getResponse();
        
        pc.close();
    }
    
    /**
     * This method send the generated AES to the server.
     * 
     * @throws ConnectionInOutException If the connection not set.
     * @throws AlgorithmException If an error occurs with the key.
     */
    public void sendAES() throws ConnectionInOutException, AlgorithmException {
        RSACommunicator rsac = new RSACommunicator(socket, pubKey);
        
        rsac.sendRequest(new Request(ActionsEnum.SEND, null, aesKey));
        
        rsac.close();
    }
}
