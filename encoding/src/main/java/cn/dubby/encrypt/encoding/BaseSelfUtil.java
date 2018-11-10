/**
 * @author daoxuan
 * @date 2018/11/9 17:31
 */
package cn.dubby.encrypt.encoding;

public class BaseSelfUtil {

    private static final char[] baseSelf = {
            'A', 'B', 'C', 'D', 'E',
            'K', 'L', 'M', 'N', 'O',
            'o', 'p', 'q', 'r', 's',
            'y', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7'
    };

    public static byte[] encode(byte[] src) {
        if (src == null || src.length == 0) {
            return new byte[]{};
        }

        int resultLength = src.length * 2;
        byte[] result = new byte[resultLength];
        for (int i = 0; i < src.length; ++i) {
            int a = src[i] >> 4;
            int b = src[i] & 0xf;
            result[i * 2] = (byte) baseSelf[a];
            result[i * 2 + 1] = (byte) baseSelf[b];
        }

        return result;
    }

    public static byte[] decode(byte[] src) {
        if (src == null || src.length == 0) {
            return new byte[]{};
        }

        int resultLength = src.length / 2;
        byte[] result = new byte[resultLength];
        for (int i = 0; i < resultLength; ++i) {
            byte b = (byte) (src[i * 2] << 4);
            b = (byte) (b & src[i * 2 + 1]);
            result[i] = b;
        }
        return result;
    }

}
