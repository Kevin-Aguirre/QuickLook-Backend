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

//            final Date date = new Date();
//            User user = new User(
//                    "naruto.uzumaki@gmail.com",
//                    "foo",
//                    null
//            );
//
//            PhraseSet phraseSet1 = new PhraseSet(
//                    "homework",
//                    date,
//                    user,
//                    new ArrayList<>()
//            );
//
//            List<Phrase> phrases1 = List.of(
//                    new Phrase(
//                            "phrase1",
//                            "Lorem ipsum odor amet, consectetuer adipiscing elit. Etiam lacus interdum ex; ornare praesent ut? Interdum dapibus tristique mauris donec; enim quisque himenaeos nec. Ad curae nostra elementum augue augue nec. Viverra dapibus laoreet elementum leo efficitur. Cursus nisi orci ridiculus, accumsan felis litora donec nulla eu. Non volutpat blandit sem nascetur lacus facilisis aliquam est fringilla. Velit pulvinar aptent proin dui dolor gravida morbi curabitur.",
//                            date,
//                            user,
//                            phraseSet1
//                    ),
//                    new Phrase(
//                            "phrase 2",
//                            "Nibh imperdiet amet et euismod volutpat maximus aenean euismod. Condimentum facilisis neque sapien luctus per fringilla vel. Torquent nascetur nam netus aliquet mollis tristique nisl. Facilisis metus non nec fusce dui erat. Ornare himenaeos pulvinar nisi pretium rhoncus pulvinar vitae parturient. Class inceptos sollicitudin pharetra nullam suspendisse mauris fermentum maecenas phasellus. Donec integer pellentesque amet condimentum fames class dignissim. Quis lectus vulputate cursus mollis quisque. Laoreet ad imperdiet varius dictum suspendisse penatibus torquent.",
//                            date,
//                            user,
//                            phraseSet1
//                    )
//            );
//
//            phraseSet1.setPhrases(phrases1);
//
//            PhraseSet phraseSet2 =
//                new PhraseSet(
//                    "classwork",
//                    date,
//                    user,
//                    new ArrayList<>()
//            );
//
//            PhraseSet phraseSet3 =
//                new PhraseSet(
//                        "empty",
//                        date,
//                        user,
//                        new ArrayList<>()
//                );
//
//            List<Phrase> phrases2 = List.of(
//                    new Phrase(
//                            "phrase 1",
//                            "Lorem ipsum odor amet, consectetuer adipiscing elit. Quis enim convallis facilisi turpis velit montes risus. Feugiat consequat massa pretium ipsum ut ultrices turpis. Tellus quam curae pharetra justo ligula tortor. Ut elit faucibus ligula, maximus dignissim dolor. Platea id pellentesque vestibulum proin torquent primis. Aliquet erat parturient litora nec egestas eu habitant. Malesuada aptent per semper cubilia turpis faucibus litora.",
//                            date,
//                            user,
//                            phraseSet2
//                    ),
//                    new Phrase(
//                            "phrase 2",
//                            "Leo eleifend nulla ullamcorper torquent consectetur fames. Convallis molestie arcu varius semper fames conubia rutrum. Proin tortor suscipit blandit placerat praesent taciti conubia augue. Nam elementum molestie gravida ultrices ante leo placerat nascetur. Id posuere neque torquent; aenean nunc consectetur. Bibendum lorem lobortis condimentum aptent mattis finibus morbi dictumst. Vivamus netus facilisi montes sodales facilisi ut nisl. Justo ac vulputate vitae platea potenti. Magnis neque congue elementum mauris; placerat sit ex felis.",
//                            date,
//                            user,
//                            phraseSet2
//                    ),
//                    new Phrase(
//                            "phrase 3",
//                            "Amet ultricies quis aptent quis imperdiet penatibus eu. Mi tempor efficitur eget at, semper torquent natoque aenean libero. Iaculis malesuada semper sociosqu metus amet? Habitant torquent condimentum odio, in tortor mi. Finibus taciti sollicitudin accumsan egestas in ex massa! Tellus vestibulum tortor vitae, posuere diam montes egestas. Quam ultricies etiam purus quam suspendisse dictumst quisque.",
//                            date,
//                            user,
//                            phraseSet2
//                    )
//            );
//
//            phraseSet2.setPhrases(phrases2);
//
//            List<PhraseSet> sets = List.of(
//                    new PhraseSet(
//                            "homework",
//                            date,
//                            user,
//                            List.of(
//                                    new Phrase(
//                                            "phrase1set1",
//                                            "summary1set1",
//                                            date,
//                                            user,
//                                            null
//                                    ),
//                                    new Phrase(
//                                            "phrase2set1",
//                                            "summary2set1",
//                                            date,
//                                            user,
//                                            null
//                                    )
//                            )
//                    ),
//                    new PhraseSet(
//                            "classwork",
//                            date,
//                            user,
//                            List.of(
//                                new Phrase(
//                                        "phrase1set2",
//                                        "summary1set2",
//                                        date,
//                                        user,
//                                        null
//                                ),
//                                new Phrase(
//                                        "phrase2set2",
//                                        "summary2set2",
//                                        date,
//                                        user,
//                                        null
//                                ),
//                                new Phrase(
//                                        "phrase3set2",
//                                        "summary3set2",
//                                        date,
//                                        user,
//                                        null
//                                )
//                            )
//                    )
//            );
//
//            user.setPhraseSets(List.of(phraseSet1, phraseSet2, phraseSet3));
//            repository.saveAll(List.of(user));
        };
    }
}
