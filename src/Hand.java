import java.util.List;

public class Hand {

    Card cards[] = new Card[5];

    public Hand(Card [] cards) {
        this.cards = cards;
    }

    public int evaluate() {
        return 0;
    }

    private boolean hasPair() {
        return false;
    }

    private boolean hasNOfAKind(int n) {
        return false;
    }

    private boolean hasFlush() {
        return false;
    }

    private boolean hasStraight() {
        return false;
    }

    private boolean hasFullHouse() {
        return hasPair() && hasNOfAKind(3);
    }

    private boolean hasRoyalFlush() {
        return false;
    }

    private boolean hasStraightFlush() {
        return hasStraight() && hasFlush();
    }

}
