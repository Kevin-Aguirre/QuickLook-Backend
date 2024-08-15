package com.example.QuickLook.phrase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class PhraseConfig {

    // the name of the CommandLineRunner instance must be unique,
    // I had to rename this from "commandLineRunner" to "commandLineRunnerPhrase"
    @Bean
    CommandLineRunner commandLineRunnerPhrase(PhraseRepository phraseRepository) {
        return args -> {

        };
    }
}
