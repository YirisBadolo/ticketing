package bf.yiristech.constant;

public class ValidationConstants {

    // Regex patterns
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String PHONE_PATTERN = "^\\+[1-9]\\d{1,14}$";
    public static final String NAME_PATTERN = "^[a-zA-ZÀ-ÿ\\s'-]{2,50}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    public static final String URL_PATTERN = "^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    // Error messages
    public static final String INVALID_EMAIL_MESSAGE = "Email format is invalid";
    public static final String INVALID_PHONE_MESSAGE = "Phone number format is invalid";
    public static final String INVALID_NAME_MESSAGE = "Name must contain only letters, spaces, hyphens and apostrophes";
    public static final String INVALID_PASSWORD_MESSAGE = "Password must contain at least 8 characters with uppercase, lowercase, digit and special character";

    // Field lengths
    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_EMAIL_LENGTH = 100;
    public static final int MAX_PHONE_LENGTH = 20;
    public static final int MAX_DESCRIPTION_LENGTH = 500;

    private ValidationConstants() {}
}
