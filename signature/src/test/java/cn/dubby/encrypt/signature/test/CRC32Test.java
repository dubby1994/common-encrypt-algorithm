package cn.dubby.encrypt.signature.test;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.zip.CRC32;

public class CRC32Test {

    private static final String data = "Hello, world.";

    @Test
    public void crc32() {
        CRC32 crc32 = new CRC32();
        crc32.update(data.getBytes(Charset.forName("UTF-8")));
        long c1 = crc32.getValue();

        crc32.reset();

        crc32.update(data.getBytes(Charset.forName("UTF-8")));
        long c2 = crc32.getValue();

        System.out.println(c1);
        System.out.println(c2);

        Assert.assertEquals(c1, c2);
    }

}
