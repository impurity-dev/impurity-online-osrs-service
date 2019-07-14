package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.controller.response.item.*;
import com.impurityonline.osrs.domain.item.Item;
import com.impurityonline.osrs.domain.item.ItemPrice;
import com.impurityonline.osrs.domain.item.ItemTrend;
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
    public ItemResponse getItem(
            @PathVariable("itemId") Long itemId
    ) {

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
    public String getItemName(
            @PathVariable("itemId") Long itemId
    ) {
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
    public String getItemDescription(
            @PathVariable("itemId") Long itemId
    ) {
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
    public String getItemType(
            @PathVariable("itemId") Long itemId
    ) {
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
    public Boolean getItemMembers(
            @PathVariable("itemId") Long itemId
    ) {
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
    public ItemIconsResponse getItemIcons(
            @PathVariable("itemId") Long itemId
    ) {
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
    public String getItemTypeIcon(
            @PathVariable("itemId") Long itemId
    ) {
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
    public String getItemSmallIcon(
            @PathVariable("itemId") Long itemId
    ) {
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
    public String getItemLargeIcon(
            @PathVariable("itemId") Long itemId
    ) {
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
    public ItemPricesResponse getItemPrices(
            @PathVariable("itemId") Long itemId
    ) {
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
    public ItemPriceResponse getItemCurrentPrices(
            @PathVariable("itemId") Long itemId
    ) {
        ItemPriceResponse itemPriceResponse = new ItemPriceResponse();
        itemPriceResponse.setPrice(itemService.getItem(itemId).getPrices().getCurrent());
        return itemPriceResponse;
    }

    @ApiOperation(value = "Returns Osrs item current prices price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item current prices price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item current prices price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/current-prices/price",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemCurrentPricesPrice(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getPrices().getCurrent().getPrice();
    }

    @ApiOperation(value = "Returns Osrs item current prices trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item current prices trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item current prices trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/current-prices/trend",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemCurrentPricesTrend(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getPrices().getCurrent().getTrend();
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
    public ItemPriceResponse getItemTodayPrices(
            @PathVariable("itemId") Long itemId
    ) {
        ItemPriceResponse itemPriceResponse = new ItemPriceResponse();
        itemPriceResponse.setPrice(itemService.getItem(itemId).getPrices().getToday());
        return itemPriceResponse;
    }

    @ApiOperation(value = "Returns Osrs item today prices price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item today prices price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item today prices price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/today-prices/prices",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTodayPricesPrice(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getPrices().getToday().getPrice();
    }

    @ApiOperation(value = "Returns Osrs item today prices trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item today prices trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item today prices trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/today-prices/trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTodayPricesTrend(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getPrices().getToday().getTrend();
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
    public ItemTrendsResponse getItemTrends(
            @PathVariable("itemId") Long itemId
    ) {
        Item item = itemService.getItem(itemId);
        ItemTrend day30 = item.getTrends().getDay30();
        ItemTrend day90 = item.getTrends().getDay90();
        ItemTrend day180 = item.getTrends().getDay180();
        ItemTrendsResponse itemTrendsResponse = new ItemTrendsResponse();
        itemTrendsResponse.setDay30(day30);
        itemTrendsResponse.setDay90(day90);
        itemTrendsResponse.setDay180(day180);
        return itemTrendsResponse;
    }

    @ApiOperation(value = "Returns Osrs item day 30 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/30-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrendResponse getItemTrendDay30(
            @PathVariable("itemId") Long itemId
    ) {
        ItemTrendResponse itemTrendResponse = new ItemTrendResponse();
        itemTrendResponse.setTrend(itemService.getItem(itemId).getTrends().getDay30());
        return itemTrendResponse;
    }

    @ApiOperation(value = "Returns Osrs item day 30 trends trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 trends trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 trends trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/30-days/trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay30Trend(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay30().getTrend();
    }

    @ApiOperation(value = "Returns Osrs item day 30 trends change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 trends change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 trends change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/30-days/changes",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay30Change(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay30().getChange();
    }

    @ApiOperation(value = "Returns Osrs item day 90 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/90-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrendResponse getItemTrendDay90(
            @PathVariable("itemId") Long itemId
    ) {
        ItemTrendResponse itemTrendResponse = new ItemTrendResponse();
        itemTrendResponse.setTrend(itemService.getItem(itemId).getTrends().getDay90());
        return itemTrendResponse;
    }

    @ApiOperation(value = "Returns Osrs item day 90 trends trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 trends trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 trends trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/90-days/trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay90Trend(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay90().getTrend();
    }

    @ApiOperation(value = "Returns Osrs item day 90 trends change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 trends change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 trends change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/90-days/changes",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay90Change(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay90().getChange();
    }

    @ApiOperation(value = "Returns Osrs item day 180 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/180-days",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrendResponse getItemTrendDay180(
            @PathVariable("itemId") Long itemId
    ) {
        ItemTrendResponse itemTrendResponse = new ItemTrendResponse();
        itemTrendResponse.setTrend(itemService.getItem(itemId).getTrends().getDay180());
        return itemTrendResponse;
    }

    @ApiOperation(value = "Returns Osrs item day 180 trends trend")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 trends trend was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 trends trend was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/180-days/trends",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay180Trend(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay180().getTrend();
    }

    @ApiOperation(value = "Returns Osrs item day 180 trends change")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 trends change was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 trends change was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/180-days/changes",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTrendDay180Change(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTrends().getDay180().getChange();
    }
}
