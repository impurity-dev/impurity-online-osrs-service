package com.impurityonline.osrs.service;

import com.impurityonline.osrs.domain.OsrsItem;
import com.impurityonline.osrs.domain.OsrsPlayer;

/**
 * @author impurity
 */
public interface OsrsService {

    OsrsPlayer getPlayer(String playerName);

    OsrsItem getItem(Long item);
}
