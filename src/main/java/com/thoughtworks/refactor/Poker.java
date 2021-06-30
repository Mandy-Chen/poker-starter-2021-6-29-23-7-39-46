package com.thoughtworks.refactor;

import java.util.*;

public class Poker {

    public static final String[] CATEGORIES = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        final Hands blackHandsObj = new Hands(blackHands);

        final Hands whiteHandsObj = new Hands(whiteHands);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i1 = 0; i1 < whiteHandsObj.getDescendingHandsNumbers().length; i1++) {
            if (map.get(whiteHandsObj.getDescendingHandsNumbers()[i1]) != null) {
                map.put(whiteHandsObj.getDescendingHandsNumbers()[i1], map.get(whiteHandsObj.getDescendingHandsNumbers()[i1]) + 1);
            } else {
                map.put(whiteHandsObj.getDescendingHandsNumbers()[i1], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        list.addAll(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> arg0, Map.Entry<Integer, Integer> arg1) {
                return arg1.getValue().compareTo(arg0.getValue());
            }
        });
        int[] arrayresult = new int[list.size()];
        int i1 = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i1] = entry.getKey();
            i1++;
        }
        int[] whiteDistinctDescendingHandsNumbers = arrayresult;
        int[] whiteNoRepeatNumbers = PokerUtil.getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers());

        if (blackHandsObj.getCategory().getRanking() < whiteHandsObj.getCategory().getRanking()) {
            winResult = "black wins - " + CATEGORIES[blackHandsObj.getCategory().getRanking()];
        } else if (blackHandsObj.getCategory().getRanking() > whiteHandsObj.getCategory().getRanking()) {
            winResult = "white wins - " + CATEGORIES[whiteHandsObj.getCategory().getRanking()];
        } else {
            if (blackHandsObj.getCategory().getRanking() == 0) { // Straight Flush
                if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
                    String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
                    String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsObj.getCategory().getRanking() == 1) { // Four Of A Kind
                if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteDistinctDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDistinctDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsObj.getCategory().getRanking() == 2) { // Full House
                if (blackHandsObj.getDistinctDescendingHandsNumbers()[0] < whiteDistinctDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDistinctDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackHandsObj.getDistinctDescendingHandsNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsObj.getCategory().getRanking() == 3) { // Flush
                for (int i = 0; i < 5; i++) {
                    if (blackHandsObj.getDescendingHandsNumbers()[i] < whiteHandsObj.getDescendingHandsNumbers()[i]) {
                        String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackHandsObj.getDescendingHandsNumbers()[i] > whiteHandsObj.getDescendingHandsNumbers()[i]) {
                        String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsObj.getCategory().getRanking() == 4) { // Straight
                if (blackHandsObj.getDescendingHandsNumbers()[0] < whiteHandsObj.getDescendingHandsNumbers()[0]) {
                    String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackHandsObj.getDescendingHandsNumbers()[0] > whiteHandsObj.getDescendingHandsNumbers()[0]) {
                    String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsObj.getCategory().getRanking() == 5) { // Three Of A Kind
                if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
                    String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsObj.getCategory().getRanking() == 6) { // Two Pair
                for (int i = 0; i < 2; i++) {
                    if (blackHandsObj.getDescendingRepeatNumbers()[i] < whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                        String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackHandsObj.getDescendingRepeatNumbers()[i] > whiteHandsObj.getDescendingRepeatNumbers()[i]) {
                        String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (blackHandsObj.getDescendingNoRepeatNumbers()[0] < whiteNoRepeatNumbers[0]) {
                        String sig = intNumber(whiteNoRepeatNumbers[0]);
                        winResult = "white wins - high card:" + sig;
                    } else if (blackHandsObj.getDescendingNoRepeatNumbers()[0] > whiteNoRepeatNumbers[0]) {
                        String sig = intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[0]);
                        winResult = "black wins - high card:" + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsObj.getCategory().getRanking() == 7) { // One Pair
                if (blackHandsObj.getDescendingRepeatNumbers()[0] < whiteHandsObj.getDescendingRepeatNumbers()[0]) {
                    String sig = intNumber(whiteHandsObj.getDescendingRepeatNumbers()[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackHandsObj.getDescendingRepeatNumbers()[0] > whiteHandsObj.getDescendingRepeatNumbers()[0]) {
                    String sig = intNumber(blackHandsObj.getDescendingRepeatNumbers()[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (blackHandsObj.getDescendingNoRepeatNumbers()[i] < whiteNoRepeatNumbers[i]) {
                            String sig = intNumber(whiteNoRepeatNumbers[i]);
                            winResult = "white wins - high card:" + sig;
                            break;
                        } else if (blackHandsObj.getDescendingNoRepeatNumbers()[i] > whiteNoRepeatNumbers[i]) {
                            String sig = intNumber(blackHandsObj.getDescendingNoRepeatNumbers()[i]);
                            winResult = "black wins - high card:" + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else { // High Card
                for (int i = 0; i < 5; i++) {
                    if (blackHandsObj.getDescendingHandsNumbers()[i] < whiteHandsObj.getDescendingHandsNumbers()[i]) {
                        String sig = intNumber(whiteHandsObj.getDescendingHandsNumbers()[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackHandsObj.getDescendingHandsNumbers()[i] > whiteHandsObj.getDescendingHandsNumbers()[i]) {
                        String sig = intNumber(blackHandsObj.getDescendingHandsNumbers()[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            }
        }
        return winResult;
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

}
