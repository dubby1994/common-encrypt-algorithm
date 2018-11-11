package cn.dubby.symmetric.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @see javax.crypto.spec.SecretKeySpec
 */
public class AES {

    private static final String key_algorithm = "AES";

    private static final String cipher_algorithm = "AES/ECB/PKCS5Padding";

    public static byte[] encrypt(byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        /**
         * 对于某些JDK不支持的工作方式，可以考虑 Cipher cipher = Cipher.getInstance(cipher_algorithm, "BC);
         * 其中BC是Bouncy Castle的简称
         */
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

}
