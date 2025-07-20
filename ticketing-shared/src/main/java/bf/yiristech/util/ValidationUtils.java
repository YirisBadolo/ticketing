package bf.yiristech.util;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

import static bf.yiristech.constant.ValidationConstants.*;

public class ValidationUtils {

    private static final Pattern EMAIL_PATTERN_COMPILED = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern PHONE_PATTERN_COMPILED = Pattern.compile(PHONE_PATTERN);
    private static final Pattern NAME_PATTERN_COMPILED = Pattern.compile(NAME_PATTERN);
    private static final Pattern PASSWORD_PATTERN_COMPILED = Pattern.compile(PASSWORD_PATTERN);
    private static final Pattern URL_PATTERN_COMPILED = Pattern.compile(URL_PATTERN);

    public static boolean isValidEmail(String email) {
        return StringUtils.isNotEmpty(email) && EMAIL_PATTERN_COMPILED.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        return StringUtils.isNotEmpty(phone) && PHONE_PATTERN_COMPILED.matcher(phone).matches();
    }

    public static boolean isValidName(String name) {
        return StringUtils.isNotEmpty(name) && NAME_PATTERN_COMPILED.matcher(name).matches();
    }

    /**
     * Check if URL is valid
     */
    public static boolean isValidUrl(String url) {
        if (StringUtils.isEmpty(url)) return false;
        return URL_PATTERN_COMPILED.matcher(url).matches();
    }

    public static boolean isValidPassword(String password) {
        return StringUtils.isNotEmpty(password) && PASSWORD_PATTERN_COMPILED.matcher(password).matches();
    }

    public static boolean isValidLength(String str, int minLength, int maxLength) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        return length >= minLength && length <= maxLength;
    }

    /**
     * Check if collection is null or empty
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Check if collection is not null and not empty
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * Check if map is null or empty
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Check if map is not null and not empty
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    private ValidationUtils() {}

}
