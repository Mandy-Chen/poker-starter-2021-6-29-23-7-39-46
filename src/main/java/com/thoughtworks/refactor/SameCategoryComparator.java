package com.thoughtworks.refactor;

public class SameCategoryComparator {
    public SameCategoryComparator() {
    }

    public static SameCategoryComparator getInstance(int ranking) {
        if (ranking == 0) {
            return  new StraightFlushComparator();
        }else if (ranking == 1){
            return new FourOfAKindComparator();
        } else if (ranking == 2){
            return new FullHouseComparator();
        }
        return new SameCategoryComparator();
    }

    static String compareFlush(Hands blackHandsObj, Hands whiteHandsObj) {
         String winResult = "";
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

    static String compareStraight(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = PokerUtil.intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = PokerUtil.intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            winResult = "tie";
        }
        return winResult;
    }

    static String compareThreeOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    static String compareTwoPair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
        for (int i = 0; i < 2; i++) {
            if (PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] < PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] > PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i]);
                winResult = "black wins - high card:" + sig;
                break;
            }
        }
        if (winResult == "") {
            if (PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
                String sig = PokerUtil.intNumber(PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
                winResult = "white wins - high card:" + sig;
            } else if (PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] > PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
                String sig = PokerUtil.intNumber(PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
                winResult = "black wins - high card:" + sig;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }

    static String compareOnePair(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult="";
        if (PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else if (PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] > PokerUtil.getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(PokerUtil.getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            for (int i = 0; i < 3; i++) {
                if (PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] < PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                    String sig = PokerUtil.intNumber(PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]);
                    winResult = "white wins - high card:" + sig;
                    break;
                } else if (PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] > PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                    String sig = PokerUtil.intNumber(PokerUtil.getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i]);
                    winResult = "black wins - high card:" + sig;
                    break;
                } else {
                    winResult = "tie";
                }
            }
        }
        return winResult;
    }

    static String compareHighCard(Hands blackHandsObj, Hands whiteHandsObj) {
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

    String compareSameCategory(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 0) { // Straight Flush
            winResult = compareStraightFlush(blackHandsObj, whiteHandsObj);
        }  else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 3) { // Flush
            winResult = compareFlush(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 4) { // Straight
            winResult = compareStraight(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 5) { // Three Of A Kind
            winResult = compareThreeOfAKind(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 6) { // Two Pair
            winResult = compareTwoPair(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 7) { // One Pair
            winResult = compareOnePair(blackHandsObj, whiteHandsObj);
        } else { // High Card
            winResult = compareHighCard(blackHandsObj, whiteHandsObj);
        }
        return winResult;
    }

    private String compareStraightFlush(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        String winResult1;
        if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = PokerUtil.intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
            winResult1 = "white wins - high card:" + sig;
        } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
            String sig = PokerUtil.intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
            winResult1 = "black wins - high card:" + sig;
        } else {
            winResult1 = "tie";
        }
        winResult = winResult1;
        return winResult;
    }
}
