package cn.dubby.symmetric.encryption.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.symmetric.encryption.AES;
import cn.dubby.symmetric.encryption.AES_PCBC;
import org.junit.Test;

import javax.crypto.*;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class AES_PCBCTest {

    @Test
    public void encryptDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        /**
         * iv必须是16位
         */
        String data = "Hello, world.", iv = "1234567812345678";
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        byte[] encryptBytes = AES_PCBC.encrypt(iv.getBytes(Charset.forName("UTF-8")), keyBytes, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(encryptBytes));

        byte[] decryptBytes = AES_PCBC.decrypt(iv.getBytes(Charset.forName("UTF-8")), keyBytes, encryptBytes);
        System.out.println(new String(decryptBytes, Charset.forName("UTF-8")));
    }

}
