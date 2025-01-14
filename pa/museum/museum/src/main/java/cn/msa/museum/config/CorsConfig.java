package cn.msa.museum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import io.micrometer.common.lang.NonNull;

@Configuration
public class CorsConfig implements WebMvcConfigurationSupport {

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
               .allowedOrigins("*")
    }
}
