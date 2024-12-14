package com.prova.jogo_da_forca.repository;

import com.prova.jogo_da_forca.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT * FROM Word ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Optional<Word> findRandomWord();
}
