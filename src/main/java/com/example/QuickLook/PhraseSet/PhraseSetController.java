package com.example.QuickLook.PhraseSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/set")
public class PhraseSetController {
    private final PhraseSetService phraseSetService;

    @Autowired
    public PhraseSetController(PhraseSetService phraseSetService) {
        this.phraseSetService = phraseSetService;
    }

    @GetMapping
    public List<PhraseSet> getPhraseSets() {
        return phraseSetService.getSets();
    }

    @GetMapping("{id}")
    public PhraseSet getPhraseSet(@PathVariable("id") Long id) {
        return phraseSetService.getSetById(id);
    }

    @PostMapping
    public void addPhraseSet(@RequestBody PhraseSet phraseSet) {
        phraseSetService.addNewSet(phraseSet);
    }

    @DeleteMapping(path = "{setId}")
    public void deletePhraseSet(@PathVariable("setId") Long setId) {
        phraseSetService.deleteSet(setId);
    }

}
