package bf.yiristech.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class DatabaseProperties {

    private String host;
    private int port;
    private String username;
    private String password;
    private String database;
    private String authenticationDatabase;
    private Pool pool = new Pool();

    @Getter
    @Setter
    public static class Pool {
        private int maxSize = 100;
        private int minSize = 5;
        private long maxIdleTimeMs = 30000;
        private long maxLifeTimeMs = 60000;
    }

    public String getUri() {
        return String.format(
                "mongodb://%s:%s@%s:%d/%s?authSource=%s",
                username,
                password,
                host,
                port,
                database,
                authenticationDatabase != null ? authenticationDatabase : "admin"
        );
    }
}
