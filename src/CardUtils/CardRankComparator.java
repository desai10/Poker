package CardUtils;

import java.util.Comparator;

public class CardRankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return  o1.getPip().compareTo(o2.getPip());
    }
}
