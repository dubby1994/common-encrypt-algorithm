package cn.dubby.encrypt.signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {

    public static byte[] sha1(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(data);
        return digest.digest();
        //return digest.digest(data);
    }

    public static byte[] sha256(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(data);
        return digest.digest();
        //return digest.digest(data);
    }

    public static byte[] sha512(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.update(data);
        return digest.digest();
        //return digest.digest(data);
    }

}
