package br.org.iredeam.infra.config;


import br.org.iredeam.infra.jpa.entities.EntityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditingConfig {


    @Bean
    public EntityAuditorAware auditorAware() {
        return new EntityAuditorAware();
    }
}
