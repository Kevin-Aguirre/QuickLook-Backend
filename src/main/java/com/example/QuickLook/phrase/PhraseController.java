package com.example.QuickLook.phrase;

import com.example.QuickLook.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/phrase")
public class PhraseController  {

    private final PhraseService phraseService;
    private final UserService userService;

    @Autowired // basically acts as a promise to ensure that this object will be instantiated once we need it
    public PhraseController(PhraseService phraseService, UserService userService) {
        this.phraseService = phraseService;
        this.userService = userService;
    }

    @GetMapping
    public List<Phrase> getPhrases() {
        return phraseService.getPhrases();
    }

    @PostMapping
    public void addPhrase(@RequestBody Phrase phrase) {
        phraseService.addNewPhrase(phrase);
    }

    @DeleteMapping(path = "{phraseId}")
    public void deletePhrase(@PathVariable("phraseId") Long phraseId) {
        phraseService.deletePhrase(phraseId);
    }
}
