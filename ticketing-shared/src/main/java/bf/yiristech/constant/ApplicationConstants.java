package bf.yiristech.constant;

public class ApplicationConstants {

    public static final String DEFAULT_LANGUAGE = "fr";
    public static final String DEFAULT_CURRENCY = "XOF";
    public static final String DEFAULT_TIMEZONE = "Africa/Ouagadougou";
    public static final String DEFAULT_THEME = "light";

    // Pagination
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String DEFAULT_SORT_FIELD = "createdAt";
    public static final String DEFAULT_SORT_DIRECTION = "desc";

    // Cache
    public static final String USER_CACHE = "users";
    public static final String SESSION_CACHE = "sessions";
    public static final String OTP_CACHE = "otp";

    // Headers
    public static final String CORRELATION_ID_HEADER = "X-Correlation-ID";
    public static final String USER_ID_HEADER = "X-User-ID";
    public static final String TENANT_ID_HEADER = "X-Tenant-ID";

    private ApplicationConstants() {}
}
