package cn.dubby.encrypt.encoding.test;

import cn.dubby.encrypt.encoding.HexUtil;
import org.junit.Assert;
import org.junit.Test;

public class HexUtilTest {

    @Test
    public void toHex() {
        byte[] bytes = {(byte) 0, (byte) 1, (byte) 2, (byte) 3};
        System.out.println(HexUtil.toHex(bytes));
    }

    @Test
    public void toBytes() throws Exception {
        byte[] bytes = {(byte) 0, (byte) 1, (byte) 2, (byte) 3};
        String s = HexUtil.toHex(bytes);
        byte[] result = HexUtil.toBytes(s);

        Assert.assertArrayEquals(bytes, result);
    }

}
