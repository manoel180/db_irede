package br.org.iredeam.infra.config;

import br.org.iredeam.infra.converter.JwtConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
class KeycloakSecurityConfig {


    private static final String JWT_ROLE_NAME = "groups";
    private static final String ROLE_PREFIX = "ROLE_";
    private static final String[] PUBLIC_MATCHERS = {"/swagger-ui.html",
            "/swagger-ui/**", "/swagger-resources/**", "/webjars/**",
            "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
            "/configuration/**", "/actuator/**", "/csrf", "/doc.html"};
    private final JwtConverter jwtConverter;

//    @Bean
//    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//    }

//    private JwtAuthenticationConverter jwtAuthenticationConverter() {
//        // create a custom JWT converter to map the roles from the token as granted authorities
//        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(JWT_ROLE_NAME); // default is: scope
//        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(ROLE_PREFIX); // default is: SCOPE_
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//        return jwtAuthenticationConverter;
//    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize.requestMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated());

        http.sessionManagement(sess -> sess.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        return http.build();
    }


}
