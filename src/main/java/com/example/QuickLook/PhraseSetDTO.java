package com.example.QuickLook;

public class PhraseSetDTO {
    private String phraseSetName;
    private Long userId;

    public PhraseSetDTO(Long userId, String phraseSetName) {
        this.userId = userId;
        this.phraseSetName = phraseSetName;
    }

    public String getPhraseSetName() {
        return phraseSetName;
    }
    public void setPhraseSetName(String phraseSetName) {
        this.phraseSetName = phraseSetName;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
