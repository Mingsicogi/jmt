package my.mins.jmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {
        "classpath:common.properties"
})
public class JmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmtApplication.class, args);
    }

}
