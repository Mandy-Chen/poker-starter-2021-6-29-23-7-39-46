package com.thoughtworks.refactor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerDifferentCardTypeTest {

    private static final String STRAIGHT_FLUSH = "A2 K2 Q2 J2 T2";
    private static final String FOUR_OF_A_KIND = "91 92 93 94 53";
    private static final String FULL_HOUSE = "A1 A3 A4 K1 K3";
    private static final String FLUSH = "A1 K1 Q1 J1 91";
    private static final String STRAIGHT = "A1 K1 Q1 J1 T3";
    private static final String THREE_OF_A_KIND = "A1 A3 A4 K1 Q3";
    private static final String TWO_PAIR = "A1 A3 K4 K1 Q3";
    private static final String ONE_PAIR = "A1 A3 K4 Q1 J3";
    private static final String HIGH_CARD = "A1 K3 Q4 J1 83";
    public static final String BLACK_WINS_STRAIGHT_FLUSH = "black wins - StraightFlush";
    public static final String WHITE_WINS_STRAIGHT_FLUSH = "white wins - StraightFlush";
    public static final String BLACK_WINS_FOUR_OF_A_KIND = "black wins - FourOfAKind";
    public static final String WHITE_WINS_FOUR_OF_A_KIND = "white wins - FourOfAKind";
    public static final String BLACK_WINS_FULL_HOUSE = "black wins - FullHouse";
    public static final String WHITE_WINS_FULL_HOUSE = "white wins - FullHouse";
    public static final String BLACK_WINS_FLUSH = "black wins - Flush";
    public static final String WHITE_WINS_FLUSH = "white wins - Flush";
    public static final String BLACK_WINS_THREE_OF_A_KIND = "black wins - ThreeOfAKind";
    public static final String WHITE_WINS_THREE_OF_A_KIND = "white wins - ThreeOfAKind";
    public static final String BLACK_WINS_TWO_PAIR = "black wins - TwoPair";
    public static final String WHITE_WINS_TWO_PAIR = "white wins - TwoPair";
    public static final String BLACK_WINS_ONE_PAIR = "black wins - OnePair";
    public static final String WHITE_WINS_ONE_PAIR = "white wins - OnePair";

    @DisplayName("The one with StraightFlush (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringStraightFlushAndWorseCardTypeProvider")
    void test_compare_StraightFlush_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringStraightFlushAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(STRAIGHT_FLUSH, FOUR_OF_A_KIND, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(FOUR_OF_A_KIND, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, FULL_HOUSE, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(FULL_HOUSE, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, FLUSH, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(FLUSH, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, STRAIGHT, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, THREE_OF_A_KIND, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(THREE_OF_A_KIND, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, TWO_PAIR, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(TWO_PAIR, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, ONE_PAIR, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(ONE_PAIR, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH),
                Arguments.of(STRAIGHT_FLUSH, HIGH_CARD, BLACK_WINS_STRAIGHT_FLUSH),
                Arguments.of(HIGH_CARD, STRAIGHT_FLUSH, WHITE_WINS_STRAIGHT_FLUSH)
        );
    }

    @DisplayName("The one with FourOfAKind (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFourOfAKindAndWorseCardTypeProvider")
    void test_compare_FourOfAKind_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFourOfAKindAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(FOUR_OF_A_KIND, FULL_HOUSE, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(FULL_HOUSE, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, FLUSH, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(FLUSH, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, STRAIGHT, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(STRAIGHT, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, THREE_OF_A_KIND, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(THREE_OF_A_KIND, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, TWO_PAIR, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(TWO_PAIR, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, ONE_PAIR, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(ONE_PAIR, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND),
                Arguments.of(FOUR_OF_A_KIND, HIGH_CARD, BLACK_WINS_FOUR_OF_A_KIND),
                Arguments.of(HIGH_CARD, FOUR_OF_A_KIND, WHITE_WINS_FOUR_OF_A_KIND)
        );
    }

    @DisplayName("The one with FullHouse (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFullHouseAndWorseCardTypeProvider")
    void test_compare_FullHouse_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFullHouseAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(FULL_HOUSE, FLUSH, BLACK_WINS_FULL_HOUSE),
                Arguments.of(FLUSH, FULL_HOUSE, WHITE_WINS_FULL_HOUSE),
                Arguments.of(FULL_HOUSE, STRAIGHT, BLACK_WINS_FULL_HOUSE),
                Arguments.of(STRAIGHT, FULL_HOUSE, WHITE_WINS_FULL_HOUSE),
                Arguments.of(FULL_HOUSE, THREE_OF_A_KIND, BLACK_WINS_FULL_HOUSE),
                Arguments.of(THREE_OF_A_KIND, FULL_HOUSE, WHITE_WINS_FULL_HOUSE),
                Arguments.of(FULL_HOUSE, TWO_PAIR, BLACK_WINS_FULL_HOUSE),
                Arguments.of(TWO_PAIR, FULL_HOUSE, WHITE_WINS_FULL_HOUSE),
                Arguments.of(FULL_HOUSE, ONE_PAIR, BLACK_WINS_FULL_HOUSE),
                Arguments.of(ONE_PAIR, FULL_HOUSE, WHITE_WINS_FULL_HOUSE),
                Arguments.of(FULL_HOUSE, HIGH_CARD, BLACK_WINS_FULL_HOUSE),
                Arguments.of(HIGH_CARD, FULL_HOUSE, WHITE_WINS_FULL_HOUSE)
        );
    }

    @DisplayName("The one with Flush (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringFlushAndWorseCardTypeProvider")
    void test_compare_Flush_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringFlushAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(FLUSH, STRAIGHT, BLACK_WINS_FLUSH),
                Arguments.of(STRAIGHT, FLUSH, WHITE_WINS_FLUSH),
                Arguments.of(FLUSH, THREE_OF_A_KIND, BLACK_WINS_FLUSH),
                Arguments.of(THREE_OF_A_KIND, FLUSH, WHITE_WINS_FLUSH),
                Arguments.of(FLUSH, TWO_PAIR, BLACK_WINS_FLUSH),
                Arguments.of(TWO_PAIR, FLUSH, WHITE_WINS_FLUSH),
                Arguments.of(FLUSH, ONE_PAIR, BLACK_WINS_FLUSH),
                Arguments.of(ONE_PAIR, FLUSH, WHITE_WINS_FLUSH),
                Arguments.of(FLUSH, HIGH_CARD, BLACK_WINS_FLUSH),
                Arguments.of(HIGH_CARD, FLUSH, WHITE_WINS_FLUSH)
        );
    }

    @DisplayName("The one with Straight (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringStraightAndWorseCardTypeProvider")
    void test_compare_Straight_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringStraightAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(STRAIGHT, THREE_OF_A_KIND, "black wins - Straight"),
                Arguments.of(THREE_OF_A_KIND, STRAIGHT, "white wins - Straight"),
                Arguments.of(STRAIGHT, TWO_PAIR, "black wins - Straight"),
                Arguments.of(TWO_PAIR, STRAIGHT, "white wins - Straight"),
                Arguments.of(STRAIGHT, ONE_PAIR, "black wins - Straight"),
                Arguments.of(ONE_PAIR, STRAIGHT, "white wins - Straight"),
                Arguments.of(STRAIGHT, HIGH_CARD, "black wins - Straight"),
                Arguments.of(HIGH_CARD, STRAIGHT, "white wins - Straight")
        );
    }

    @DisplayName("The one with ThreeOfAKind (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringThreeOfAKindAndWorseCardTypeProvider")
    void test_compare_ThreeOfAKind_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringThreeOfAKindAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(THREE_OF_A_KIND, TWO_PAIR, BLACK_WINS_THREE_OF_A_KIND),
                Arguments.of(TWO_PAIR, THREE_OF_A_KIND, WHITE_WINS_THREE_OF_A_KIND),
                Arguments.of(THREE_OF_A_KIND, ONE_PAIR, BLACK_WINS_THREE_OF_A_KIND),
                Arguments.of(ONE_PAIR, THREE_OF_A_KIND, WHITE_WINS_THREE_OF_A_KIND),
                Arguments.of(THREE_OF_A_KIND, HIGH_CARD, BLACK_WINS_THREE_OF_A_KIND),
                Arguments.of(HIGH_CARD, THREE_OF_A_KIND, WHITE_WINS_THREE_OF_A_KIND)
        );
    }

    @DisplayName("The one with TwoPair (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringTwoPairAndWorseCardTypeProvider")
    void test_compare_TwoPair_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringTwoPairAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(TWO_PAIR, ONE_PAIR, BLACK_WINS_TWO_PAIR),
                Arguments.of(ONE_PAIR, TWO_PAIR, WHITE_WINS_TWO_PAIR),
                Arguments.of(TWO_PAIR, HIGH_CARD, BLACK_WINS_TWO_PAIR),
                Arguments.of(HIGH_CARD, TWO_PAIR, WHITE_WINS_TWO_PAIR)
        );
    }

    @DisplayName("The one with OnePair (better card type) should win")
    @ParameterizedTest(name = "should return {2} when compare black: {0} and white: {1}")
    @MethodSource("stringOnePairAndWorseCardTypeProvider")
    void test_compare_OnePair_with_worse_card_type(String black, String white, String expectResult) {
        String actualResult = new Poker().compareResult(black, white);

        assertThat(actualResult).isEqualTo(expectResult);
    }

    static Stream<Arguments> stringOnePairAndWorseCardTypeProvider() {
        return Stream.of(
                Arguments.of(ONE_PAIR, HIGH_CARD, BLACK_WINS_ONE_PAIR),
                Arguments.of(HIGH_CARD, ONE_PAIR, WHITE_WINS_ONE_PAIR)
        );
    }


}
