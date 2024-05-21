package festekbolt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Példa bean konfigurációra
    @Bean
    public FestekService customFestekService(FestekRepository festekRepository) {
        return new FestekService(festekRepository);
    }
}
