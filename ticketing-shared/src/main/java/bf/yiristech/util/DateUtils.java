package bf.yiristech.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS'Z'";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);
    public static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern(ISO_DATETIME_FORMAT);

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Get current UTC time
     */
    public static LocalDateTime nowUtc() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

    /**
     * Get current time in specified timezone
     */
    public static LocalDateTime nowInZone(ZoneId zoneId) {
        return LocalDateTime.now(zoneId);
    }

    /**
     * Convert LocalDateTime to UTC
     */
    public static LocalDateTime toUtc(LocalDateTime dateTime, ZoneId fromZone) {
        if (dateTime == null) return null;
        return dateTime.atZone(fromZone)
                .withZoneSameInstant(ZoneOffset.UTC)
                .toLocalDateTime();
    }

    /**
     * Convert UTC LocalDateTime to specified timezone
     */
    public static LocalDateTime fromUtc(LocalDateTime utcDateTime, ZoneId toZone) {
        if (utcDateTime == null) return null;
        return utcDateTime.atZone(ZoneOffset.UTC)
                .withZoneSameInstant(toZone)
                .toLocalDateTime();
    }

    /**
     * Format LocalDateTime to string
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Format LocalDateTime to default string format
     */
    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DATETIME_FORMATTER);
    }

    public static String formatLocalDate(LocalDateTime dateTime) {
        return dateTime.format(DATE_FORMATTER);
    }

    public static String formatISO(LocalDateTime dateTime) {
        return dateTime.format(ISO_FORMATTER);
    }

    /**
     * Parse string to LocalDateTime
     */
    public static LocalDateTime parse(String dateTimeString, String pattern) {
        if (dateTimeString == null || dateTimeString.trim().isEmpty()) return null;
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parse string to LocalDateTime using default format
     */
    public static LocalDateTime parse(String dateTimeString) {
        return parse(dateTimeString, DEFAULT_DATETIME_FORMAT);
    }


    public static boolean isExpired(LocalDateTime expirationTime) {
        return LocalDateTime.now().isAfter(expirationTime);
    }

    public static LocalDateTime addMinutes(LocalDateTime dateTime, long minutes) {
        if (dateTime == null) return null;
        return dateTime.plusMinutes(minutes);
    }

    public static LocalDateTime addHours(LocalDateTime dateTime, long hours) {
        if (dateTime == null) return null;
        return dateTime.plusHours(hours);
    }

    public static LocalDateTime addDays(LocalDateTime dateTime, long days) {
        if (dateTime == null) return null;
        return dateTime.plusDays(days);
    }

    private DateUtils() {}
}
