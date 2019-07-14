package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.client.response.item.ApiItem;
import com.impurityonline.osrs.client.response.item.ApiItemResponse;
import com.impurityonline.osrs.domain.item.*;
import com.impurityonline.osrs.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author impurity
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private OsrsClient osrsClient;

    @Override
    public Item getItem(Long itemId) {
        ApiItemResponse apiItemResponse = osrsClient.getItem(itemId);
        ApiItem apiItem = apiItemResponse.getItem();

        ItemIcons itemIcons = new ItemIcons();
        itemIcons.setSmallIcon(apiItem.getIcon());
        itemIcons.setLargeIcon(apiItem.getIconLarge());
        itemIcons.setTypeIcon(apiItem.getTypeIcon());

        ItemPrices itemPrices = new ItemPrices();
        itemPrices.setCurrent(apiItem.getCurrent().getPrice());
        itemPrices.setToday(apiItem.getToday().getPrice());

        ItemTrends itemTrends = new ItemTrends();
        itemTrends.setCurrent(apiItem.getCurrent().getPrice());
        itemTrends.setToday(apiItem.getToday().getPrice());
        itemTrends.setDay30(apiItem.getDay30().getTrend());
        itemTrends.setDay90(apiItem.getDay90().getTrend());
        itemTrends.setDay180(apiItem.getDay180().getTrend());

        ItemChanges itemChanges = new ItemChanges();
        itemChanges.setDay30(apiItem.getDay30().getChange());
        itemChanges.setDay90(apiItem.getDay90().getChange());
        itemChanges.setDay180(apiItem.getDay180().getChange());

        Item item = new Item();
        item.setId(apiItem.getId());
        item.setName(apiItem.getName());
        item.setType(apiItem.getType());
        item.setDescription(apiItem.getDescription());
        item.setMembers(apiItem.getMembers());
        item.setIcons(itemIcons);
        item.setPrices(itemPrices);
        item.setTrends(itemTrends);
        item.setChanges(itemChanges);
        return item;
    }
}
