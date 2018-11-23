/**
 * @author daoxuan
 * @date 2018/11/23 13:44
 */
package cn.dubby.asymmetric.encryption;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class RSATest {

    private static final String key_algorithm = "RSA";

    private static final int key_size = 1024;

    private static final String data = "Hello, Dubby";

    @Test
    public void test() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidKeySpecException, NoSuchPaddingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(key_algorithm);
        keyPairGenerator.initialize(key_size);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        //公钥加密，私钥解密
        {
            byte[] encryptBytes = RSA.encryptWithPublicKey(publicKey.getEncoded(), data.getBytes(Charset.forName("UTF-8")));
            System.out.println(Base64.getEncoder().encodeToString(encryptBytes));
            byte[] decryptBytes = RSA.decryptWithPrivateKey(privateKey.getEncoded(), encryptBytes);
            String result = new String(decryptBytes, Charset.forName("UTF-8"));
            System.out.println(result);
            Assert.assertEquals(result, data);
        }

        //私钥加密，公钥解密
        {
            byte[] encryptBytes = RSA.encryptWithPrivateKey(privateKey.getEncoded(), data.getBytes(Charset.forName("UTF-8")));
            System.out.println(Base64.getEncoder().encodeToString(encryptBytes));
            byte[] decryptBytes = RSA.decryptWithPublicKey(publicKey.getEncoded(), encryptBytes);
            String result = new String(decryptBytes, Charset.forName("UTF-8"));
            System.out.println(result);
            Assert.assertEquals(result, data);
        }
    }

}
