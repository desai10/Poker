package CardUtils;

import java.util.Comparator;

public class CardSequenceComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if(o1.getSuit().compareTo(o2.getSuit())==0){
            return o1.getPip().compareTo(o2.getPip());
        }
        return o1.getSuit().compareTo(o2.getSuit());
    }
}
