public class Main {

    public static void main(String [] args) {
        Card cards[] = new Card[5];
        cards[0] = new Card("Diamond", "A" );
        cards[1] = new Card("Spade", "2");
        cards[2] = new Card("Heart", "3");
        cards[3] = new Card("Diamond", "4");
        cards[4] = new Card("Diamond", "5");
        Hand hand = new Hand(cards);
        System.out.println(hand.evaluate());
    }

}
