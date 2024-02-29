package crud.backend.core.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permitir todos os origins
        config.addAllowedMethod("*"); // Permitir todos os métodos (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permitir todos os headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

