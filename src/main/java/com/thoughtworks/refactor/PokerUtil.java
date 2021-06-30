package com.thoughtworks.refactor;

import java.util.*;

public class PokerUtil {
    // Convert to numbers and sort them from largest to smallest
    static int[] getDescendingHandsNumbers(Hands hands) {
        int[] number = new int[5];
        String[] strArray = hands.getHands().split("");
        int i;
        for (i = 0; i < 5; i++) {
            String c = strArray[i * 3];
            switch (c) {
                case "T":
                    number[i] = 10;
                    break;
                case "J":
                    number[i] = 11;
                    break;
                case "Q":
                    number[i] = 12;
                    break;
                case "K":
                    number[i] = 13;
                    break;
                case "A":
                    number[i] = 14;
                    break;
                default:
                    number[i] = Integer.valueOf(c);
                    break;
            }
        }

        Arrays.sort(number);
        int[] renumber = new int[number.length];
        for (i = 0; i < number.length; i++) {
            renumber[i] = number[number.length - i - 1];
        }
        return renumber;
    }

    // judge the type of card
    static String judgeHandCategory(Hands hands) {
        String type = "";
        if (isStraightFlush(hands.getHands())) {
            type = "StraightFlush";
        } else if (isStraight(hands.getHands())) {
            type = "Straight";
        } else if (isFlush(hands.getHands())) {
            type = "Flush";
        } else if (isHighCard(hands.getHands())) {
            type = "HighCard";
        } else if (isOnePair(hands.getHands())) {
            type = "OnePair";
        } else if (isTwoPair(hands.getHands())) {
            type = "TwoPair";
        } else if (isThreeOfAKind(hands.getHands())) {
            type = "ThreeOfAKind";
        } else if (isFourOfAKind(hands.getHands())) {
            type = "FourOfAKind";
        } else {
            type = "FullHouse";
        }

        return type;
    }

    private static boolean isFourOfAKind(String hands) {
        final int[] descendingCardNumbers = getDescendingHandsNumbers(new Hands(hands));
        return descendingCardNumbers[0] != descendingCardNumbers[1] || descendingCardNumbers[3] != descendingCardNumbers[4];
    }

    private static boolean isThreeOfAKind(String hands) {
        return countDistinctNumbers(hands) == 3;
    }

    private static boolean isTwoPair(String hands) {
        final int distinctNumbersCount = countDistinctNumbers(hands);
        final int[] descendingCardNumbers = getDescendingHandsNumbers(new Hands(hands));
        return distinctNumbersCount == 3 && ((descendingCardNumbers[0] == descendingCardNumbers[1] && descendingCardNumbers[2] == descendingCardNumbers[3]) || (descendingCardNumbers[1] == descendingCardNumbers[2] && descendingCardNumbers[3] == descendingCardNumbers[4]) || (descendingCardNumbers[0] == descendingCardNumbers[1] && descendingCardNumbers[3] == descendingCardNumbers[4]) && distinctNumbersCount == 3);
    }

    private static boolean isOnePair(String hands) {
        return countDistinctNumbers(hands) == 4;
    }

    private static boolean isHighCard(String hands) {
        return countDistinctNumbers(hands) == 5;
    }

    private static boolean isFlush(String hands) {
        return countSuits(hands) == 1 && countDistinctNumbers(hands) == 5;
    }

    private static boolean isStraight(String hands) {
        final int[] descendingCardNumbers = getDescendingHandsNumbers(new Hands(hands));
        return descendingCardNumbers[0] - descendingCardNumbers[4] == 4 && (countDistinctNumbers(hands) == 5);
    }

    private static boolean isStraightFlush(String hands) {
        final int[] descendingCardNumbers = getDescendingHandsNumbers(new Hands(hands));
        return (descendingCardNumbers[0] - descendingCardNumbers[4] == 4) && (countSuits(hands) == 1) && (countDistinctNumbers(hands) == 5);
    }

    private static int countSuits(String hands) {
        return getSuits(hands).size();
    }

    private static int countDistinctNumbers(String hands) {
        int i;
        HashSet<Integer> distinctNumbers = new HashSet<Integer>();
        for (i = 0; i < 5; i++) {
            distinctNumbers.add(getDescendingHandsNumbers(new Hands(hands))[i]);
        }
        return distinctNumbers.size();
    }

    private static HashSet<String> getSuits(String hands) {
        String[] strArray = hands.split("");
        int i;
        String[] color = new String[5];
        for (i = 0; i < 5; i++) {
            color[i] = strArray[i * 3 + 1];
        }
        HashSet<String> suits = new HashSet<String>();
        for (i = 0; i < 5; i++) {
            suits.add(color[i]);
        }
        return suits;
    }

    static String intNumber(int i) {
        String[] strNumber = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
        return strNumber[i - 2];
    }

    static int[] getDistinctDescendingHandsNumbers(int[] number) {
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
