package cn.dubby.encrypt.encoding.test;

import cn.dubby.encrypt.encoding.HexUtil;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

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

}
