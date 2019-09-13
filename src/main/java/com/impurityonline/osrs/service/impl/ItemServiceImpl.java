package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.client.response.item.ApiItem;
import com.impurityonline.osrs.client.response.item.ApiItemResponse;
import com.impurityonline.osrs.domain.item.*;
import com.impurityonline.osrs.exception.ClientRestException;
import com.impurityonline.osrs.exception.PlayerRequestException;
import com.impurityonline.osrs.exception.ServerRestException;
import com.impurityonline.osrs.service.ItemService;
import lombok.NonNull;
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
    public Item getItem(@NonNull Long itemId) {
        ApiItemResponse apiItemResponse;
        try {
            apiItemResponse = osrsClient.getItem(itemId);
            return buildItem(apiItemResponse.getItem());
        } catch (ClientRestException ex) {
            log.error("Osrs Client Issues: {}", ex.getMessage());
            throw new PlayerRequestException("Cannot get item", ex.getStatus(), ex);
        } catch (ServerRestException ex) {
            log.error("Osrs Server Issues: {}", ex.getMessage());
            throw new PlayerRequestException("Cannot get item", ex.getStatus(), ex);
        }
    }

    private Item buildItem(ApiItem apiItem) {
        Item item = new Item();
        item.setId(apiItem.getId());
        item.setName(apiItem.getName());
        item.setType(apiItem.getType());
        item.setDescription(apiItem.getDescription());
        item.setMembers(apiItem.getMembers());
        item.setIcons(buildItemIcons(apiItem));
        item.setPrices(buildItemPrices(apiItem));
        item.setTrends(buildItemTrends(apiItem));
        item.setChanges(buildItemChanges(apiItem));
        return item;
    }

    private ItemChanges buildItemChanges(ApiItem apiItem) {
        ItemChanges itemChanges = new ItemChanges();
        itemChanges.setDay30(apiItem.getDay30().getChange());
        itemChanges.setDay90(apiItem.getDay90().getChange());
        itemChanges.setDay180(apiItem.getDay180().getChange());
        return itemChanges;
    }

    private ItemIcons buildItemIcons(ApiItem apiItem) {
        ItemIcons itemIcons = new ItemIcons();
        itemIcons.setSmallIcon(apiItem.getIcon());
        itemIcons.setLargeIcon(apiItem.getIconLarge());
        itemIcons.setTypeIcon(apiItem.getTypeIcon());
        return itemIcons;
    }

    private ItemPrices buildItemPrices(ApiItem apiItem) {
        ItemPrices itemPrices = new ItemPrices();
        itemPrices.setCurrent(apiItem.getCurrent().getPrice());
        itemPrices.setToday(apiItem.getToday().getPrice());
        return itemPrices;
    }

    private ItemTrends buildItemTrends(ApiItem apiItem) {
        ItemTrends itemTrends = new ItemTrends();
        itemTrends.setCurrent(apiItem.getCurrent().getPrice());
        itemTrends.setToday(apiItem.getToday().getPrice());
        itemTrends.setDay30(apiItem.getDay30().getTrend());
        itemTrends.setDay90(apiItem.getDay90().getTrend());
        itemTrends.setDay180(apiItem.getDay180().getTrend());
        return itemTrends;
    }
}
