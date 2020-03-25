package cn.dubby.encrypt.encoding.test;

import cn.dubby.encrypt.encoding.HexUtil;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class HexUtilTest {

    @Test
    public void toHex() {
        byte[] bytes = {(byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 255, (byte) 254};
        System.out.println(HexUtil.toHex(bytes));
        System.out.println(new String(Hex.encodeHex(bytes)));
    }

    @Test
    public void toBytes() throws Exception {
        byte[] bytes = {(byte) 0, (byte) 1, (byte) 2, (byte) 3};
        String s = HexUtil.toHex(bytes);
        byte[] result = HexUtil.toBytes(s);

        Assert.assertArrayEquals(bytes, result);
    }

    @Test
    public void test() {
        System.out.println("Byte MAX:\t" + Byte.MAX_VALUE);

        //Base64
        System.out.println((1 << 6) - 1);
        //Base32
        System.out.println((1 << 5) - 1);

        for (int i = 0; i < 9; ++i) {
            System.out.println(i + "\t" + (1 << i - 1));
        }
    }

    @Test
    public void testMatch() {
        String str = "我是道玄，我在测试，abc哈哈哈";
        String subStr1 = "道玄";
        String subStr2 = "a";
        String subStr3 = "道";
        String subStr4 = "玄";

        String hex = HexUtil.toHex(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(hex);

        String subHex1 = HexUtil.toHex(subStr1.getBytes(StandardCharsets.UTF_8));
        System.out.println(subHex1);
        System.out.println(hex.indexOf(subHex1));

        String subHex2 = HexUtil.toHex(subStr2.getBytes(StandardCharsets.UTF_8));
        System.out.println(subHex2);
        System.out.println(hex.indexOf(subHex2));

        String subHex3 = HexUtil.toHex(subStr3.getBytes(StandardCharsets.UTF_8));
        System.out.println(subHex3);
        System.out.println(hex.indexOf(subHex3));

        String subHex4 = HexUtil.toHex(subStr4.getBytes(StandardCharsets.UTF_8));
        System.out.println(subHex4);
        System.out.println(hex.indexOf(subHex4));
    }

}
