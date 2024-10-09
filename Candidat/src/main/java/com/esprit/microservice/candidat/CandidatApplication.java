package com.esprit.microservice.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidatApplication {

    @Autowired
    private CandidatRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CandidatApplication.class, args);
    }

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            repository.save(new Candidat("mariem", "chebbi", "mariem.chebbi@esprit.tn"));
            repository.save(new Candidat("sarra", "ab", "sa@esprit.tn"));
            repository.save(new Candidat("mohamed", "ba", "mo@esprit.tn"));
            repository.save(new Candidat("maroua", "dh", "maroua@esprit.tn"));
// fetch
            repository.findAll().forEach(System.out::println);
        };

    }
}
