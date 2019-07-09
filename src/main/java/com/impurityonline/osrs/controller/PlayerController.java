package com.impurityonline.osrs.controller;

import com.impurityonline.osrs.response.OsrsPlayerResponse;
import com.impurityonline.osrs.service.PlayerService;
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
@RequestMapping("/v1/players")
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation(value = "Returns Osrs player")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The osrs player was found and successfully returned"),
            @ApiResponse(code = 404, message = "The osrs player was not found"),
            @ApiResponse(code = 503, message = "The osrs api is unavailable")
    })
    @GetMapping(
            value = "/{playerName}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public OsrsPlayerResponse getPlayer(
            @PathVariable("playerName") String playerName
    ) {
        OsrsPlayerResponse osrsPlayerResponse = new OsrsPlayerResponse();
        osrsPlayerResponse.setPlayer(playerService.getPlayer(playerName));
        return osrsPlayerResponse;
    }
}
