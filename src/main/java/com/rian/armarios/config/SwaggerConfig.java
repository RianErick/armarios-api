package com.rian.armarios.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Api de Armários")
                        .contact(new Contact().name("Rian Erick").url("https://linkedin.com/in/rianerick"))
                        .description("Api de Gerenciamento de armarios escolares - Projeto colaborativo")
                        .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Projeto no GitHub")
                        .url("https://github.com/RianErick/armarios-api"));
    }
}
