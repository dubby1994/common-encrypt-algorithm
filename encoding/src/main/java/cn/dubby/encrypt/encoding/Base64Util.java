/**
 * @author daoxuan
 * @date 2018/11/9 16:17
 */
package cn.dubby.encrypt.encoding;

import java.util.Base64;

/**
 * 使用JDK1.8提供的Base64来编解码
 * @see java.util.Base64
 */
public class Base64Util {

    private static final Base64.Encoder EncoderWithoutPadding = Base64.getEncoder().withoutPadding();

    private static final Base64.Encoder URLSafeEncoderWithoutPadding = Base64.getUrlEncoder().withoutPadding();

    /**
     * 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
     * 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
     * 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
     * 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
     * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
     */
    public static byte[] encode(byte[] src) {
        return Base64.getEncoder().encode(src);
    }

    /**
     * 不会用=来填充
     */
    public static byte[] encodeWithoutPadding(byte[] src) {
        return EncoderWithoutPadding.encode(src);
    }

    public static byte[] decode(byte[] src) {
        return Base64.getDecoder().decode(src);
    }

    /**
     * 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
     * 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
     * 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
     * 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
     * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'
     */
    public static byte[] encodeURLSafe(byte[] src) {
        return Base64.getUrlEncoder().encode(src);
    }

    /**
     * 不会用=来填充
     */
    public static byte[] encodeURLSafeWithoutPadding(byte[] src) {
        return URLSafeEncoderWithoutPadding.encode(src);
    }

    public static byte[] decodeURLSafe(byte[] src) {
        return Base64.getUrlDecoder().decode(src);
    }

}
