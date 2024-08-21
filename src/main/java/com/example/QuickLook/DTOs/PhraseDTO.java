package com.example.QuickLook.DTOs;

import jakarta.persistence.Column;

import java.util.Date;

public class PhraseDTO {
    private String phrase;
    private String summary;
    private Date dateAdded;
    private Long userId;
    private Long setId;

    public PhraseDTO(String phrase, Long setId, Date dateAdded, String summary, Long userId) {
        this.phrase = phrase;
        this.setId = setId;
        this.dateAdded = dateAdded;
        this.summary = summary;
        this.userId = userId;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSetId() {
        return setId;
    }

    public void setSetId(Long setId) {
        this.setId = setId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
