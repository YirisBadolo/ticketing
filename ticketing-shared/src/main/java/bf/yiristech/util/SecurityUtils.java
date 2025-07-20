package bf.yiristech.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtils {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static String generateSalt() {
        byte[] salt = new byte[16];
        SECURE_RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generateSecureToken() {
        byte[] token = new byte[32];
        SECURE_RANDOM.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }

    /**
     * Generate random numeric code
     */
    public static String generateNumericCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(SECURE_RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * Sanitize string for XSS protection
     */
    public static String sanitizeString(String input) {
        if (input == null) return null;
        return input.replaceAll("[<>\"'&]", "");
    }

    /**
     * Mask sensitive data (keep first and last 2 characters)
     */
    public static String maskSensitiveData(String data) {
        if (data == null || data.length() <= 4) return "****";
        int length = data.length();
        return data.substring(0, 2) + "*".repeat(length - 4) + data.substring(length - 2);
    }

    public static boolean verifyPassword(String password, String hashedPassword, String salt) {
        String computedHash = hashPassword(password, salt);
        return MessageDigest.isEqual(
                computedHash.getBytes(StandardCharsets.UTF_8),
                hashedPassword.getBytes(StandardCharsets.UTF_8)
        );
    }

    private SecurityUtils() {}
}
