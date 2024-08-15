package com.example.QuickLook.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<QuickLookUser, Long> {

    @Query("SELECT s FROM QuickLookUser s WHERE s.email= ?1")
    Optional<QuickLookUser> findUserByEmail(String email);

}
