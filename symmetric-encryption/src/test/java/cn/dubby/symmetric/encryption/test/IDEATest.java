package cn.dubby.symmetric.encryption.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.symmetric.encryption.IDEA;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class IDEATest {

    @Test
    public void encryptDecrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String data = "Hello, world.";

        byte[] keyBytes = IDEA.initKey();
        byte[] encryptBytes = IDEA.encrypt(keyBytes, data.getBytes(Charset.forName("UTF-8")));

        System.out.println(HexUtil.toHex(encryptBytes));

        byte[] decryptBytes = IDEA.decrypt(keyBytes, encryptBytes);

        System.out.println(new String(decryptBytes, Charset.forName("UTF-8")));
    }

}
