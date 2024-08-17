package com.example.QuickLook.PhraseSet;

import com.example.QuickLook.PhraseSetDTO;
import com.example.QuickLook.user.User;
import com.example.QuickLook.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/set")
public class PhraseSetController {
    private final PhraseSetService phraseSetService;
    private final UserService userService;

    @Autowired
    public PhraseSetController(PhraseSetService phraseSetService, UserService userService) {
        this.phraseSetService = phraseSetService;
        this.userService = userService;
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
    public void addPhraseSet(@RequestBody PhraseSetDTO phraseSetDTO) {
        PhraseSet phraseSet = new PhraseSet();
        phraseSet.setPhraseSetName(
                phraseSetDTO.getPhraseSetName() != null ? phraseSetDTO.getPhraseSetName() : "Untitled Set"
        );
        User user = userService.getUserById(phraseSetDTO.getUserId());
        phraseSet.setUser(user);
        phraseSet.setDateAdded(new Date());
        
        phraseSetService.addNewSet(phraseSet);
    }

    @DeleteMapping(path = "{setId}")
    public void deletePhraseSet(@PathVariable("setId") Long setId) {
        phraseSetService.deleteSet(setId);
    }

}
