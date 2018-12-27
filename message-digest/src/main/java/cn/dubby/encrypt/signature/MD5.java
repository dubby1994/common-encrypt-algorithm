/**
 * @author daoxuan
 * @date 2018/11/9 16:09
 */
package cn.dubby.encrypt.signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static byte[] digest(byte[] data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(data);
        return digest.digest();
        //return digest.digest(data);
    }

}
