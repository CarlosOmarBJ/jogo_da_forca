package com.prova.jogo_da_forca.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nickname;

    private Integer bestScore;

    private LocalDateTime bestScoreDate;

    public User() {}

    public User(String nickname, Integer bestScore, LocalDateTime bestScoreDate) {
        this.nickname = nickname;
        this.bestScore = bestScore;
        this.bestScoreDate = bestScoreDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getBestScore() {
        return bestScore;
    }

    public void setBestScore(Integer bestScore) {
        this.bestScore = bestScore;
    }

    public LocalDateTime getBestScoreDate() {
        return bestScoreDate;
    }

    public void setBestScoreDate(LocalDateTime bestScoreDate) {
        this.bestScoreDate = bestScoreDate;
    }
}
