package com.impurityonline.osrs.builder;

import com.impurityonline.osrs.client.response.player.ApiClueScroll;
import com.impurityonline.osrs.client.response.player.ApiPlayerResponse;
import com.impurityonline.osrs.domain.player.Scroll;
import com.impurityonline.osrs.domain.player.Scrolls;
import lombok.NonNull;

/**
 * @author impurity
 */
public class ScrollsBuilder {

    private ScrollsBuilder() {}

    public static Scrolls buildScrolls(@NonNull ApiPlayerResponse apiPlayerResponse) {
        Scrolls scrolls = new Scrolls();
        scrolls.setClueScrolls(buildScroll(apiPlayerResponse.getClueScrolls()));
        scrolls.setEasyClueScrolls(buildScroll(apiPlayerResponse.getEasyClueScrolls()));
        scrolls.setMediumClueScrolls(buildScroll(apiPlayerResponse.getMediumClueScrolls()));
        scrolls.setHardClueScrolls(buildScroll(apiPlayerResponse.getHardClueScrolls()));
        scrolls.setEliteClueScrolls(buildScroll(apiPlayerResponse.getEliteClueScrolls()));
        scrolls.setMasterClueScrolls(buildScroll(apiPlayerResponse.getMasterClueScrolls()));
        return scrolls;
    }

    private static Scroll buildScroll(@NonNull ApiClueScroll apiClueScroll) {
        Scroll scroll = new Scroll();
        scroll.setRank(apiClueScroll.getRank());
        scroll.setScore(apiClueScroll.getScore());
        return scroll;
    }
}
