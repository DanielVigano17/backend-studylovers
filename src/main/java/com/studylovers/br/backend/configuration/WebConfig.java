package com.studylovers.br.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapeia a URL /imagens/** para a pasta uploads/
        Path caminhoUpload = Paths.get(System.getProperty("user.dir"), "uploads");
        String caminhoUploadAbsoluto = caminhoUpload.toUri().toString();

        registry.addResourceHandler("/imagens/**")
                .addResourceLocations(caminhoUploadAbsoluto);
    }
}

