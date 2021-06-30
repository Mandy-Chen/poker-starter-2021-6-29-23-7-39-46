package com.thoughtworks.refactor;

public class Hands {
    private final String hands;

    public Hands(String hands) {
        this.hands = hands;
    }

    public String getHands() {
        return hands;
    }

    Category getCategory() {
        return new Category(PokerUtil.judgeHandCategory(this));
    }

    int[] getDescendingHandsNumbers() {
        return PokerUtil.getDescendingHandsNumbers(this);
    }

    int[] getDescendingRepeatNumbers() {
        return PokerUtil.getDescendingRepeatNumbers(getDescendingHandsNumbers());
    }
}
