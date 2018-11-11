package cn.dubby.symmetric.encryption;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @see javax.crypto.spec.DESedeKeySpec
 */
public class DESede {

    private static final String key_algorithm = "DESede";

    private static final String cipher_algorithm = "DESede/ECB/PKCS5Padding";

    public static byte[] encrypt(byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(key_algorithm);
        SecretKey secretKey = keyFactory.generateSecret(deSedeKeySpec);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(key_algorithm);
        SecretKey secretKey = keyFactory.generateSecret(deSedeKeySpec);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

}
