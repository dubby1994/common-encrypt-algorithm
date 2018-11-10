/**
 * @author daoxuan
 * @date 2018/11/9 16:20
 */
package cn.dubby.encrypt.encoding.test;

import cn.dubby.encrypt.encoding.Base64Util;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;

public class Base64UtilTest {

    @Test
    public void encodeDecode() {
        String originStr = "Hello, world.你好，世界。" + System.currentTimeMillis();
        byte[] srcBytes = originStr.getBytes(Charset.forName("UTF-8"));
        byte[] encodeBytes = Base64Util.encode(srcBytes);
        String encodeStr = new String(encodeBytes, Charset.forName("UTF-8"));
        System.out.println(encodeStr);

        byte[] decodeBytes = Base64Util.decode(encodeBytes);
        String decodeStr = new String(decodeBytes, Charset.forName("UTF-8"));
        System.out.println(decodeStr);

        Assert.assertEquals(originStr,  decodeStr);
    }

    @Test
    public void encodeDecodeURLSafe() {
        String originStr = "Hello, world.你好，世界。" + System.currentTimeMillis();
        byte[] srcBytes = originStr.getBytes(Charset.forName("UTF-8"));
        byte[] encodeBytes = Base64Util.encodeURLSafe(srcBytes);
        String encodeStr = new String(encodeBytes, Charset.forName("UTF-8"));
        System.out.println(encodeStr);

        byte[] decodeBytes = Base64Util.decodeURLSafe(encodeBytes);
        String decodeStr = new String(decodeBytes, Charset.forName("UTF-8"));
        System.out.println(decodeStr);

        Assert.assertEquals(originStr,  decodeStr);
    }

}
