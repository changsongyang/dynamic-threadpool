package cn.hippo4j.common.toolkit;

/**
 * String util.
 *
 * @author chen.ma
 * @date 2021/12/22 20:58
 */
public class StringUtil {

    public static final String EMPTY = "";

    public static final char UNDERLINE = '_';

    /**
     * Is blank.
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            boolean charNotBlank = Character.isWhitespace(c) || Character.isSpaceChar(c) || c == '\ufeff' || c == '\u202a';
            if (charNotBlank == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * Is not blank.
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return isBlank(str) == false;
    }

    /**
     * To underline case.
     *
     * @param str
     * @return
     */
    public static String toUnderlineCase(CharSequence str) {
        return toSymbolCase(str, UNDERLINE);
    }

    /**
     * To symbol case.
     *
     * @param str
     * @param symbol
     * @return
     */
    public static String toSymbolCase(CharSequence str, char symbol) {
        if (str == null) {
            return null;
        }

        final int length = str.length();
        final StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            final Character preChar = (i > 0) ? str.charAt(i - 1) : null;
            if (Character.isUpperCase(c)) {
                final Character nextChar = (i < str.length() - 1) ? str.charAt(i + 1) : null;
                if (null != preChar && Character.isUpperCase(preChar)) {
                    sb.append(c);
                } else if (null != nextChar && Character.isUpperCase(nextChar)) {
                    if (null != preChar && symbol != preChar) {
                        sb.append(symbol);
                    }
                    sb.append(c);
                } else {
                    if (null != preChar && symbol != preChar) {
                        sb.append(symbol);
                    }
                    sb.append(Character.toLowerCase(c));
                }
            } else {
                if (sb.length() > 0 && Character.isUpperCase(sb.charAt(sb.length() - 1)) && symbol != c) {
                    sb.append(symbol);
                }
                sb.append(c);
            }
        }

        return sb.toString();
    }

}