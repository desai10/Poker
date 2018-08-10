import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Hand {


    Card cards[] = new Card[5];

    public Hand(Card [] cards) {
        this.cards = cards;
    }

    public int evaluate() {
        return 0;
    }

    private boolean hasNPair(int n) {
        int pairCount = 0;
        int count[] = new int[15];
        for(int i=0;i<cards.length;i++) {
            count[cards[i].getValue()]++;
        }
        for(int i=0;i<15;i++)
            if(count[i]==2)
                pairCount++;
        return pairCount==n;
    }

    private boolean hasNOfAKind(int n) {
        int count[] = new int[15];
        for(int i=0;i<cards.length;i++) {
            count[cards[i].getValue()]++;
        }
        for(int i=0;i<15;i++)
            if(count[i]==n)
                return true;
        return false;
    }

    private boolean hasFlush() {
        return false;
    }

    private boolean hasStraight() {
        return false;
    }

    private boolean hasFullHouse() {
        return hasNPair(1) && hasNOfAKind(3);
    }

    private boolean hasRoyalFlush() {
        return false;
    }

    private boolean hasStraightFlush() {
        return hasStraight() && hasFlush();
    }

}
