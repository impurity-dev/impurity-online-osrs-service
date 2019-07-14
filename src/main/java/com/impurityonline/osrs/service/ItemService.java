package com.impurityonline.osrs.service;

import com.impurityonline.osrs.domain.item.Item;

/**
 * @author impurity
 */
public interface ItemService {

    /**
     * Grab the item from the osrs api
     * @param itemId - the osrs item identifying number
     * @return - the osrs item statistics
     */
    Item getItem(Long itemId);
}
