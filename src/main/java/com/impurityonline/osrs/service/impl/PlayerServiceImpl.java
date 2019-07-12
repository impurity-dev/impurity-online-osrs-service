package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.domain.Player;
import com.impurityonline.osrs.exception.OsrsPlayerNotFoundException;
import com.impurityonline.osrs.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.impurityonline.osrs.builder.OsrsPlayerBuilder.buildPlayer;

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
        ResponseEntity<String> responseEntity = osrsClient.getPlayer(playerName);

        String osrsApiResponse = Optional
                .ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new OsrsPlayerNotFoundException("No player body found"));


        return buildPlayer(playerName, "TODO", osrsApiResponse);
    }
}
