import CardUtils.Deck;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) {
            Deck d = new Deck(1);

        Hand hand = new Hand( d.deal(1,5).get(0));
        System.out.println(hand.evaluate());
    }

}
