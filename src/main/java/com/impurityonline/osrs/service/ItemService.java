package com.impurityonline.osrs.service;

import com.impurityonline.osrs.domain.OsrsItem;
import com.impurityonline.osrs.domain.OsrsPlayer;

/**
 * @author impurity
 */
public interface ItemService {

    /**
     * Grab the item from the osrs api
     * @param itemId - the osrs item identifying number
     * @return - the osrs item statistics
     */
    OsrsItem getItem(Long itemId);
}
