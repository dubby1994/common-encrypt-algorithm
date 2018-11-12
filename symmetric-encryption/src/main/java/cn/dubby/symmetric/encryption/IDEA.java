package cn.dubby.symmetric.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class IDEA {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String key_algorithm = "IDEA";

    private static final String cipher_algorithm = "IDEA/ECB/ISO10126Padding";

    public static byte[] encrypt(byte[] keyBytes, byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] keyBytes, byte[] data) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        SecretKey secretKey = new SecretKeySpec(keyBytes, key_algorithm);

        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    /**
     * 生成一个随机的秘钥
     */
    public static byte[] initKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(key_algorithm);
        keyGenerator.init(128);

        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

}
