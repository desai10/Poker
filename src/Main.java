import java.util.List;

public class Main {

    public static void main(String [] args) {
        Deck deck = new Deck(5,false);
        List<Card> cards = deck.getNCards(5);
        Hand hand = new Hand(cards);
        System.out.println(hand.evaluate());
    }

}
