package com.impurityonline.osrs.service;

import com.impurityonline.osrs.domain.OsrsPlayer;

/**
 * @author impurity
 */
public interface PlayerService {

    /**
     * Grab the player from the OSRS api
     * @param playerName - the playerName to retrieve information of
     * @return - the osrs player statistics
     */
    OsrsPlayer getPlayer(String playerName);
}
