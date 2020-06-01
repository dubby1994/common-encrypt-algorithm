package cn.dubby.encrypt.encoding.test;

/**
 * @author dubby
 * @date 2020/3/26 20:16
 */
public class HexTest {

    public static void main(String[] args) {
        int v = -1;


        System.out.println((0xF0 & v) >>> 4);
        System.out.println(0x0F & v);
    }

}
