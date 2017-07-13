package util;

/**
 * Created by 向光性 on 2017/7/10.
 */

public class Regex {
    public static boolean isProperPassword(String password) {
        if (password.matches("^[A-Za-z0-9_]+$")) {
            return true;
        }
        return false;
    }
}
