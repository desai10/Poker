public class Main {

    public static void main(String [] args) {
        Card cards[] = new Card[5];
        cards[0] = new Card('A', 'D');
        cards[1] = new Card('K', 'D');
        cards[2] = new Card('Q', 'S');
        cards[3] = new Card('J', 'D');
        cards[4] = new Card('1', 'D');
        Hand hand = new Hand(cards);
        System.out.println(hand.hasRoyalFlush());
    }

}
