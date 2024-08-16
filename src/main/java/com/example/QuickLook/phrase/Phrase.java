package com.example.QuickLook.phrase;

import com.example.QuickLook.PhraseSet.PhraseSet;
import com.example.QuickLook.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "phrases") // table can take an aegumetn for what the name should be
public class Phrase {

    @Id
    @SequenceGenerator(name = "phrase_sequence", sequenceName = "phrase_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phrase_sequence")
    private Long id;

    private String phrase;
    private String summary;


    private Date dateAdded;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore // Prevent serialization of the user field to avoid cyclic references
    private User user;

    @ManyToOne
    @JoinColumn(name = "phrase_set_id", nullable = false)
    @JsonIgnore
    private PhraseSet phraseSet;

    public Phrase() {}
    public Phrase(String phrase, String summary, Date dateAdded, User user, PhraseSet phraseSet) {
        this.phrase = phrase;
        this.summary = summary;
        this.dateAdded = dateAdded;
        this.user = user;
        this.phraseSet = phraseSet;
    }

    public Date getDateAdded() {return dateAdded;}
    public void setDateAdded(Date dateAdded) {this.dateAdded = dateAdded;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getSummary() {return summary;}
    public void setSummary(String summary) {this.summary = summary;}

    public String getPhrase() {return phrase;}
    public void setPhrase(String phrase) {this.phrase = phrase;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", phrase='" + phrase + '\'' +
                ", summary='" + summary + '\'' +
                ", dateAdded=" + dateAdded +
                ", phraseSet=" + phraseSet +
                ", user=" + user +
                '}';
    }
}
