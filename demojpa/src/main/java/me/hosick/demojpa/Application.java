package me.hosick.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware")
@EnableJpaRepositories(/*repositoryImplementationPostfix = "Default", */repositoryBaseClass = SimpleMyRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
