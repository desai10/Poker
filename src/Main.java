import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("Diamond", "A" ));
        cards.add(new Card("Spade", "2"));
        cards.add(new Card("Heart", "3"));
        cards.add(new Card("Diamond", "4"));
        cards.add(new Card("Diamond", "5"));
        Hand hand = new Hand(cards);
        System.out.println(hand.evaluate());
    }

}
