package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiMiniGame;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.MiniGame;
import com.impurityonline.osrs.domain.player.MiniGames;
import com.impurityonline.osrs.enums.OsrsHiScore;
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
        miniGames.setLastManStanding(buildMiniGame(apiPlayerResponse.getLastManStanging()));
        return miniGames;
    }

    private static MiniGame buildMiniGame(@NonNull ApiMiniGame apiMiniGame) {
        MiniGame miniGame = new MiniGame();
        miniGame.setRank(apiMiniGame.getRank());
        miniGame.setScore(apiMiniGame.getScore());
        return miniGame;
    }
}
