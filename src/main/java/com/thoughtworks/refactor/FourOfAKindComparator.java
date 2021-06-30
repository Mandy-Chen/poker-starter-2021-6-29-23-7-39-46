package com.thoughtworks.refactor;

public class FourOfAKindComparator extends SameCategoryComparator {

    @Override
    String compareSameCategory(Hands blackHandsObj, Hands whiteHandsObj) {
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
}
