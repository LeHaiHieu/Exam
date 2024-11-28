package org.java.exam.Controller;

import org.java.exam.Entity.Player;
import org.java.exam.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("players", playerService.getAllPlayers());
        return "index";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(@RequestParam String playerName, @RequestParam int playerAge,
                            @RequestParam String indexName, @RequestParam int value) {
        Player player = new Player();
        player.setPlayerName(playerName);
        player.setPlayerAge(playerAge);
        player.setIndexName(indexName);
        player.setValue(value);
        playerService.addPlayer(player);
        return "redirect:/";
    }
}

