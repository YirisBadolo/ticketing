package bf.yiristech.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisProperties {

    private String host = "localhost";
    private int port = 6379;
    private String password = "redp@ssAdmin++";
    private int timeout = 2000;
    private LettuceProperties lettuce = new LettuceProperties();

    @Getter
    @Setter
    public static class LettuceProperties {
        private PoolProperties pool = new PoolProperties();
    }

    @Getter
    @Setter
    public static class PoolProperties {
        private int maxActive = 20;
        private int maxIdle = 10;
        private int minIdle = 2;
        private Duration maxWait = Duration.ofMillis(-1);  // Handles `-1ms`
    }
}