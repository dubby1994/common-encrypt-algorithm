/**
 * @author daoxuan
 * @date 2018/11/21 15:45
 */
package cn.dubby.asymmetric.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * JVM Option:-Djdk.crypto.KeyAgreement.legacyKDF=true
 */
public class DHTest {

    private static final String key_algorithm = "AES";

    private static final String cipher_algorithm = "AES/ECB/PKCS5Padding";

    private static final String plainText = "Hello, Dubby";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //构建A的密钥
        DHPrivateKey privateKeyA;
        DHPublicKey publicKeyA;
        {
            KeyPairGenerator keyGeneratorA = KeyPairGenerator.getInstance("DH");
            keyGeneratorA.initialize(512);
            KeyPair keyPair = keyGeneratorA.generateKeyPair();
            privateKeyA = (DHPrivateKey) keyPair.getPrivate();
            publicKeyA = (DHPublicKey) keyPair.getPublic();
        }

        //这里模拟网络传输(A->B)
        byte[] publicKeyBytesA = publicKeyA.getEncoded();

        //构建B的密钥
        DHPrivateKey privateKeyB;
        DHPublicKey publicKeyB;
        DHPublicKey publicKeyA_copy;
        {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytesA);
            KeyFactory keyFactory = KeyFactory.getInstance("DH");
            publicKeyA_copy = (DHPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
            DHParameterSpec dhParameterSpec = ((DHPublicKey) publicKeyA_copy).getParams();
            KeyPairGenerator keyPairGeneratorB = KeyPairGenerator.getInstance("DH");
            keyPairGeneratorB.initialize(dhParameterSpec);
            KeyPair keyPair = keyPairGeneratorB.generateKeyPair();
            privateKeyB = (DHPrivateKey) keyPair.getPrivate();
            publicKeyB = (DHPublicKey) keyPair.getPublic();
        }

        //这里模拟网络传输(B->A)
        byte[] publicKeyBytesB = publicKeyB.getEncoded();

        DHPublicKey publicKeyB_copy;
        {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytesB);
            KeyFactory keyFactory = KeyFactory.getInstance("DH");
            publicKeyB_copy = (DHPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);

        }

        //A发消息
        byte[] encryptTextBytes;
        {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(privateKeyA);
            keyAgreement.doPhase(publicKeyB_copy, true);

            SecretKey secretKey = keyAgreement.generateSecret(key_algorithm);
            Cipher cipher = Cipher.getInstance(cipher_algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptTextBytes = cipher.doFinal(plainText.getBytes(Charset.forName("UTF-8")));
        }

        //B接受消息，并回复
        byte[] decryptTextBytes;
        {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(privateKeyB);
            keyAgreement.doPhase(publicKeyA_copy, true);

            SecretKey secretKey = keyAgreement.generateSecret(key_algorithm);
            Cipher cipher = Cipher.getInstance(cipher_algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptTextBytes = cipher.doFinal(encryptTextBytes);

            System.out.println(new String(decryptTextBytes, Charset.forName("UTF-8")));

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            encryptTextBytes = cipher.doFinal((plainText + "[response]").getBytes(Charset.forName("UTF-8")));
        }

        //A接收消息
        {
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(privateKeyA);
            keyAgreement.doPhase(publicKeyB_copy, true);

            SecretKey secretKey = keyAgreement.generateSecret(key_algorithm);
            Cipher cipher = Cipher.getInstance(cipher_algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            decryptTextBytes = cipher.doFinal(encryptTextBytes);

            System.out.println(new String(decryptTextBytes, Charset.forName("UTF-8")));
        }
    }

}
