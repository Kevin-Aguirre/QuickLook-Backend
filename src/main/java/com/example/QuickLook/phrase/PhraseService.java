package com.example.QuickLook.phrase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    @Autowired
    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }


    public List<Phrase> getPhrases() {
        return phraseRepository.findAll();
    }

    public void addNewPhrase(Phrase phrase) {
        phraseRepository.save(phrase);
    }

    public void deletePhrase(Long phraseId) {
        boolean exists = phraseRepository.existsById(phraseId);

        if (!exists) {
            throw new IllegalStateException("could not find this phrase");
        }

        phraseRepository.deleteById(phraseId);
    }

}
