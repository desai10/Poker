import java.util.ArrayList;
import java.util.Arrays;

public class Card implements Comparable<Card> {
    private String suit = new String();
    private String value = new String();
    private int rank;
    boolean isJoker;

    final int[] ranks = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
    final ArrayList<String> values = new ArrayList<>(
            Arrays.asList("Joker", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));

    Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.rank = calcRank(value);
        setJoker(value == "Joker");
    }

    public int calcRank(String value) {
        return ranks[values.indexOf(value)];
    }

    public int getRank() {
        return rank;
    }

    public void setJoker(boolean isJoker) {
        this.isJoker = isJoker;
    }

    public boolean isJoker() {
        return isJoker;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        // TODO Auto-generated method stub
        return (this.rank - o.rank);

    }

    public boolean isSameSuit(Card a, Card b) {
        return a.getSuit() == b.getSuit();

    }
}