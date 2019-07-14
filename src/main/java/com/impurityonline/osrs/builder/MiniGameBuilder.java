package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.domain.player.MiniGame;
import com.impurityonline.osrs.domain.player.MiniGames;
import com.impurityonline.osrs.enums.OsrsHiScore;
import lombok.NonNull;

/**
 * @author impurity
 */
public class MiniGameBuilder {
    private static final String DELIMITER = ",";
    private static final int MINIGAMES_TOTAL = 3;
    private static final int MINIGAME_VALUE_TOTAL = 2;

    private MiniGameBuilder() {}

    /**
     * Create all scrolls based off hiscores
     *
     * @param hiscores the collection of values still delimited by commas
     * @return The osrs scrolls with proper mapping
     */
    public static MiniGames buildMiniGames(@NonNull final String[] hiscores) {
        if (hiscores.length != PlayerBuilder.HISCORE_TOTAL) {
            throw new IllegalArgumentException("Invalid hiscores length");
        }
        MiniGame[] miniGames = buildMiniGamesFromStringArray(
                new String[] {
                        hiscores[OsrsHiScore.BOUNTY_HUNTER.ordinal()],
                        hiscores[OsrsHiScore.BOUNTY_HUNTER_ROGUES.ordinal()],
                        hiscores[OsrsHiScore.LAST_MAN_STANDING.ordinal()],
                }
        );
        int i = -1;
        MiniGames osrsMiniGames = new MiniGames();
        osrsMiniGames.setBountyHunter(miniGames[++i]);
        osrsMiniGames.setBountyHunterRogues(miniGames[++i]);
        osrsMiniGames.setLastManStanding(miniGames[++i]);
        return osrsMiniGames;
    }

    /**
     * Create all minigame based off 6 scrolls
     *
     * @param miniGameValues the collection of values still delimited by commas
     * @return The collection of minigames
     */
    private static MiniGame[] buildMiniGamesFromStringArray(final String[] miniGameValues) {
        MiniGame[] miniGames = new MiniGame[MINIGAMES_TOTAL];
        for (int i = 0; i < miniGames.length; i++) {
            miniGames[i] = buildMiniGame(miniGameValues[i]);
        }
        return miniGames;
    }

    /**
     * Create a minigame based off 2 longs
     *
     * @param miniGameValue - MiniGame string with comma delimiter
     * @return The Osrs minigame object that was created based off the parameter
     */
    private static MiniGame buildMiniGame(final String miniGameValue) {
        String[] miniGameValues = miniGameValue.split(DELIMITER);
        if (miniGameValues.length != MINIGAME_VALUE_TOTAL) {
            throw new IllegalArgumentException("Invalid miniGameValue length");
        }
        MiniGame miniGame = new MiniGame();
        miniGame.setRank(Long.parseLong(miniGameValues[0]));
        miniGame.setScore(Long.parseLong(miniGameValues[1]));
        return miniGame;
    }
}
