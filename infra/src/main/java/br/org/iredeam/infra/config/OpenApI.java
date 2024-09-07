package br.org.iredeam.infra.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApI {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    String authServerUrl;


    private static final String OAUTH_SCHEME_NAME = "db_irede_oauth";
    private SecurityScheme createOAuthScheme() {
        OAuthFlows flows = createOAuthFlows();
        return new SecurityScheme().type(SecurityScheme.Type.OAUTH2)
                .flows(flows);
    }

    private OAuthFlows createOAuthFlows() {
        OAuthFlow flow = createAuthorizationCodeFlow();
        return new OAuthFlows().password(flow);
    }

    private OAuthFlow createAuthorizationCodeFlow() {
        return new OAuthFlow()
                .tokenUrl(authServerUrl.replace("keycloak:8080","localhost:8081") + "/protocol/openid-connect/token");
    }


    @Bean
    OpenAPI springApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(OAUTH_SCHEME_NAME, createOAuthScheme()))
                .addSecurityItem(new SecurityRequirement().addList(OAUTH_SCHEME_NAME))
                .info(new Info()
                        .title("DB_IRede API")
                        .description("Api for product management")
                        .version("v0.0.1")
                        .license(new License().name("Copyleft")));
    }


}
