package bf.yiristech.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private Object metadata;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public static <T> MResponse<T> success(T data) {
        return MResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    public static <T> MResponse<T> success(T data, String message) {
        return MResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> MResponse<T> success(T data, Object metadata) {
        return MResponse.<T>builder()
                .success(true)
                .data(data)
                .metadata(metadata)
                .build();
    }

    public static <T> MResponse<T> error(String message) {
        return MResponse.<T>builder()
                .success(false)
                .message(message)
                .build();
    }
}
