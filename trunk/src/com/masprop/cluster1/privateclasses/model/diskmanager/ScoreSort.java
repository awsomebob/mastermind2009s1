package com.masprop.cluster1.privateclasses.model.diskmanager;

import com.masprop.cluster1.privateclasses.model.*;

public class ScoreSort implements java.util.Comparator {
    public int compare(Object score1, Object score2) {
        Score score1_conv = (Score)score1;
        Score score2_conv = (Score)score2;
        if ((score2_conv.getScore() > score2_conv.getScore())) {
            return 1;
        } else {
            return 0;
        }
    }
}
