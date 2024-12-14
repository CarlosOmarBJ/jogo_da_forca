package com.prova.jogo_da_forca.service;

import com.prova.jogo_da_forca.model.User;
import com.prova.jogo_da_forca.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOrCreateUser(String nickname) {
        return userRepository.findByNickname(nickname)
                .orElseGet(() -> userRepository.save(new User(nickname, 0, null)));
    }

    public void updateBestScore(User user, int newScore) {
        if (newScore > user.getBestScore()) {
            user.setBestScore(newScore);
            user.setBestScoreDate(LocalDateTime.now());
            userRepository.save(user);
        }
    }

    public List<User> getTop10Scores() {
        return userRepository.findAll(org.springframework.data.domain.PageRequest.of(0, 10,
                org.springframework.data.domain.Sort.by("bestScore").descending())).getContent();
    }
}
