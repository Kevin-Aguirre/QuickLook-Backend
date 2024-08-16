package com.example.QuickLook.PhraseSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhraseSetService {
    private final PhraseSetRepository phraseSetRepository;

    @Autowired
    public PhraseSetService(PhraseSetRepository phraseSetRepository) {
        this.phraseSetRepository = phraseSetRepository;
    }

    public List<PhraseSet> getSets() {
        return phraseSetRepository.findAll();
    }

    public void addNewSet(PhraseSet phraseSet) {
        phraseSetRepository.save(phraseSet);
    }

    public void deleteSet(Long phraseSetId) {
        phraseSetRepository.deleteById(phraseSetId);
    }

    public PhraseSet getSetById(Long id) {
        Optional<PhraseSet> optionalPhraseSet = phraseSetRepository.findById(id);
        if (optionalPhraseSet.isPresent()) {
            System.out.println("set found");
            return optionalPhraseSet.get();
        }
        System.out.println("set not found");
        return null;
    }
}
