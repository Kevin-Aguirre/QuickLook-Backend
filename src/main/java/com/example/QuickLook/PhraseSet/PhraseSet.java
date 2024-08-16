package com.example.QuickLook.PhraseSet;


import com.example.QuickLook.phrase.Phrase;
import com.example.QuickLook.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phrase_sets")
public class PhraseSet {
    @Id
    @SequenceGenerator(name = "phrase_set_sequence", sequenceName = "phrase_set_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phrase_set_sequence")
    private Long phraseSetId;

    private String phraseSetName;


    private Date dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "phraseSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phrase> phrases;

    public PhraseSet() {}
    public PhraseSet(String phraseSetName, Date dateAdded, User user, List<Phrase> phrases) {
        this.phraseSetName = phraseSetName;
        this.dateAdded = dateAdded;
        this.user = user;
        this.phrases = phrases;
    }

    public Long getPhraseSetId() {return phraseSetId;}
    public void setPhraseSetId(Long phraseSetId) {this.phraseSetId = phraseSetId;}

    public String getPhraseSetName() {return phraseSetName;}
    public void setPhraseSetName(String phraseSetName) {this.phraseSetName = phraseSetName;}

    public Date getDateAdded() {return dateAdded;}
    public void setDateAdded(Date dateAdded) {this.dateAdded = dateAdded;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public List<Phrase> getPhrases() {return phrases;}
    public void setPhrases(List<Phrase> phrases) {this.phrases = phrases;}

    @Override
    public String toString() {
        return "PhraseSet{" +
                "phraseSetId=" + phraseSetId +
                ", phraseSetName='" + phraseSetName + '\'' +
                ", dateAdded=" + dateAdded +
                ", user=" + user +
                ", phrases=" + phrases +
                '}';
    }
}
