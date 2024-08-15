package com.example.QuickLook.phrase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository
        extends JpaRepository<Phrase, Long> {


}
