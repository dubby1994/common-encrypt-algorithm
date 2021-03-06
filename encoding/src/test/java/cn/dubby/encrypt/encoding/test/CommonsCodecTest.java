package cn.dubby.encrypt.encoding.test;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

/**
 * 使用commons-codec实现Base64编解码
 * 恕我直言，这个API太难用了
 */
public class CommonsCodecTest {

    private static final String originStr = "Hello, world.你好，世界。" + System.currentTimeMillis();

    @Test
    public void encodeDecodeBase64() {
        System.out.println("encodeDecodeBase64");
        byte[] srcBytes = originStr.getBytes(Charset.forName("UTF-8"));
        byte[] encodeBytes = Base64.encodeBase64(srcBytes);
        String encodeStr = new String(encodeBytes, Charset.forName("UTF-8"));
        System.out.println(encodeStr);

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        String decodeStr = new String(decodeBytes, Charset.forName("UTF-8"));
        System.out.println(decodeStr);

        Assert.assertEquals(originStr,  decodeStr);
    }

    @Test
    public void encodeDecodeURLSafeBase64() {
        System.out.println("encodeDecodeURLSafeBase64");
        byte[] srcBytes = originStr.getBytes(Charset.forName("UTF-8"));
        byte[] encodeBytes = Base64.encodeBase64URLSafe(srcBytes);
        String encodeStr = new String(encodeBytes, Charset.forName("UTF-8"));
        System.out.println(encodeStr);

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        String decodeStr = new String(decodeBytes, Charset.forName("UTF-8"));
        System.out.println(decodeStr);

        Assert.assertEquals(originStr,  decodeStr);
    }

    @Test
    public void encodeDecodeBase32() {
        System.out.println("encodeDecodeBase32");
        byte[] srcBytes = originStr.getBytes(Charset.forName("UTF-8"));
        Base32 base32 = new Base32();
        byte[] encodeBytes = base32.encode(srcBytes);
        String encodeStr = new String(encodeBytes, Charset.forName("UTF-8"));
        System.out.println(encodeStr);

        byte[] decodeBytes = base32.decode(encodeBytes);
        String decodeStr = new String(decodeBytes, Charset.forName("UTF-8"));
        System.out.println(decodeStr);

        Assert.assertEquals(originStr,  decodeStr);
    }

}
