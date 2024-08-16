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
//            Phrase p1 = new Phrase(
//                    "phrase1set2",
//                    "summary1set2",
//                    new Date(),
//                    null,
//                    null
//            );
//            Phrase p2 = new Phrase(
//                    "phrase2set2",
//                    "summary2set2",
//                    new Date(),
//                    null,
//                    null
//            );
//            Phrase p3 = new Phrase(
//                "phrase3set2",
//                "summary3set2",
//                new Date(),
//                null,
//                null
//            );
//
//            phraseRepository.saveAll(List.of(p1, p2, p3));



        };
    }
}
