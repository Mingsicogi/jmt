package my.mins.jmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySource(value = {"classpath:common.properties"
})
@EnableTransactionManagement
@EnableScheduling
public class JmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmtApplication.class, args);

    }

}
