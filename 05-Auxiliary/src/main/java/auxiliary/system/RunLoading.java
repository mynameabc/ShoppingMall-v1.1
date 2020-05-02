package auxiliary.system;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author LinShaoJun
 * @Date 2020/1/20 0:46
 */
@Slf4j
@Component
public class RunLoading implements ApplicationRunner {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统配置加载完毕!");
    }
}
