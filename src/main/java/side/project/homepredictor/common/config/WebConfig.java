package side.project.homepredictor.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String[] ALLOW_ORIGINS = {
        "http://localhost:3000",
        "http://localhost:3001",
    };

    private static final String[] ALLOW_METHODS = {
        "GET", "POST", "PATCH", "DELETE", "HEAD", "OPTIONS", "PUT"
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(ALLOW_ORIGINS)
            .allowedMethods(ALLOW_METHODS)
            .allowCredentials(true)
            .maxAge(3000);
    }
}