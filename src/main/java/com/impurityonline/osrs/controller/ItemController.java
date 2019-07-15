package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.controller.response.item.ItemIconsResponse;
import com.impurityonline.osrs.controller.response.item.ItemPricesResponse;
import com.impurityonline.osrs.controller.response.item.ItemResponse;
import com.impurityonline.osrs.controller.response.item.ItemTrendsResponse;
import com.impurityonline.osrs.domain.item.Item;
import com.impurityonline.osrs.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author impurity
 */
@Api(value = "Osrs Item endpoints", tags = {"Item"})
@RequestMapping("/v1/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "Returns Osrs item")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemResponse getItem(@PathVariable("itemId") Long itemId) {
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItem(itemService.getItem(itemId));
        return itemResponse;
    }

    @ApiOperation(value = "Returns Osrs item name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item name was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/names",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemName(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getName();
    }

    @ApiOperation(value = "Returns Osrs item description")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item description was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item description was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/descriptions",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemDescription(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getDescription();
    }

    @ApiOperation(value = "Returns Osrs item type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item type was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item type was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/types",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemType(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getType();
    }

    @ApiOperation(value = "Returns Osrs item member status")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item member status was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item member status was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/members",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public Boolean getItemMembers(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getMembers();
    }

    @ApiOperation(value = "Returns Osrs item icons")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item icons were found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item icons were not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemIconsResponse getItemIcons(@PathVariable("itemId") Long itemId) {
        Item item = itemService.getItem(itemId);
        ItemIconsResponse itemIconsResponse = new ItemIconsResponse();
        itemIconsResponse.setTypeIcon(item.getIcons().getTypeIcon());
        itemIconsResponse.setSmallIcon(item.getIcons().getSmallIcon());
        itemIconsResponse.setLargeIcon(item.getIcons().getLargeIcon());
        return itemIconsResponse;
    }

    @ApiOperation(value = "Returns Osrs item type icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item type icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item type icon was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icons/type-icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemIconType(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getIcons().getTypeIcon();
    }

    @ApiOperation(value = "Returns Osrs item small icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item small icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item small icon name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icons/small-icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemIconSmall(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getIcons().getSmallIcon();
    }

    @ApiOperation(value = "Returns Osrs item large icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item large icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item large icon name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icons/large-icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemIconLarge(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getIcons().getLargeIcon();
    }

    @ApiOperation(value = "Returns Osrs item prices")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item prices were found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item prices were not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemPricesResponse getItemPrices(@PathVariable("itemId") Long itemId) {
        Item item = itemService.getItem(itemId);
        ItemPricesResponse itemPricesResponse = new ItemPricesResponse();
        itemPricesResponse.setCurrent(item.getPrices().getCurrent());
        itemPricesResponse.setToday(item.getPrices().getToday());
        return itemPricesResponse;
    }

    @ApiOperation(value = "Returns Osrs item current price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item current price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item current price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/current-prices",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemPriceCurrent(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getPrices().getCurrent();
    }

    @ApiOperation(value = "Returns Osrs item today price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item today price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item today price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/today-prices",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemPriceToday(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getPrices().getToday();
    }

    @ApiOperation(value = "Returns Osrs item trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrendsResponse getItemTrends(@PathVariable("itemId") Long itemId) {
        Item item = itemService.getItem(itemId);
        ItemTrendsResponse itemTrendsResponse = new ItemTrendsResponse();
        itemTrendsResponse.setCurrent(item.getTrends().getCurrent());
        itemTrendsResponse.setToday(item.getTrends().getToday());
        itemTrendsResponse.setDay30(item.getTrends().getDay30());
        itemTrendsResponse.setDay90(item.getTrends().getDay90());
        itemTrendsResponse.setDay180(item.getTrends().getDay180());
        return itemTrendsResponse;
    }

    @ApiOperation(value = "Returns Osrs item current trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item current trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item current trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/current-trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemCurrentToday(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getTrends().getCurrent();
    }

    @ApiOperation(value = "Returns Osrs item today trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item today trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item today trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/today-trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendToday(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getTrends().getToday();
    }

    @ApiOperation(value = "Returns Osrs item day 30 trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/30-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay30(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getTrends().getDay30();
    }

    @ApiOperation(value = "Returns Osrs item day 90 trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/90-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay90(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getTrends().getDay90();
    }

    @ApiOperation(value = "Returns Osrs item day 180 trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/180-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay180(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getTrends().getDay180();
    }

    @ApiOperation(value = "Returns Osrs item day 30 change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/changes/30-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemChangeDay30(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getChanges().getDay30();
    }

    @ApiOperation(value = "Returns Osrs item day 90 change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/changes/90-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemChangeDay90Change(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getChanges().getDay90();
    }

    @ApiOperation(value = "Returns Osrs item day 180 change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/changes/180-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemChangeDay180(@PathVariable("itemId") Long itemId) {
        return itemService.getItem(itemId).getChanges().getDay180();
    }
}
