package com.thoughtworks.refactor;

public class SameCategoryComparator {
    static String compareStraightFlush(Hands blackHandsObj, Hands whiteHandsObj) {
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

    static String compareFourOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (PokerUtil.getDistinctDescendingHandsNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < PokerUtil.getDistinctDescendingHandsNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(PokerUtil.getDistinctDescendingHandsNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = PokerUtil.intNumber(PokerUtil.getDistinctDescendingHandsNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    static String compareFullHouse(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (PokerUtil.getDistinctDescendingHandsNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < PokerUtil.getDistinctDescendingHandsNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(PokerUtil.getDistinctDescendingHandsNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = PokerUtil.intNumber(PokerUtil.getDistinctDescendingHandsNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
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
}
