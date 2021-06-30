package com.thoughtworks.refactor;

public class Poker {

    public static final String[] CATEGORIES = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        final Hands blackHandsObj = new Hands(blackHands);
        final Hands whiteHandsObj = new Hands(whiteHands);

        if (blackHandsObj.getCategory().judgeHandsCategoryRanking() < whiteHandsObj.getCategory().judgeHandsCategoryRanking()) {
            winResult = "black wins - " + CATEGORIES[blackHandsObj.getCategory().judgeHandsCategoryRanking()];
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() > whiteHandsObj.getCategory().judgeHandsCategoryRanking()) {
            winResult = "white wins - " + CATEGORIES[whiteHandsObj.getCategory().judgeHandsCategoryRanking()];
        } else {
            winResult =  SameCategoryComparator.getInstance(blackHandsObj.getCategory().judgeHandsCategoryRanking()).compareSameCategory(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

}
