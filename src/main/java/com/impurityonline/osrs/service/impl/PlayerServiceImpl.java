package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.domain.player.Player;
import com.impurityonline.osrs.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.impurityonline.osrs.builder.PlayerBuilder.buildPlayer;

/**
 * @author impurity
 */
@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private OsrsClient osrsClient;

    @Override
    public Player getPlayer(String playerName) {
        String osrsApiResponse = osrsClient.getPlayer(playerName);
        return buildPlayer(playerName, "TODO", osrsApiResponse);
    }
}
