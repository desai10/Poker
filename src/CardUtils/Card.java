package CardUtils;

public class Card {

    Utils.Suits suit;
    Utils.Pip pip;
    boolean isWildCard;

    static CardSequenceComparator cardSequenceComparator = new CardSequenceComparator();
    static CardRankComparator cardRankComparator = new CardRankComparator();

    public Card(String suit, String pip) {
        this.suit = Utils.Suits.valueOf(suit);
        this.pip = Utils.Pip.valueOf(pip);
        isWildCard = false;
    }

    public Card(Utils.Suits suit, Utils.Pip pip) {
        this.suit = suit;
        this.pip = pip;
        isWildCard = false;
    }

    public void setWildCard(boolean wildCard) {
        isWildCard = wildCard;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", pip=" + pip +
                ", isWildCard=" + isWildCard +
                '}';
    }

    public Utils.Suits getSuit() {
        return suit;
    }

    public Utils.Pip getPip() {
        return pip;
    }

    public boolean isWildCard() {
        return isWildCard;
    }

    public static CardSequenceComparator getCardSequenceComparator() {
        return cardSequenceComparator;
    }

    public static CardRankComparator getCardRankComparator() {
        return cardRankComparator;
    }

}
