package com.example.QuickLook.user;

import com.example.QuickLook.PhraseSet.PhraseSet;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany( // this annotation can be read at `One {CLASS NAME} can map to many {GENERIC} instances`, in this case, one user can be mapped to many phrase instances
            mappedBy = "user",  // this means that the PhraseSet class will have an attribute called user to show who owns the relationship
            cascade = CascadeType.ALL, // controls how operations performed on User entity transfer to assocaited Phrases. CascadeType.ALL means ALL operations are transferred, when you save/delete a User, all assoicated phrases are saved/deleted
            orphanRemoval = true // means if a phrase is removed from List<Phrase> in this User entity, that Phrase entry will also be removed from trh database entry
    )
    private List<PhraseSet> phraseSets;


    public User() {}
    public User(String email, String passwordHash, List<PhraseSet> phraseSets) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.phraseSets = phraseSets;
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

    public List<PhraseSet> getPhraseSets() {
        return phraseSets;
    }
    public void setPhraseSets(List<PhraseSet> newPhraseSets) {this.phraseSets = newPhraseSets;}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", phraseSets=" + phraseSets +
                '}';
    }
}
