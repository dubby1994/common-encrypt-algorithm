package cn.dubby.symmetric.encryption;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @see SecretKeySpec
 */
public class AES_PCBC {

    private static final String key_algorithm = "AES";

    private static final String cipher_algorithm = "AES/PCBC/PKCS5Padding";

    public static byte[] encrypt(byte[] ivBytes, byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        /**
         * 对于某些JDK不支持的工作方式，可以考虑 Cipher cipher = Cipher.getInstance(cipher_algorithm, "BC);
         * 其中BC是Bouncy Castle的简称
         */
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] ivBytes, byte[] keyBytes, byte[] data) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));
        return cipher.doFinal(data);
    }

}
