package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.test.utils.configs.AbstractServiceTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author impurity
 */
public class ItemServiceImplTests extends AbstractServiceTest {

    @Mock
    private OsrsClient osrsClient;
    @InjectMocks
    private ItemServiceImpl itemService;
    private static String MOCK_PLAYER_NAME = "1234";

    @Test
    @DisplayName("When itemId is nul, throw nullpointer")
    void getPlayer_nullName_throwNullPointer() {
        assertThrows(NullPointerException.class, () -> itemService.getItem(null));
    }

}
