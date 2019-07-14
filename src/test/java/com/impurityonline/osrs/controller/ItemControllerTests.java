package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.domain.Item;
import com.impurityonline.osrs.exception.OsrsClientItemHttpRequestException;
import com.impurityonline.osrs.exception.ItemNotFoundException;
import com.impurityonline.osrs.controller.response.IconsResponse;
import com.impurityonline.osrs.controller.response.PricesResponse;
import com.impurityonline.osrs.controller.response.TrendsResponse;
import com.impurityonline.osrs.service.ItemService;
import com.impurityonline.osrs.utils.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.impurityonline.osrs.constant.Profiles.UNIT_TEST;
import static com.impurityonline.osrs.utils.OsrsFactory.getValidOsrsItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author impurity
 */
@Tag("Controller")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles(UNIT_TEST)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTests extends AbstractTest {

    @MockBean
    private ItemService itemService;
    @Autowired
    private MockMvc mockMvc;
    private final Long MOCK_ITEM_ID = 123L;

    @Test
    @DisplayName("When getting a osrs item, return 200 and item")
    void item_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item)));
    }

    @Test
    @DisplayName("When getting a osrs item and is not found, return 404")
    void no_item_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item and it cannot be created, return 500")
    void item_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item name, return 200 and name")
    void itemName_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getName()));
    }

    @Test
    @DisplayName("When getting a osrs item name and is not found, return 404")
    void no_itemName_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item name and it cannot be created, return 500")
    void itemName_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item description, return 200 and description")
    void itemDescription_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getDescription()));
    }

    @Test
    @DisplayName("When getting a osrs item description and is not found, return 404")
    void no_itemDescription_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item description and it cannot be created, return 500")
    void itemDescription_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item type, return 200 and type")
    void itemType_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getType()));
    }

    @Test
    @DisplayName("When getting a osrs item type and is not found, return 404")
    void no_itemType_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item type and it cannot be created, return 500")
    void itemType_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/types")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item icons, return 200 and icons")
    void itemIcon_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        IconsResponse iconsResponse = new IconsResponse();
        iconsResponse.setLargeIcon(item.getLargeIcon());
        iconsResponse.setSmallIcon(item.getSmallIcon());
        iconsResponse.setTypeIcon(item.getTypeIcon());
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(iconsResponse)));
    }

    @Test
    @DisplayName("When getting a osrs item icons and is not found, return 404")
    void no_itemIcon_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item icons and it cannot be created, return 500")
    void itemIcon_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item type icon, return 200 and type icon")
    void itemTypeIcon_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/type-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getTypeIcon()));
    }

    @Test
    @DisplayName("When getting a osrs item type icon and is not found, return 404")
    void no_itemTypeIcon_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/type-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item type icon and it cannot be created, return 500")
    void itemTypeIcon_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/type-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item small icon, return 200 and small icon")
    void itemSmallIcon_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/small-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getSmallIcon()));
    }

    @Test
    @DisplayName("When getting a osrs item small icon and is not found, return 404")
    void no_itemSmallIcon_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/small-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item small icon and it cannot be created, return 500")
    void itemSmallIcon_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/small-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item large icon, return 200 and large icon")
    void itemLargeIcon_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/large-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getLargeIcon()));
    }

    @Test
    @DisplayName("When getting a osrs item large icon and is not found, return 404")
    void no_itemLargeIcon_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/large-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item large icon and it cannot be created, return 500")
    void itemLargeIcon_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/icons/large-icons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item is member, return 200 and is member")
    void itemIsMember_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/members")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getMembers().toString()));
    }

    @Test
    @DisplayName("When getting a osrs item is member and is not found, return 404")
    void no_itemIsMember_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/members")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item is member and it cannot be created, return 500")
    void itemIsMember_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/members")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item prices, return 200 and prices")
    void itemPrices_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        PricesResponse pricesResponse = new PricesResponse();
        pricesResponse.setCurrent(item.getCurrent());
        pricesResponse.setToday(item.getToday());
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(pricesResponse)));
    }

    @Test
    @DisplayName("When getting a osrs item prices and is not found, return 404")
    void no_itemPrices_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item prices and it cannot be created, return 500")
    void itemPrices_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item current price, return 200 and current price")
    void itemCurrentPrice_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/current-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item.getCurrent())));
    }

    @Test
    @DisplayName("When getting a osrs item current price and is not found, return 404")
    void no_itemCurrentPrice_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/current-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item current price and it cannot be created, return 500")
    void itemCurrentPrice_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/current-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item current price, return 200 and current price")
    void itemTodayPrice_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/today-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item.getToday())));
    }

    @Test
    @DisplayName("When getting a osrs item current price and is not found, return 404")
    void no_itemTodayPrice_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/today-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item current price and it cannot be created, return 500")
    void itemTodayPrice_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/prices/today-prices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item trends, return 200 and current trends")
    void itemTrends_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        TrendsResponse trendsResponse = new TrendsResponse();
        trendsResponse.setDay30(item.getDay30());
        trendsResponse.setDay90(item.getDay90());
        trendsResponse.setDay180(item.getDay180());
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(trendsResponse)));
    }

    @Test
    @DisplayName("When getting a osrs item trends and is not found, return 404")
    void no_itemTrends_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item trends and it cannot be created, return 500")
    void itemTrends_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item 30 day trend, return 200 and current 30 day trend")
    void itemDay30Trend_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/30-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item.getDay30())));
    }

    @Test
    @DisplayName("When getting a osrs item 30 day trend and is not found, return 404")
    void no_itemDay30Trend_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/30-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item 30 day trend and it cannot be created, return 500")
    void itemDay30Trend_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/30-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item 90 day trend, return 200 and current 90 day trend")
    void itemDay90Trend_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/90-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item.getDay90())));
    }

    @Test
    @DisplayName("When getting a osrs item 90 day trend and is not found, return 404")
    void no_itemDay90Trend_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/90-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item 90 day trend and it cannot be created, return 500")
    void itemDay90Trend_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/90-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item 180 day trend, return 200 and current 180 day trend")
    void itemDay180Trend_return200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);
        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/180-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(mapToJson(item.getDay180())));
    }

    @Test
    @DisplayName("When getting a osrs item 180 day trend and is not found, return 404")
    void no_itemDay180Trend_return404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(ItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/180-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item 180 day trend and it cannot be created, return 500")
    void itemDay180Trend_return500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/trends/180-days")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
