package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.Player;
import com.impurityonline.osrs.service.PlayerService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.impurityonline.osrs.factory.MiniGameFactory.buildMiniGames;
import static com.impurityonline.osrs.factory.ScrollsFactory.buildScrolls;
import static com.impurityonline.osrs.factory.SkillsFactory.buildSkills;

/**
 * @author impurity
 */
@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private OsrsClient osrsClient;

    @Override
    public Player getPlayer(@NonNull String playerName) {
        if(StringUtils.isEmpty(playerName)) {
            throw new IllegalArgumentException("PlayerName cannot be empty");
        }
        ApiPlayerResponse apiPlayerResponse = osrsClient.getPlayer(playerName);
        Player player = new Player();
        player.setName(playerName);
        player.setType("TODO"); // TODO: Add type to player
        player.setMiniGames(buildMiniGames(apiPlayerResponse));
        player.setScrolls(buildScrolls(apiPlayerResponse));
        player.setSkills(buildSkills(apiPlayerResponse));
        return player;
    }
}
