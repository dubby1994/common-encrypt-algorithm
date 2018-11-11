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
        StringBuilder sb = new StringBuilder(src.length * 2);
        for (byte aSrc : src) {
            sb.append(digits[(aSrc & 0xF0) >>> 4]);
            sb.append(digits[(aSrc & 0x0F)]);
        }

        return sb.toString();
    }

}
