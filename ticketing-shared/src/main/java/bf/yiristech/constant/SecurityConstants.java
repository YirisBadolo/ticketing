package bf.yiristech.constant;

public class SecurityConstants {
    // JWT
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER_STRING = "Authorization";
    public static final long JWT_EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours
    public static final long JWT_REFRESH_EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000; // 7 days

    // MFA
    public static final int OTP_LENGTH = 6;
    public static final int OTP_EXPIRATION_MINUTES = 5;
    public static final int MAX_OTP_ATTEMPTS = 3;
    public static final int MFA_MAX_ATTEMPTS = 5;

    // Session
    public static final int SESSION_TIMEOUT_MINUTES = 30;
    public static final int MAX_SESSIONS_PER_USER = 5;

    // Password
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 128;

    // Rate Limiting
    public static final int LOGIN_RATE_LIMIT = 5; // per minute
    public static final int OTP_RATE_LIMIT = 10; // per day

    private SecurityConstants() {}
}
