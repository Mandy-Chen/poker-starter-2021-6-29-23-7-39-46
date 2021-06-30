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
}
