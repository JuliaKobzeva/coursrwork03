package sky.pro.coursework03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sky.pro.coursework03.service.UtilService;

import java.util.Random;

@Configuration
public class AppConfiguration {

    @Bean
    public Random random(){
        return new Random();
    }

    @Bean
    public UtilService utilService(){
        return new UtilService();
    }
}
