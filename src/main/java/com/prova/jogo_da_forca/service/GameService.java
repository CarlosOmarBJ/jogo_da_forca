package com.prova.jogo_da_forca.service;

import com.prova.jogo_da_forca.model.Word;
import com.prova.jogo_da_forca.repository.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final WordRepository wordRepository;

    public GameService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word getRandomWord() {
        return wordRepository.findRandomWord()
                .orElseThrow(() -> new RuntimeException("No words available"));
    }
}
