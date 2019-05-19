package cn.dubby.encrypt.signature.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.encrypt.signature.MAC;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MACTest {

    private static final String data = "Hello, world.";

    @Test
    public void hmacMD5() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyByte = secretKey.getEncoded();

        byte[] result = MAC.hmacMD5(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));

        result = MAC.hmacMD5(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));
    }

    @Test
    public void hmacSHA256() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyByte = secretKey.getEncoded();

        byte[] result = MAC.hmacSHA256(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));

        result = MAC.hmacSHA256(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));
    }

    @Test
    public void hmacSHA384() throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA384");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyByte = secretKey.getEncoded();

        byte[] result = MAC.hmacSHA384(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));

        result = MAC.hmacSHA384(keyByte, data.getBytes(Charset.forName("UTF-8")));
        System.out.println(HexUtil.toHex(result));
    }

}
