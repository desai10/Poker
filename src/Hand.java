import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Hand {

    final static String  [] handRanking= {"Royal Flush", "Straight Flush", "4 of a Kind", "Full House", "Flush", "Straight", "3 of a kind", "2 Pair", "1 Pair", "High Card"};

    Card cards[] = new Card[5];
    List<Character> suits;

    public Hand(Card [] cards) {
        this.cards = cards;
        suits = new ArrayList<>();
        suits.add('S');
        suits.add('H');
        suits.add('C');
        suits.add('D');
    }

    public int evaluate() {
        int i = 0;
        if(hasRoyalFlush())
            return i;
        i++;
        if(hasStraightFlush())
            return i;
        i++;
        if(hasNOfAKind(4))
            return i;
        i++;
        if(hasFullHouse())
            return i;
        i++;
        if(hasFlush())
            return i;
        i++;
        if(hasStraight())
            return i;
        i++;
        if(hasNOfAKind(3))
            return i;
        i++;
        if(hasNPair(2))
            return i;
        i++;
        if(hasNOfAKind(1))
            return i;
        i++;
        return i;
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

    public boolean hasFlush() {
        int suitCount[] = new int [4];
        for(int i=0;i<4;i++) {
            suitCount[i] = 0;
        }
        for(int i=0;i<5;i++) {
            suitCount[suits.indexOf(cards[i].getSuit())]++;
        }
        return suitCount[0] == 5  || suitCount[1] == 5 || suitCount[2] == 5 || suitCount[3] == 5;
    }

    private boolean hasStraight() {
        return true;
    }

    private boolean hasFullHouse() {
        return hasNPair(1) && hasNOfAKind(3);
    }

    public boolean hasRoyalFlush() {
        boolean hasAce = false;
        for(int i=0;i<5;i++) {
            if(cards[i].getFaceValue() == 'A') {
                hasAce = true;
                break;
            }
        }
        return hasAce && hasStraightFlush();
    }

    private boolean hasStraightFlush() {
        return hasStraight() && hasFlush();
    }

}
