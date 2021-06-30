package com.thoughtworks.refactor;

import java.util.*;

public class Poker {

    public static final String[] CATEGORIES = {"StraightFlush", "FourOfAKind", "FullHouse", "Flush", "Straight", "ThreeOfAKind", "TwoPair", "OnePair", "HighCard"};

    public String compareResult(String blackHands, String whiteHands) {
        String winResult = "";
        final Hands blackHandsObj = new Hands(blackHands);
        int[] blackDescendingHandsNumbers = blackHandsObj.getDescendingHandsNumbers();
        final Category blackCategory = blackHandsObj.getCategory();
        int blackHandsCategoryRanking = blackCategory.getRanking();
        int[] blackRepeatNumbers = blackHandsObj.getDescendingRepeatNumbers();
        int[] blackDistinctDescendingHandsNumbers = getDistinctDescendingHandsNumbers(blackDescendingHandsNumbers);
        int[] blackNoRepeatNumbers = getDescendingNoRepeatNumbers(blackDescendingHandsNumbers);

        final Hands whiteHandsObj = new Hands(whiteHands);
        int[] whiteDescendingHandsNumbers = whiteHandsObj.getDescendingHandsNumbers();
        final Category whiteCategory = whiteHandsObj.getCategory();
        int whiteHandsCategoryRanking = whiteCategory.getRanking();
        int[] whiteRepeatNumbers = whiteHandsObj.getDescendingRepeatNumbers();
        int[] whiteDistinctDescendingHandsNumbers = getDistinctDescendingHandsNumbers(whiteDescendingHandsNumbers);
        int[] whiteNoRepeatNumbers = getDescendingNoRepeatNumbers(whiteDescendingHandsNumbers);

        if (blackHandsCategoryRanking < whiteHandsCategoryRanking) {
            winResult = "black wins - " + CATEGORIES[blackHandsCategoryRanking];
        } else if (blackHandsCategoryRanking > whiteHandsCategoryRanking) {
            winResult = "white wins - " + CATEGORIES[whiteHandsCategoryRanking];
        } else {
            if (blackHandsCategoryRanking == 0) { // Straight Flush
                if (blackDescendingHandsNumbers[0] < whiteDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackDescendingHandsNumbers[0] > whiteDescendingHandsNumbers[0]) {
                    String sig = intNumber(blackDescendingHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsCategoryRanking == 1) { // Four Of A Kind
                if (blackDistinctDescendingHandsNumbers[0] < whiteDistinctDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDistinctDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackDistinctDescendingHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRanking == 2) { // Full House
                if (blackDistinctDescendingHandsNumbers[0] < whiteDistinctDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDistinctDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackDistinctDescendingHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRanking == 3) { // Flush
                for (int i = 0; i < 5; i++) {
                    if (blackDescendingHandsNumbers[i] < whiteDescendingHandsNumbers[i]) {
                        String sig = intNumber(whiteDescendingHandsNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackDescendingHandsNumbers[i] > whiteDescendingHandsNumbers[i]) {
                        String sig = intNumber(blackDescendingHandsNumbers[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsCategoryRanking == 4) { // Straight
                if (blackDescendingHandsNumbers[0] < whiteDescendingHandsNumbers[0]) {
                    String sig = intNumber(whiteDescendingHandsNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackDescendingHandsNumbers[0] > whiteDescendingHandsNumbers[0]) {
                    String sig = intNumber(blackDescendingHandsNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    winResult = "tie";
                }
            } else if (blackHandsCategoryRanking == 5) { // Three Of A Kind
                if (blackRepeatNumbers[0] < whiteRepeatNumbers[0]) {
                    String sig = intNumber(whiteRepeatNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else {
                    String sig = intNumber(blackRepeatNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                }
            } else if (blackHandsCategoryRanking == 6) { // Two Pair
                for (int i = 0; i < 2; i++) {
                    if (blackRepeatNumbers[i] < whiteRepeatNumbers[i]) {
                        String sig = intNumber(whiteRepeatNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackRepeatNumbers[i] > whiteRepeatNumbers[i]) {
                        String sig = intNumber(blackRepeatNumbers[i]);
                        winResult = "black wins - high card:" + sig;
                        break;
                    }
                }
                if (winResult == "") {
                    if (blackNoRepeatNumbers[0] < whiteNoRepeatNumbers[0]) {
                        String sig = intNumber(whiteNoRepeatNumbers[0]);
                        winResult = "white wins - high card:" + sig;
                    } else if (blackNoRepeatNumbers[0] > whiteNoRepeatNumbers[0]) {
                        String sig = intNumber(blackNoRepeatNumbers[0]);
                        winResult = "black wins - high card:" + sig;
                    } else {
                        winResult = "tie";
                    }
                }
            } else if (blackHandsCategoryRanking == 7) { // One Pair
                if (blackRepeatNumbers[0] < whiteRepeatNumbers[0]) {
                    String sig = intNumber(whiteRepeatNumbers[0]);
                    winResult = "white wins - high card:" + sig;
                } else if (blackRepeatNumbers[0] > whiteRepeatNumbers[0]) {
                    String sig = intNumber(blackRepeatNumbers[0]);
                    winResult = "black wins - high card:" + sig;
                } else {
                    for (int i = 0; i < 3; i++) {
                        if (blackNoRepeatNumbers[i] < whiteNoRepeatNumbers[i]) {
                            String sig = intNumber(whiteNoRepeatNumbers[i]);
                            winResult = "white wins - high card:" + sig;
                            break;
                        } else if (blackNoRepeatNumbers[i] > whiteNoRepeatNumbers[i]) {
                            String sig = intNumber(blackNoRepeatNumbers[i]);
                            winResult = "black wins - high card:" + sig;
                            break;
                        } else {
                            winResult = "tie";
                        }
                    }
                }
            } else { // High Card
                for (int i = 0; i < 5; i++) {
                    if (blackDescendingHandsNumbers[i] < whiteDescendingHandsNumbers[i]) {
                        String sig = intNumber(whiteDescendingHandsNumbers[i]);
                        winResult = "white wins - high card:" + sig;
                        break;
                    } else if (blackDescendingHandsNumbers[i] > whiteDescendingHandsNumbers[i]) {
                        String sig = intNumber(blackDescendingHandsNumbers[i]);
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

    private int[] getDescendingNoRepeatNumbers(int[] blackDescendingHandsNumbers) {
        return PokerUtil.noOrRepeatNumber(blackDescendingHandsNumbers, 1);
    }

    private String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    private int[] getDistinctDescendingHandsNumbers(int[] number) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < number.length; i++) {
            if (map.get(number[i]) != null) {
                map.put(number[i], map.get(number[i]) + 1);
            } else {
                map.put(number[i], 1);
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
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            arrayresult[i] = entry.getKey();
            i++;
        }
        return arrayresult;
    }

}
