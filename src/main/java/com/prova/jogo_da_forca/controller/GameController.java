package com.prova.jogo_da_forca.controller;

import com.prova.jogo_da_forca.model.User;
import com.prova.jogo_da_forca.model.Word;
import com.prova.jogo_da_forca.service.GameService;
import com.prova.jogo_da_forca.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {
    private final GameService gameService;
    private final UserService userService;

    public GameController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/start")
    public String startGame(@RequestParam String nickname, Model model) {
        User user = userService.findOrCreateUser(nickname);
        Word word = gameService.getRandomWord();
        model.addAttribute("users", user);
        model.addAttribute("word", word);
        return "game";
    }

    @PostMapping("/submit")
    public String submitScore(@RequestParam String nickname, @RequestParam int score) {
        User user = userService.findOrCreateUser(nickname);
        userService.updateBestScore(user, score);
        return "redirect:/";
    }
}
