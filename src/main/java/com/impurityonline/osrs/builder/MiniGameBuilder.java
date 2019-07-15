package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiMiniGameResponse;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.MiniGame;
import com.impurityonline.osrs.domain.player.MiniGames;
import lombok.NonNull;

/**
 * @author impurity
 */
public class MiniGameBuilder {

    private MiniGameBuilder() {}

    public static MiniGames buildMiniGames(@NonNull ApiPlayerResponse apiPlayerResponse) {
        MiniGames miniGames = new MiniGames();
        miniGames.setBountyHunter(buildMiniGame(apiPlayerResponse.getBountyHunter()));
        miniGames.setBountyHunterRogues(buildMiniGame(apiPlayerResponse.getBountyHunterRogues()));
        miniGames.setLastManStanding(buildMiniGame(apiPlayerResponse.getLastManStanding()));
        return miniGames;
    }

    private static MiniGame buildMiniGame(@NonNull ApiMiniGameResponse apiMiniGameResponse) {
        MiniGame miniGame = new MiniGame();
        miniGame.setRank(apiMiniGameResponse.getRank());
        miniGame.setScore(apiMiniGameResponse.getScore());
        return miniGame;
    }
}
