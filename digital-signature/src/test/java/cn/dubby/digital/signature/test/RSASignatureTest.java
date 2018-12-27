package cn.dubby.digital.signature.test;

import cn.dubby.digital.signature.RSASignature;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

public class RSASignatureTest {

    private static final String key_algorithm = "RSA";

    private static final int key_size = 1024;

    private static final String data = "Hello, Dubby";

    @Test
    public void test() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(key_algorithm);
        keyPairGenerator.initialize(key_size);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));

        //使用私钥加签
        byte[] sign = RSASignature.sign(privateKey.getEncoded(), dataBytes);

        //使用公钥验签
        boolean verifyResult = RSASignature.verify(publicKey.getEncoded(), dataBytes, sign);

        System.out.println(verifyResult);
        Assert.assertTrue(verifyResult);
    }

}
