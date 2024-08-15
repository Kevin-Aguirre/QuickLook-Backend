package com.example.QuickLook.phrase;

import com.example.QuickLook.user.QuickLookUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "saved_phrases") // table can take an aegumetn for what the name should be
public class Phrase {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    Long id;
    String phrase;
    String summary;
    Date dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // Prevent serialization of the user field to avoid cyclic references
    private QuickLookUser user;

    public Phrase() {}
    public Phrase(String phrase, String summary, Date dateAdded, QuickLookUser user) {
        this.phrase = phrase;
        this.summary = summary;
        this.dateAdded = dateAdded;
        this.user = user;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public QuickLookUser getUser() {
        return user;
    }

    public void setUser(QuickLookUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", phrase='" + phrase + '\'' +
                ", summary='" + summary + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
