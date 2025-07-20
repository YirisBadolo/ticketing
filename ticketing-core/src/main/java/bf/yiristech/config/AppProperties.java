package bf.yiristech.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Setter
@Getter
@Validated
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    @NotBlank
    private String name = "Ticketing Core Service";

    @NotBlank
    private String description = "Core service for ticketing system";

    @NotBlank
    private String version = "1.0.0";

    @NotBlank
    private String timezone = "UTC";

    @Valid
    @NotNull
    private Security security = new Security();

    @Valid
    @NotNull
    private Cache cache = new Cache();

    @Valid
    @NotNull
    private Async async = new Async();

    @Valid
    @NotNull
    private Business business = new Business();

    @Setter
    @Getter
    public static class Security {

        @Valid
        @NotNull
        private Jwt jwt = new Jwt();

        @Valid
        @NotNull
        private Cors cors = new Cors();

        @Setter
        @Getter
        public static class Jwt {
            @NotBlank
            private String secret = "defaultSecretKey";

            @Positive
            private long expiration = 86400000; // 24 hours

            @Positive
            private long refreshExpiration = 604800000; // 7 days
        }

        @Setter
        @Getter
        public static class Cors {
            private String allowedOrigins = "*";
            private String allowedMethods = "GET,POST,PUT,DELETE,OPTIONS";
            private String allowedHeaders = "*";

            @Positive
            private long maxAge = 3600;
        }
    }

    @Setter
    @Getter
    public static class Cache {

        @Valid
        @NotNull
        private Redis redis = new Redis();

        @Valid
        @NotNull
        private User user = new User();

        @Valid
        @NotNull
        private Session session = new Session();

        @Setter
        @Getter
        public static class Redis {
            @Positive
            private long ttl = 3600; // 1 hour

            @NotBlank
            private String prefix = "ticketing:";
        }

        @Setter
        @Getter
        public static class User {
            @Positive
            private long ttl = 1800; // 30 minutes
        }

        @Setter
        @Getter
        public static class Session {
            @Positive
            private long ttl = 7200; // 2 hours
        }
    }

    @Setter
    @Getter
    public static class Async {
        @Positive
        private int corePoolSize = 5;

        @Positive
        private int maxPoolSize = 20;

        @Positive
        private int queueCapacity = 100;

        @NotBlank
        private String threadNamePrefix = "Async-";
    }

    @Setter
    @Getter
    public static class Business {
        @Positive
        private int maxTicketsPerUser = 10;

        @Positive
        private int ticketExpiryHours = 24;

        @NotBlank
        private String maxFileSize = "10MB";

        @NotNull
        private List<String> allowedFileTypes = List.of("pdf", "doc", "docx", "txt", "jpg", "png");

        @Positive
        private int maxAttachmentsPerTicket = 5;

        @Positive
        private int maxCommentLength = 1000;

        @NotBlank
        private String defaultPriority = "MEDIUM";

        @NotBlank
        private String defaultCategory = "GENERAL";
    }
}
