package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.domain.OsrsPlayer;
import lombok.NonNull;

import static com.impurityonline.osrs.builder.OsrsMiniGameBuilder.buildMiniGames;
import static com.impurityonline.osrs.builder.OsrsScrollsBuilder.buildScrolls;
import static com.impurityonline.osrs.builder.OsrsSkillsBuilder.buildSkills;

/**
 * @author impurity
 */
public class OsrsPlayerBuilder {
    private static final String DELIMITER = "\\n";
    public static final int HISCORE_TOTAL = 34;

    private OsrsPlayerBuilder() {}

    public static OsrsPlayer buildPlayer(
            @NonNull final String name,
            @NonNull final String type,
            @NonNull final String playerHiScores
    ) {
        String[] scores = buildScores(playerHiScores);
        OsrsPlayer player = new OsrsPlayer();
        player.setName(name);
        player.setType(type);
        player.setSkills(buildSkills(scores));
        player.setScrolls(buildScrolls(scores));
        player.setMiniGames(buildMiniGames(scores));
        return player;
    }

    /**
     * Create all the scores based off a string with newline delimiters
     *
     * @param playerHiScores Hiscores with newline delimiters
     * @return A collection of hiscores still with comma delimiter
     */
    private static String[] buildScores(final String playerHiScores) {
        String[] scores = playerHiScores.split(DELIMITER);
        if (scores.length != HISCORE_TOTAL) {
            throw new IllegalArgumentException("Invalid playerHiScores length");
        }
        return scores;
    }
}
