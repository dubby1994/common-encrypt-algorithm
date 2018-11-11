package cn.dubby.symmetric.encryption.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.symmetric.encryption.AES;
import cn.dubby.symmetric.encryption.DES;
import org.junit.Test;

import javax.crypto.*;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AESTest {

    @Test
    public void encryptDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        String data = "Hello, world.";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        byte[] encryptBytes = AES.encrypt(keyBytes, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(encryptBytes));

        byte[] decryptBytes = AES.decrypt(keyBytes, encryptBytes);
        System.out.println(new String(decryptBytes, Charset.forName("UTF-8")));
    }

}
