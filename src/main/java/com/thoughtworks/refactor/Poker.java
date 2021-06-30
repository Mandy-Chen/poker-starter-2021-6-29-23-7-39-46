package com.thoughtworks.refactor;

import java.util.*;

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
            winResult = compareFullHouse(blackHandsObj, whiteHandsObj);
        } else if (blackHandsObj.getCategory().judgeHandsCategoryRanking() == 3) { // Flush
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

    private String compareOnePair( Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult="";
        if (getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else if (getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] > getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        } else {
            for (int i = 0; i < 3; i++) {
                if (getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] < getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                    String sig = PokerUtil.intNumber(getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]);
                    winResult = "white wins - high card:" + sig;
                    break;
                } else if (getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] > getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                    String sig = PokerUtil.intNumber(getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i]);
                    winResult = "black wins - high card:" + sig;
                    break;
                } else {
                    winResult = "tie";
                }
            }
        }
        return winResult;
    }

    private String compareTwoPair( Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult = "";
        for (int i = 0; i < 2; i++) {
            if (getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] < getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]);
                winResult = "white wins - high card:" + sig;
                break;
            } else if (getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i] > getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[i]) {
                String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[i]);
                winResult = "black wins - high card:" + sig;
                break;
            }
        }
        if (winResult == "") {
            if (getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
                String sig = PokerUtil.intNumber(getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
                winResult = "white wins - high card:" + sig;
            } else if (getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] > getDescendingNoRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
                String sig = PokerUtil.intNumber(getDescendingNoRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
                winResult = "black wins - high card:" + sig;
            } else {
                winResult = "tie";
            }
        }
        return winResult;
    }

    private String compareThreeOfAKind(Hands blackHandsObj, Hands whiteHandsObj) {
        String winResult;
        if (getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0] < getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]) {
            String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(whiteHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "white wins - high card:" + sig;
        } else {
            String sig = PokerUtil.intNumber(getDescendingRepeatNumbers(blackHandsObj.getDescendingHandsNumbers())[0]);
            winResult = "black wins - high card:" + sig;
        }
        return winResult;
    }

    private String compareStraight(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareFlush( Hands blackHandsObj, Hands whiteHandsObj) {
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

    private String compareFullHouse(Hands blackHandsObj, Hands whiteHandsObj) {
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

    private int[] getDescendingNoRepeatNumbers(int[] blackDescendingHandsNumbers) {
        return noOrRepeatNumber(blackDescendingHandsNumbers, 1);
    }

    private int[] getDescendingRepeatNumbers(int[] blackDescendingHandsNumbers) {
        return noOrRepeatNumber(blackDescendingHandsNumbers, 0);
    }

    // First get the number of occurrences of each element in the array,
    // then calculate the number of occurrences greater than 1 and the number of occurrences equal to 1.
    private int[] noOrRepeatNumber(int[] number, int flag) {
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
        int[] repeatnumber = new int[list.size()];
        int[] norepeatnumber = new int[list.size()];
        int i = 0;
        if (flag == 0) {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() > 1) {
                    repeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : list) {
                if (entry.getValue() == 1) {
                    norepeatnumber[i] = entry.getKey();
                    i++;
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        if (flag == 0) {
            for (i = 0; i < repeatnumber.length; i++) {
                hashSet.add(repeatnumber[i]);
            }
        } else {
            for (i = 0; i < norepeatnumber.length; i++) {
                hashSet.add(norepeatnumber[i]);
            }
        }
        hashSet.remove(0);
        int[] result = new int[hashSet.size()];
        i = 0;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            result[i] = iterator.next();
            i++;
        }
        int[] reResult = new int[result.length];
        for (i = 0; i < result.length; i++) {
            reResult[i] = result[result.length - i - 1];
        }
        return reResult;
    }

}
