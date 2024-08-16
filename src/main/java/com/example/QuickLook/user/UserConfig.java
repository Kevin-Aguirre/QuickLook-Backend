package com.example.QuickLook.user;

import com.example.QuickLook.PhraseSet.PhraseSet;
import com.example.QuickLook.phrase.Phrase;
import com.example.QuickLook.phrase.PhraseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, PhraseRepository phraseRepository) {
        return args -> {

            final Date date = new Date();
            User user = new User(
                    "naruto.uzumaki@gmail.com",
                    "foo",
                    null
            );

            PhraseSet phraseSet1 = new PhraseSet(
                    "homework",
                    date,
                    user,
                    new ArrayList<>()
            );

            List<Phrase> phrases1 = List.of(
                    new Phrase(
                            "phrase1set1",
                            "summary1set1",
                            date,
                            user,
                            phraseSet1
                    ),
                    new Phrase(
                            "phrase2set1",
                            "summary2set1",
                            date,
                            user,
                            phraseSet1
                    )
            );

            phraseSet1.setPhrases(phrases1);

            PhraseSet phraseSet2 =
                new PhraseSet(
                    "classwork",
                    date,
                    user,
                    new ArrayList<>()
            );

            List<Phrase> phrases2 = List.of(
                    new Phrase(
                            "phrase1set2",
                            "summary1set2",
                            date,
                            user,
                            phraseSet2
                    ),
                    new Phrase(
                            "phrase2set2",
                            "summary2set2",
                            date,
                            user,
                            phraseSet2
                    ),
                    new Phrase(
                            "phrase3set2",
                            "summary3set2",
                            date,
                            user,
                            phraseSet2
                    )
            );

            phraseSet2.setPhrases(phrases2);

            List<PhraseSet> sets = List.of(
                    new PhraseSet(
                            "homework",
                            date,
                            user,
                            List.of(
                                    new Phrase(
                                            "phrase1set1",
                                            "summary1set1",
                                            date,
                                            user,
                                            null
                                    ),
                                    new Phrase(
                                            "phrase2set1",
                                            "summary2set1",
                                            date,
                                            user,
                                            null
                                    )
                            )
                    ),
                    new PhraseSet(
                            "classwork",
                            date,
                            user,
                            List.of(
                                new Phrase(
                                        "phrase1set2",
                                        "summary1set2",
                                        date,
                                        user,
                                        null
                                ),
                                new Phrase(
                                        "phrase2set2",
                                        "summary2set2",
                                        date,
                                        user,
                                        null
                                ),
                                new Phrase(
                                        "phrase3set2",
                                        "summary3set2",
                                        date,
                                        user,
                                        null
                                )
                            )
                    )
            );

            user.setPhraseSets(List.of(phraseSet1, phraseSet2));
            repository.saveAll(List.of(user));
        };
    }
}
