package cn.stylefeng.guns;

import cn.hutool.log.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringBoot方式启动类
 *
 * @author da.feng
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "currentUserAuditor")
public class GunsApplication  extends SpringBootServletInitializer {

    private static final Log log = Log.get();

    public static void main(String[] args) {
        SpringApplication.run(GunsApplication.class, args);
        log.info(">>> " + GunsApplication.class.getSimpleName() + " is success!");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GunsApplication.class);
    }

}