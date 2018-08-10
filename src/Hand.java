import java.lang.reflect.Array;
import java.util.*;

public class Hand {

    final static String  [] handRanking= {"Royal Flush", "Straight Flush", "4 of a Kind", "Full House", "Flush", "Straight", "3 of a kind", "2 Pair", "1 Pair", "High Card"};

    List<Card> cards;
    List<String> suits = new ArrayList<>(Arrays.asList("Diamond", "Heart", "Spade", "Clubs"));

    public Hand(List<Card> cards) {
        this.cards = cards;
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
        for(int i=0;i<cards.size();i++) {
            count[cards.get(i).getRank()]++;
        }
        for(int i=0;i<15;i++)
            if(count[i]==2)
                pairCount++;
        return pairCount==n;
    }

    private boolean hasNOfAKind(int n) {
        int count[] = new int[15];
        for(int i=0;i<cards.size();i++) {
            count[cards.get(i).getRank()]++;
        }
        for(int i=0;i<15;i++)
            if(count[i]==n)
                return true;
        return false;
    }

    private boolean hasFlush() {
        int suitCount[] = new int [4];
        for(int i=0;i<4;i++) {
            suitCount[i] = 0;
        }
        for(int i=0;i<5;i++) {
            suitCount[suits.indexOf(cards.get(i).getSuit())]++;
        }
        return suitCount[0] == 5  || suitCount[1] == 5 || suitCount[2] == 5 || suitCount[3] == 5;
    }

    private boolean hasStraight() {
        Collections.sort(cards);
        int start=cards.get(0).getRank();
        int i=0;
        if(start==1 && cards.get(i).getRank()==10) {
            i = 1;
            start=10;
        }
        for(;i<cards.size(); i++){
            if(cards.get(i).getRank()>start+1)
                return false;
            start=cards.get(i).getRank();
        }
        return true;
    }

    private boolean hasFullHouse() {
        return hasNPair(1) && hasNOfAKind(3);
    }

    private boolean hasRoyalFlush() {
        boolean hasAce = false;
        for(int i=0;i<5;i++) {
            if(cards.get(i).getValue().equals("A")) {
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
