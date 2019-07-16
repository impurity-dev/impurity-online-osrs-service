package com.impurityonline.osrs.factory;

import com.impurityonline.osrs.utils.configs.AbstractTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
class UrlFactoryTests extends AbstractTest {

    @Test
    @DisplayName("When player url playName is null, throw null pointer")
    void osrsUrl_player_null_playerName() {
        assertThrows(NullPointerException.class, () -> UrlFactory.buildPlayerURL(null));
    }

    @Test
    @DisplayName("When grandExchange url itemId is null, throw null pointer")
    void osrsUrl_item_null_itemId() {
        assertThrows(NullPointerException.class, () -> UrlFactory.buildGrandExchangeURL(null));
    }

    @Test
    @DisplayName("When player name supplied, player query param is valid")
    void osrsUrl_player_playerNameIsValid() {
        String playerName = "1234";
        assertEquals(playerName, UrlFactory.buildPlayerURL(playerName).build().getQueryParams().get("player").get(0));
    }

    @Test
    @DisplayName("When item id supplied, item query param is valid")
    void osrsUrl_item_itemIdIsValid() {
        Long itemId = 1234L;
        assertEquals(itemId, (Long) Long.parseLong(UrlFactory.buildGrandExchangeURL(itemId).build().getQueryParams().get("item").get(0)));
    }

}
