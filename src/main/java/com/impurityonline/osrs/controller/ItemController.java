package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.response.OsrsItemResponse;
import com.impurityonline.osrs.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OsrsItemResponse getItem(
            @PathVariable("itemId") Long itemId
    ) {
        OsrsItemResponse osrsItemResponse = new OsrsItemResponse();
        osrsItemResponse.setItem(itemService.getItem(itemId));
        return osrsItemResponse;
    }
}
