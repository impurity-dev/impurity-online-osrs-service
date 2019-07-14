package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.client.response.item.ApiItem;
import com.impurityonline.osrs.client.response.item.ApiItemResponse;
import com.impurityonline.osrs.domain.item.*;
import com.impurityonline.osrs.exception.ItemNotFoundException;
import com.impurityonline.osrs.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        ItemPrice currentItemPrice = new ItemPrice();
        currentItemPrice.setPrice(apiItem.getCurrent().getPrice());
        currentItemPrice.setTrend(apiItem.getCurrent().getTrend());
        ItemPrice todayItemPrice = new ItemPrice();
        todayItemPrice.setPrice(apiItem.getToday().getPrice());
        todayItemPrice.setTrend(apiItem.getToday().getTrend());
        itemPrices.setCurrent(currentItemPrice);
        itemPrices.setToday(todayItemPrice);

        ItemTrends itemTrends = new ItemTrends();
        ItemTrend day30Trend = new ItemTrend();
        day30Trend.setTrend(apiItem.getDay30().getTrend());
        day30Trend.setChange(apiItem.getDay30().getChange());
        ItemTrend day90Trend = new ItemTrend();
        day90Trend.setTrend(apiItem.getDay90().getTrend());
        day90Trend.setChange(apiItem.getDay90().getChange());
        ItemTrend day180Trend = new ItemTrend();
        day180Trend.setTrend(apiItem.getDay180().getTrend());
        day180Trend.setChange(apiItem.getDay180().getChange());
        itemTrends.setDay30(day30Trend);
        itemTrends.setDay90(day90Trend);
        itemTrends.setDay180(day180Trend);


        Item item = new Item();
        item.setId(apiItem.getId());
        item.setName(apiItem.getName());
        item.setType(apiItem.getType());
        item.setDescription(apiItem.getDescription());
        item.setMembers(apiItem.getMembers());
        item.setIcons(itemIcons);
        item.setPrices(itemPrices);
        item.setTrends(itemTrends);
        return item;
    }
}
