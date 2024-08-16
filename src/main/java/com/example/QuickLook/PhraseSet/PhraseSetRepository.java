package com.example.QuickLook.PhraseSet;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseSetRepository extends JpaRepository<PhraseSet, Long> {

}
