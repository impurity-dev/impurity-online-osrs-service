package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.domain.Item;
import com.impurityonline.osrs.exception.OsrsClientItemHttpRequestException;
import com.impurityonline.osrs.exception.OsrsItemNotFoundException;
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
public class ItemControllerTests extends AbstractTest {

    @MockBean
    private ItemService itemService;
    @Autowired
    private MockMvc mockMvc;
    private final Long MOCK_ITEM_ID = 123L;

    @Test
    @DisplayName("When getting a osrs item, return 200 and item")
    public void osrs_item_return_200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);

        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        mapToJson(item)
                ));
    }

    @Test
    @DisplayName("When getting a osrs item and is not found, return 404")
    public void no_osrs_item_return_404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item and it cannot be created, return 500")
    public void osrs_item_return_500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item name, return 200 and name")
    public void osrs_itemName_return_200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);

        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getName()));
    }

    @Test
    @DisplayName("When getting a osrs item name and is not found, return 404")
    public void no_osrs_itemName_return_404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item name and it cannot be created, return 500")
    public void osrs_itemName_return_500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/names")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("When getting a osrs item description, return 200 and description")
    public void osrs_itemDescription_return_200() throws Exception {
        Item item = getValidOsrsItem(MOCK_ITEM_ID);

        when(itemService.getItem(MOCK_ITEM_ID)).thenReturn(item);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(item.getDescription()));
    }

    @Test
    @DisplayName("When getting a osrs item description and is not found, return 404")
    public void no_osrs_itemDescription_return_404() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsItemNotFoundException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("When getting a osrs item description and it cannot be created, return 500")
    public void osrs_itemDescription_return_500() throws Exception {
        when(itemService.getItem(MOCK_ITEM_ID)).thenThrow(OsrsClientItemHttpRequestException.class);
        mockMvc.perform(get("/v1/items/" + MOCK_ITEM_ID + "/descriptions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
}
