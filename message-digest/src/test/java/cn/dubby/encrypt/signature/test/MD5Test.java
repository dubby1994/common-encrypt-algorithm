/**
 * @author daoxuan
 * @date 2018/11/9 16:09
 */
package cn.dubby.encrypt.signature.test;

import cn.dubby.encrypt.encoding.HexUtil;
import cn.dubby.encrypt.signature.MD5;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

public class MD5Test {

    @Test
    public void digest() throws NoSuchAlgorithmException {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));
        byte[] digestBytes = MD5.digest(dataBytes);

        System.out.println(HexUtil.toHex(digestBytes));
        System.out.println(Hex.encodeHexString(digestBytes));
    }

    @Test
    public void commonsCodecDigest() {
        String data = "Hello, world.MD5消息摘要";
        byte[] dataBytes = data.getBytes(Charset.forName("UTF-8"));
        byte[] digestBytes = org.apache.commons.codec.digest.DigestUtils.md5(dataBytes);

        System.out.println(HexUtil.toHex(digestBytes));
        System.out.println(Hex.encodeHexString(digestBytes));
    }

}
