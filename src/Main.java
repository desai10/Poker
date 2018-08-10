public class Main {

    public static void main(String [] args) {
        Card cards[] = new Card[5];
        cards[0] = new Card("Diamond", "A" );
        cards[1] = new Card("Diamond", "K");
        cards[2] = new Card("Diamond", "Q");
        cards[3] = new Card("Diamond", "J");
        cards[4] = new Card("Diamond", "10");
        Hand hand = new Hand(cards);
        System.out.println(hand.evaluate());
    }

}
