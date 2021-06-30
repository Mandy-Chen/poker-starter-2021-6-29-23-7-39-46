package com.thoughtworks.refactor;

public class Category {
    private final String strType;

    public Category(String strType) {
        this.strType = strType;
    }

    public String getStrType() {
        return strType;
    }

    int getRanking() {
        int index = -1;
        String[] type = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};
        for (int i = 0; i < 9; i++) {
            if (type[i].equals(getStrType())) {
                index = i;
            }
        }
        return index;
    }
}
