package bf.yiristech.exception;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {

    private final String errorCode;

    public TechnicalException(String message) {
        this("TECHNICAL_ERROR", message);
    }

    public TechnicalException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public TechnicalException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    // Specific technical exceptions
    public static class DatabaseException extends TechnicalException {
        public DatabaseException(String message) {
            super("DATABASE_ERROR", message);
        }

        public DatabaseException(String message, Throwable cause) {
            super("DATABASE_ERROR", message, cause);
        }
    }

    public static class CacheException extends TechnicalException {
        public CacheException(String message) {
            super("CACHE_ERROR", message);
        }

        public CacheException(String message, Throwable cause) {
            super("CACHE_ERROR", message, cause);
        }
    }

    public static class ExternalServiceException extends TechnicalException {
        public ExternalServiceException(String message) {
            super("EXTERNAL_SERVICE_ERROR", message);
        }

        public ExternalServiceException(String message, Throwable cause) {
            super("EXTERNAL_SERVICE_ERROR", message, cause);
        }
    }

    public static class ConfigurationException extends TechnicalException {
        public ConfigurationException(String message) {
            super("CONFIGURATION_ERROR", message);
        }

        public ConfigurationException(String message, Throwable cause) {
            super("CONFIGURATION_ERROR", message, cause);
        }
    }

    public static class SerializationException extends TechnicalException {
        public SerializationException(String message) {
            super("SERIALIZATION_ERROR", message);
        }

        public SerializationException(String message, Throwable cause) {
            super("SERIALIZATION_ERROR", message, cause);
        }
    }

}
