package com.example.QuickLook.user;

import com.example.QuickLook.phrase.Phrase;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class QuickLookUser {
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
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany( // this annotation can be read at `One {CLASS NAME} can map to many {GENERIC} instances`, in this case, one user can be mapped to many phrase instances
            mappedBy = "user",  // this means that the Phrase class will have an attribute called user to show who owns the relationship
            cascade = CascadeType.ALL, // controls how operations performed on User entity transfer to assocaited Phrases. CascadeType.ALL means ALL operations are transferred, when you save/delete a User, all assoicated phrases are saved/deleted
            orphanRemoval = true // means if a phrase is removed from List<Phrase> in this User entity, that Phrase entry will also be removed from trh database entry
    )
    private List<Phrase> phrases = new ArrayList<>();


    public QuickLookUser() {}
    public QuickLookUser(Long userId, String email, String passwordHash, List<Phrase> phrases) {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.phrases = phrases;
    }
    public QuickLookUser(String email, String passwordHash, List<Phrase> phrases) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.phrases = phrases;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> newPhrases) {
        this.phrases = newPhrases;
        System.out.print("new phrases: ");
        System.out.println(newPhrases);
        System.out.print("saved phrases: ");
        System.out.println(this.phrases);

    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", phrases=" + phrases + '\'' +
                '}';
    }
}
