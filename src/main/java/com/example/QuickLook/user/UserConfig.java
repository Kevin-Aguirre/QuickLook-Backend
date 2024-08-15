package com.example.QuickLook.user;

import com.example.QuickLook.phrase.Phrase;
import com.example.QuickLook.phrase.PhraseRepository;
import com.example.QuickLook.phrase.PhraseService;
import com.example.QuickLook.user.QuickLookUser;
import com.example.QuickLook.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, PhraseRepository phraseRepository) {
        return args -> {
            QuickLookUser user1 = new QuickLookUser(
                    "joe@shmoe@gmail.com",
                    "[]89",
                    List.of()
            );

            QuickLookUser user2 = new QuickLookUser(
                    "joe@shmoe2@gmail.com",
                    "[]89",
                    List.of()
            );

            repository.saveAll(List.of(user1, user2));

            Phrase phrase1 = new Phrase(
                    "apples",
                    "apples are red",
                    new Date(),
                    user1
            );

            Phrase phrase2 = new Phrase(
                    "bananas",
                    "bananas are yellow",
                    new Date(),
                    user1
            );

            Phrase phrase3 = new Phrase(
                    "grapes",
                    "grapes are green or purple",
                    new Date(),
                    user2
            );

            // Save phrases
            // Assuming you have a PhraseRepository
//            PhraseRepository phraseRepository = //... get the repository
                    phraseRepository.saveAll(List.of(phrase1, phrase2, phrase3));
        };
    }
}
