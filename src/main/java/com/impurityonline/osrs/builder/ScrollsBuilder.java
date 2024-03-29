package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.domain.Scroll;
import com.impurityonline.osrs.domain.Scrolls;
import com.impurityonline.osrs.enums.OsrsHiScore;
import lombok.NonNull;

/**
 * @author impurity
 */
public class ScrollsBuilder {
    private static final String DELIMITER = ",";
    private static final int SCROLLS_TOTAL = 6;
    private static final int SCROLL_VALUE_TOTAL = 2;

    private ScrollsBuilder() {}

    /**
     * Create all scrolls based off hiscores
     *
     * @param hiscores the collection of values still delimited by commas
     * @return The osrs scrolls with proper mapping
     */
    public static Scrolls buildScrolls(@NonNull final String[] hiscores) {
        if (hiscores.length != PlayerBuilder.HISCORE_TOTAL) {
            throw new IllegalArgumentException("Invalid hiscores length");
        }
        Scroll[] scrolls = buildScrollsFromStringArray(
                new String[] {
                        hiscores[OsrsHiScore.CLUE_SCROLLS.ordinal()],
                        hiscores[OsrsHiScore.EASY_CLUE_SCROLLS.ordinal()],
                        hiscores[OsrsHiScore.MEDIUM_CLUE_SCROLLS.ordinal()],
                        hiscores[OsrsHiScore.HARD_CLUE_SCROLL.ordinal()],
                        hiscores[OsrsHiScore.ELITE_CLUE_SCROLL.ordinal()],
                        hiscores[OsrsHiScore.MASTER_CLUE_SCROLL.ordinal()],
                }
        );
        int i = -1;
        Scrolls osrsScrolls = new Scrolls();
        osrsScrolls.setClueScrolls(scrolls[++i]);
        osrsScrolls.setEasyClueScrolls(scrolls[++i]);
        osrsScrolls.setMediumClueScrolls(scrolls[++i]);
        osrsScrolls.setHardClueScrolls(scrolls[++i]);
        osrsScrolls.setEliteClueScrolls(scrolls[++i]);
        osrsScrolls.setMasterClueScrolls(scrolls[++i]);
        return osrsScrolls;
    }

    /**
     * Create all scroll based off 6 scrolls
     *
     * @param scrollValues the collection of values still delimited by commas
     * @return The collection of scrolls
     */
    private static Scroll[] buildScrollsFromStringArray(final String[] scrollValues) {
        Scroll[] scrolls = new Scroll[SCROLLS_TOTAL];
        for (int i = 0; i < scrolls.length; i++) {
            scrolls[i] = buildScrollFromString(scrollValues[i]);
        }
        return scrolls;
    }
    /**
     * Create a scroll based off 2 longs
     *
     * @param scrollValue - Scroll string with comma delimiter
     * @return The Osrs scrolls object that was created based off the parameter
     */
    private static Scroll buildScrollFromString(final String scrollValue) {
        String[] skillValues = scrollValue.split(DELIMITER);
        if (skillValues.length != SCROLL_VALUE_TOTAL) {
            throw new IllegalArgumentException("Invalid skillValue length");
        }
        Scroll scroll = new Scroll();
        scroll.setRank(Long.parseLong(skillValues[0]));
        scroll.setScore(Long.parseLong(skillValues[1]));
        return scroll;
    }
}
