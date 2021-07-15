package solita.ennakko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnnakkoApplication {
    private static final Logger log = LoggerFactory.getLogger(EnnakkoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EnnakkoApplication.class, args);
    }

}
