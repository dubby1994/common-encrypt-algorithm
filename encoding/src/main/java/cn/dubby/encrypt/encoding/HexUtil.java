package cn.dubby.encrypt.encoding;

public class HexUtil {

    private final static char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static String toHex(byte[] src) {
        StringBuilder sb = new StringBuilder(src.length << 1);
        for (byte aSrc : src) {
            sb.append(digits[(aSrc & 0xF0) >>> 4]);
            sb.append(digits[(aSrc & 0x0F)]);
        }

        return sb.toString();
    }

    public static byte[] toBytes(String string) throws Exception {
        int len = string.length();
        final byte[] out = new byte[len >> 1];

        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(string.charAt(j), j) << 4;
            j++;
            f = f | toDigit(string.charAt(j), j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    private static int toDigit(final char ch, final int index) throws Exception {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new Exception("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

}
