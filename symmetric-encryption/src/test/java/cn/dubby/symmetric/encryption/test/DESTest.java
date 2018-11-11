package cn.dubby.symmetric.encryption.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.symmetric.encryption.DES;
import org.junit.Test;

import javax.crypto.*;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DESTest {

    @Test
    public void encryptDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        String data = "Hello, world.";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        byte[] encryptBytes = DES.encrypt(keyBytes, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(encryptBytes));

        byte[] decryptBytes = DES.decrypt(keyBytes, encryptBytes);
        System.out.println(new String(decryptBytes, Charset.forName("UTF-8")));
    }

}
