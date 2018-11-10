/**
 * @author daoxuan
 * @date 2018/11/9 16:17
 */
package cn.dubby.encrypt.encoding;

import java.util.Base64;

public class Base64Util {

    public static byte[] encode(byte[] src) {
        return Base64.getEncoder().encode(src);
    }

    public static byte[] decode(byte[] src) {
        return Base64.getDecoder().decode(src);
    }

    public static byte[] encodeURLSafe(byte[] src) {
        return Base64.getUrlEncoder().encode(src);
    }

    public static byte[] decodeURLSafe(byte[] src) {
        return Base64.getUrlDecoder().decode(src);
    }

}
