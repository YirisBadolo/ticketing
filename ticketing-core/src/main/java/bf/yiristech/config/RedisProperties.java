package bf.yiristech.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisProperties {

    private String host = "localhost";
    private int port = 6379;
    private String password = "redp@ssAdmin++";
    private int timeout = 2000;
    private PoolProperties jedis = new PoolProperties();

    @Getter
    @Setter
    public static class PoolProperties {
        private int maxActive = 20;
        private int maxIdle = 10;
        private int minIdle = 2;
        private long maxWait = -1;
    }
}
