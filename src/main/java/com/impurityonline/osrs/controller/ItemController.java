package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.domain.Item;
import com.impurityonline.osrs.domain.ItemPrice;
import com.impurityonline.osrs.domain.ItemTrend;
import com.impurityonline.osrs.response.OsrsPricesResponse;
import com.impurityonline.osrs.response.OsrsTrendsResponse;
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
@Api(value = "Osrs API endpoints", tags = {"Osrs"})
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
    public Item getItem(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId);
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
            @ApiResponse(code = 404, message = "The osrs item description name was not found"),
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
            @ApiResponse(code = 404, message = "The osrs item type name was not found"),
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

    @ApiOperation(value = "Returns Osrs item type icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item type icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item type icon name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/type-icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemTypeIcon(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getTypeIcon();
    }

    @ApiOperation(value = "Returns Osrs item icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item icon name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icons",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemIcon(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getIcon();
    }

    @ApiOperation(value = "Returns Osrs item large icon")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item large icon was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item large icon name was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/icon-larges",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public String getItemIconLarge(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getIconLarge();
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
    public OsrsPricesResponse getItemPrices(
            @PathVariable("itemId") Long itemId
    ) {
        Item item = itemService.getItem(itemId);
        OsrsPricesResponse osrsPricesResponse = new OsrsPricesResponse();
        osrsPricesResponse.setCurrent(item.getCurrent());
        osrsPricesResponse.setToday(item.getToday());
        return osrsPricesResponse;
    }

    @ApiOperation(value = "Returns Osrs item current price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item current price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item current price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/currents",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemPrice getItemCurrentPrice(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getCurrent();
    }

    @ApiOperation(value = "Returns Osrs item today price")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item today price was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item today price was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/prices/todays",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemPrice getItemTodayPrice(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getToday();
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
    public OsrsTrendsResponse getItemTrends(
            @PathVariable("itemId") Long itemId
    ) {
        Item item = itemService.getItem(itemId);
        ItemTrend day30 = item.getDay30();
        ItemTrend day90 = item.getDay90();
        ItemTrend day180 = item.getDay180();
        OsrsTrendsResponse osrsTrendsResponse = new OsrsTrendsResponse();
        osrsTrendsResponse.setDay30(day30);
        osrsTrendsResponse.setDay90(day90);
        osrsTrendsResponse.setDay180(day180);
        return osrsTrendsResponse;
    }

    @ApiOperation(value = "Returns Osrs item day 30 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 30 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 30 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/days/30",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrend getItemTrendDay30(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getDay30();
    }

    @ApiOperation(value = "Returns Osrs item day 90 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 90 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 90 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/days/90",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrend getItemTrendDay90(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getDay90();
    }

    @ApiOperation(value = "Returns Osrs item day 180 trends")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs item day 180 trends was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs item day 180 trends was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{itemId}/trends/days/180",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ItemTrend getItemTrendDay180(
            @PathVariable("itemId") Long itemId
    ) {
        return itemService.getItem(itemId).getDay180();
    }
}
