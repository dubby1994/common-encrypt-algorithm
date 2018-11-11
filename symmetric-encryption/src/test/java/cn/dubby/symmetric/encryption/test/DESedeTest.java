package cn.dubby.symmetric.encryption.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.symmetric.encryption.DESede;
import org.junit.Test;

import javax.crypto.*;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DESedeTest {

    @Test
    public void encryptDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        String data = "Hello, world.";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(112);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        byte[] encryptBytes = DESede.encrypt(keyBytes, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(encryptBytes));

        byte[] decryptBytes = DESede.decrypt(keyBytes, encryptBytes);
        System.out.println(new String(decryptBytes, Charset.forName("UTF-8")));
    }

}
