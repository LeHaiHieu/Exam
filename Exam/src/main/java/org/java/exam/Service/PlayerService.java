package org.java.exam.Service;

import org.java.exam.Entity.Player;
import org.java.exam.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void addPlayer(Player player) {
        playerRepository.save(player);
    }
}

