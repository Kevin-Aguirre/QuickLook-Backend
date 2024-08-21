package com.example.QuickLook.phrase;

import com.example.QuickLook.DTOs.PhraseDTO;
import com.example.QuickLook.PhraseSet.PhraseSetService;
import com.example.QuickLook.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/phrase")
public class PhraseController  {

    private final PhraseService phraseService;
    private final OpenAIService openAIService;
    private final UserService userService;
    private final PhraseSetService phraseSetService;

    @Autowired // basically acts as a promise to ensure that this object will be instantiated once we need it
    public PhraseController(PhraseService phraseService, OpenAIService openAIService, UserService userService, PhraseSetService phraseSetService) {
        this.phraseService = phraseService;
        this.openAIService = openAIService;
        this.userService = userService;
        this.phraseSetService = phraseSetService;
    }

    @GetMapping
    public List<Phrase> getPhrases() {
        return phraseService.getPhrases();
    }

    @PostMapping
    public void addPhrase(@RequestBody PhraseDTO phraseDTO) {
        try {
            Phrase phraseToSave = new Phrase();

            phraseToSave.setPhrase(phraseDTO.getPhrase());
            phraseToSave.setDateAdded(phraseDTO.getDateAdded());
            phraseToSave.setPhraseSet(phraseSetService.getSetById(phraseDTO.getSetId()));
            phraseToSave.setUser(userService.getUserById(phraseDTO.getUserId()));
            phraseToSave.setSummary(openAIService.generateSummary(phraseDTO.getPhrase()));

            phraseService.addNewPhrase(phraseToSave);
        } catch (Exception e) {
            System.out.println("failed to generate");
            e.printStackTrace();
        }

    }

    @DeleteMapping(path = "{phraseId}")
    public void deletePhrase(@PathVariable("phraseId") Long phraseId) {
        phraseService.deletePhrase(phraseId);
    }
}









/*
* 4207 6703 1096 9137
*
* */

