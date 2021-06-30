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
            winResult = compareSameCategory(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    private String compareSameCategory(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 0) { // Straight Flush
            winResult = SameCategoryComparator.compareStraightFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 1) { // Four Of A Kind
            winResult = SameCategoryComparator.compareFourOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 2) { // Full House
            winResult = SameCategoryComparator.compareFullHouse(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 3) { // Flush
            winResult = SameCategoryComparator.compareFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 4) { // Straight
            winResult = SameCategoryComparator.compareStraight(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 5) { // Three Of A Kind
            winResult = SameCategoryComparator.compareThreeOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 6) { // Two Pair
            winResult = SameCategoryComparator.compareTwoPair(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 7) { // One Pair
            winResult = SameCategoryComparator.compareOnePair(blackHandsObj, whiteHandsObj);
        } else { // High Card
            winResult = compareHighCard(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    private String compareHighCard( Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult="";
        for (int i = 0; i < 5; i++) {
            if (blackHandsObj.getDescendingHandsNumbers()[i] < whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = PokerUtil.intNumber(whiteHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (blackHandsObj.getDescendingHandsNumbers()[i] > whiteHandsObj.getDescendingHandsNumbers()[i]) {
                String sig = PokerUtil.intNumber(blackHandsObj.getDescendingHandsNumbers()[i]);
                winResult = "black wins - high card:" + sig;
                break;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }

}
