package br.org.iredeam.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApI {
    @Bean
    OpenAPI springApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("DB_IRede API")
                        .description("Api for product management")
                        .version("v0.0.1")
                        .license(new License().name("Copyleft")));
    }


}
