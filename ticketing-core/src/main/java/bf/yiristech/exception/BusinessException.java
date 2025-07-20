package bf.yiristech.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final HttpStatus status;
    private final String errorCode;

    public BusinessException(String message) {
        this(HttpStatus.BAD_REQUEST, "BUSINESS_ERROR", message);
    }

    public BusinessException(String errorCode, String message) {
        this(HttpStatus.BAD_REQUEST, errorCode, message);
    }

    public BusinessException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BusinessException(HttpStatus status, String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.errorCode = errorCode;
    }

    // Specific business exceptions
    public static class EntityNotFoundException extends BusinessException {
        public EntityNotFoundException(String entityType, String id) {
            super(HttpStatus.NOT_FOUND, "ENTITY_NOT_FOUND",
                    String.format("%s with id '%s' not found", entityType, id));
        }
    }

    public static class EntityAlreadyExistsException extends BusinessException {
        public EntityAlreadyExistsException(String entityType, String field, String value) {
            super(HttpStatus.CONFLICT, "ENTITY_ALREADY_EXISTS",
                    String.format("%s with %s '%s' already exists", entityType, field, value));
        }
    }

    public static class ValidationException extends BusinessException {
        public ValidationException(String message) {
            super(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", message);
        }
    }

    public static class UnauthorizedException extends BusinessException {
        public UnauthorizedException(String message) {
            super(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", message);
        }
    }

    public static class ForbiddenException extends BusinessException {
        public ForbiddenException(String message) {
            super(HttpStatus.FORBIDDEN, "FORBIDDEN", message);
        }
    }

    public static class InvalidStateException extends BusinessException {
        public InvalidStateException(String message) {
            super(HttpStatus.CONFLICT, "INVALID_STATE", message);
        }
    }

    public static class RateLimitExceededException extends BusinessException {
        public RateLimitExceededException(String message) {
            super(HttpStatus.TOO_MANY_REQUESTS, "RATE_LIMIT_EXCEEDED", message);
        }
    }

}
