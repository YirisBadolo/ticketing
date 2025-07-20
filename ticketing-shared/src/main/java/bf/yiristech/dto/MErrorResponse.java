package bf.yiristech.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MErrorResponse {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime timestamp;

    private int status;
    private String error;
    private String message;
    private String code;
    private String path;
    private String traceId;
    private Map<String, String> validationErrors;
    private Map<String, Object> details;

    public static MErrorResponse of(int status, String error, String message, String code) {
        return MErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(error)
                .message(message)
                .code(code)
                .build();
    }

    public static MErrorResponse of(int status, String error, String message, String code, String path) {
        return MErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .error(error)
                .message(message)
                .code(code)
                .path(path)
                .build();
    }

    public static MErrorResponse of(int status, String message) {
        return MErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .message(message)
                .build();
    }

    public static MErrorResponse of(int status, String code, String message) {
        return MErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status)
                .message(message)
                .code(code)
                .build();
    }

}
