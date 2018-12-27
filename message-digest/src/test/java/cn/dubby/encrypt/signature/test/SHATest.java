/**
 * @author daoxuan
 * @date 2018/11/9 16:09
 */
package cn.dubby.encrypt.signature.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.encrypt.signature.MD5;
import cn.dubby.encrypt.signature.SHA;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

public class SHATest {

    @Test
    public void sha() throws NoSuchAlgorithmException {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));
        byte[] digestBytes = SHA.sha1(dataBytes);

        System.out.println(HexUtil.toHex(digestBytes));
        System.out.println(Hex.encodeHexString(digestBytes));
    }

    @Test
    public void sha256() throws NoSuchAlgorithmException {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));
        byte[] digestBytes = SHA.sha256(dataBytes);

        System.out.println(HexUtil.toHex(digestBytes));
        System.out.println(Hex.encodeHexString(digestBytes));
    }

    @Test
    public void sha512() throws NoSuchAlgorithmException {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));
        byte[] digestBytes = SHA.sha512(dataBytes);

        System.out.println(HexUtil.toHex(digestBytes));
        System.out.println(Hex.encodeHexString(digestBytes));
    }

    @Test
    public void commonsCodecSHA() {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));

        System.out.println(DigestUtils.sha1Hex(dataBytes));
        System.out.println(DigestUtils.sha256Hex(dataBytes));
        System.out.println(DigestUtils.sha512Hex(dataBytes));
    }

}
