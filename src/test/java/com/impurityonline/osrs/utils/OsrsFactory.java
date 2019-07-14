package com.impurityonline.osrs.utils;

import com.impurityonline.osrs.client.response.item.ApiItem;
import com.impurityonline.osrs.client.response.item.ApiItemPrice;
import com.impurityonline.osrs.client.response.item.ApiItemResponse;
import com.impurityonline.osrs.client.response.item.ApiItemTrend;
import com.impurityonline.osrs.domain.item.*;
import com.impurityonline.osrs.domain.player.Player;

import static com.impurityonline.osrs.builder.PlayerBuilder.buildPlayer;

/**
 * @author impurity
 */
public class OsrsFactory {
    public static String getValidOsrsPlayerClientResponse() {
        return "590663,1328,39039916\n" +
                "195711,91,6103476\n" +
                "205897,89,5298921\n" +
                "379871,90,5360274\n" +
                "289325,93,7515747\n" +
                "384239,87,4244478\n" +
                "501686,64,425495\n" +
                "449344,83,2679530\n" +
                "930420,58,236075\n" +
                "1339240,51,117752\n" +
                "1288040,30,13705\n" +
                "745048,62,335272\n" +
                "687565,59,264653\n" +
                "666942,59,258067\n" +
                "582299,56,187666\n" +
                "162560,76,1356244\n" +
                "401936,58,237626\n" +
                "667564,58,224811\n" +
                "1231633,28,11508\n" +
                "168429,87,4147823\n" +
                "1706522,1,0\n" +
                "1017801,15,2642\n" +
                "1288615,1,10\n" +
                "763340,32,18141\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "93027,500\n" +
                "-1,-1\n" +
                "234068,1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1";
    }

    public static String getInvalidMinigameHiscores() {
        return "590663,1328,39039916\n" +
                "195711,91,6103476\n" +
                "205897,89,5298921\n" +
                "379871,90,5360274\n" +
                "289325,93,7515747\n" +
                "384239,87,4244478\n" +
                "501686,64,425495\n" +
                "449344,83,2679530\n" +
                "930420,58,236075\n" +
                "1339240,51,117752\n" +
                "1288040,30,13705\n" +
                "745048,62,335272\n" +
                "687565,59,264653\n" +
                "666942,59,258067\n" +
                "582299,56,187666\n" +
                "162560,76,1356244\n" +
                "401936,58,237626\n" +
                "667564,58,224811\n" +
                "1231633,28,11508\n" +
                "168429,87,4147823\n" +
                "1706522,1,0\n" +
                "1017801,15,2642\n" +
                "1288615,1,10\n" +
                "763340,32,18141\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "93027,500\n" +
                "-1,-1\n" +
                "234068,1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1,-1\n" + // invalid miniGame
                "-1,-1\n" +
                "-1,-1";
    }

    public static String getInvalidScrollsHiscores() {
        return "590663,1328,39039916\n" +
                "195711,91,6103476\n" +
                "205897,89,5298921\n" +
                "379871,90,5360274\n" +
                "289325,93,7515747\n" +
                "384239,87,4244478\n" +
                "501686,64,425495\n" +
                "449344,83,2679530\n" +
                "930420,58,236075\n" +
                "1339240,51,117752\n" +
                "1288040,30,13705\n" +
                "745048,62,335272\n" +
                "687565,59,264653\n" +
                "666942,59,258067\n" +
                "582299,56,187666\n" +
                "162560,76,1356244\n" +
                "401936,58,237626\n" +
                "667564,58,224811\n" +
                "1231633,28,11508\n" +
                "168429,87,4147823\n" +
                "1706522,1,0\n" +
                "1017801,15,2642\n" +
                "1288615,1,10\n" +
                "763340,32,18141\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "93027,500\n" +
                "-1,-1\n" +
                "234068,1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1,-1\n" + // invalid scroll
                "-1,-1";
    }

    public static String getInvalidSkillsHiscores() {
        return "590663,1328,39039916\n" +
                "195711,91,6103476,-1\n" +// invalid scroll
                "205897,89,5298921\n" +
                "379871,90,5360274\n" +
                "289325,93,7515747\n" +
                "384239,87,4244478\n" +
                "501686,64,425495\n" +
                "449344,83,2679530\n" +
                "930420,58,236075\n" +
                "1339240,51,117752\n" +
                "1288040,30,13705\n" +
                "745048,62,335272\n" +
                "687565,59,264653\n" +
                "666942,59,258067\n" +
                "582299,56,187666\n" +
                "162560,76,1356244\n" +
                "401936,58,237626\n" +
                "667564,58,224811\n" +
                "1231633,28,11508\n" +
                "168429,87,4147823\n" +
                "1706522,1,0\n" +
                "1017801,15,2642\n" +
                "1288615,1,10\n" +
                "763340,32,18141\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "93027,500\n" +
                "-1,-1\n" +
                "234068,1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1\n" +
                "-1,-1";
    }

    public static Item getValidOsrsItem(Long id) {
        ItemIcons icons = new ItemIcons();
        icons.setSmallIcon("small_ico");
        icons.setLargeIcon("large_ico");
        icons.setTypeIcon("type_ico");

        ItemPrices prices = new ItemPrices();
        ItemPrice current = new ItemPrice();
        current.setPrice("current_price");
        current.setTrend("current_trend");
        ItemPrice today = new ItemPrice();
        today.setPrice("today_price");
        today.setTrend("today_trend");
        prices.setCurrent(current);
        prices.setToday(today);

        ItemTrends trends = new ItemTrends();
        ItemTrend day30 = new ItemTrend();
        day30.setChange("day30_change");
        day30.setTrend("day30_trend");
        ItemTrend day90 = new ItemTrend();
        day90.setChange("day90_change");
        day90.setTrend("day90_trend");
        ItemTrend day180 = new ItemTrend();
        day180.setChange("day180_change");
        day180.setTrend("day180_trend");
        trends.setDay30(day30);
        trends.setDay90(day90);
        trends.setDay180(day180);

        Item item = new Item();
        item.setName("name");
        item.setDescription("desc");
        item.setId(id);
        item.setMembers(true);
        item.setType("type");
        item.setIcons(icons);
        item.setPrices(prices);
        item.setTrends(trends);

        return item;
    }

    public static Player getValidOsrsPlayer(String name, String type) {
        return buildPlayer(name, type, getValidOsrsPlayerClientResponse());
    }

    /**
     * Generate a valid API item response
     * @return a valid API item reponse
     */
    public static ApiItemResponse getValidApiItemResponse() {
        ApiItemPrice currentPrice = new ApiItemPrice();
        currentPrice.setPrice("current_price");
        currentPrice.setTrend("current_trend");
        ApiItemPrice todayPrice = new ApiItemPrice();
        todayPrice.setPrice("today_price");
        todayPrice.setTrend("today_trend");

        ApiItemTrend day30 = new ApiItemTrend();
        day30.setChange("day30_change");
        day30.setTrend("day30_trend");
        ApiItemTrend day90 = new ApiItemTrend();
        day90.setChange("day90_change");
        day90.setTrend("day90_trend");
        ApiItemTrend day180 = new ApiItemTrend();
        day180.setChange("day180_change");
        day180.setTrend("day180_trend");

        ApiItem item = new ApiItem();
        item.setIcon("a");
        item.setIconLarge("b");
        item.setId(1L);
        item.setType("d");
        item.setTypeIcon("e");
        item.setDescription("f");
        item.setMembers(true);
        item.setCurrent(currentPrice);
        item.setToday(todayPrice);
        item.setDay30(day30);
        item.setDay90(day90);
        item.setDay180(day180);

        ApiItemResponse response = new ApiItemResponse();
        response.setItem(item);
        return response;
    }
}
