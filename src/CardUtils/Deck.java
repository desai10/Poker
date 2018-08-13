package CardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck {
    List<Card> allCards=new ArrayList<Card>();
    List<Card> dealtCards = new ArrayList<>();

    public Deck(int numberOfPacks){
        while(numberOfPacks--!=0)
            allCards.addAll(getPack());
    }

    public Deck(int numberOfPacks, int numberOfjokers){
        int numberOfJokersToRemove=2*numberOfPacks-numberOfjokers;
        while(numberOfPacks--!=0)
            allCards.addAll(getPack());
        while(numberOfJokersToRemove--!=0)
            removeJokerFromDeck();
    }

    private void removeJokerFromDeck(){
        Iterator<Card> iter=allCards.iterator();
        while(iter.hasNext()){
            Card c=iter.next();
            if(c.getPip()== Utils.Pip.Joker)
                iter.remove();
            break;
        }
    }

    public void shuffle(){
        Collections.shuffle(allCards);
    }

    public void resetDeck() {
        allCards.addAll(dealtCards);
        dealtCards.clear();
    }

    public List<List<Card>> deal(int numberOfPlayers){
        this.shuffle();
        List<List<Card>> gameSet=new ArrayList<List<Card>>();
        Iterator<Card> iter=allCards.iterator();
        for(int i=0; i<numberOfPlayers; i++)
            gameSet.add(new ArrayList<Card>());
        int player=0;
        while(iter.hasNext()){
            gameSet.get(player).add(iter.next());
            player=(player+1)%numberOfPlayers;
        }
        System.out.println(gameSet);
        for(List<Card> listCard : gameSet) {
            allCards.removeAll(listCard);
            dealtCards.addAll(listCard);
        }
        return gameSet;
    }

    public List<List<Card>> deal(int numberOfPlayers, int cardsPerPlayer){
        if(cardsPerPlayer*numberOfPlayers>allCards.size())
            return null;
        this.shuffle();
        List<List<Card>> gameSet=new ArrayList<List<Card>>();
        Iterator<Card> iter=allCards.iterator();
        for(int i=0; i<numberOfPlayers; i++)
            gameSet.add(new ArrayList<Card>());
        for(int i=0; i<numberOfPlayers && iter.hasNext(); i++) {
            int cardsdealt=0;
            while(cardsdealt<cardsPerPlayer) {
                gameSet.get(i).add(iter.next());
                cardsdealt++;
            }
        }
        System.out.println(gameSet);
        for(List<Card> listCard : gameSet) {
            allCards.removeAll(listCard);
            dealtCards.addAll(listCard);
        }
        return gameSet;
    }

    public static List<Card> getPack() {
        List<Card> cards = new ArrayList<>();
        Utils.Suits suitArray[] = Utils.Suits.values();
        Utils.Pip pipArray[]=Utils.Pip.values();
        for(int i=1;i<suitArray.length;i++)
            for(int j=1;j<pipArray.length;j++)
                cards.add(new Card(suitArray[i],pipArray[j]));
        cards.add(new Card(suitArray[0],pipArray[0]));
        cards.add(new Card(suitArray[0],pipArray[0]));
        return cards;
    }

    public void setWildCard(Utils.Pip pip) {
        for(Card card : allCards) {
            if(card.getPip().equals(pip)) {
                card.setWildCard(true);
            }
        }
    }

    public void setWildCard(List<Card> wildCards) {
        for( Card wildC : wildCards) {
            for (Card card : allCards) {
                if(card.equals(wildC)) {
                    card.setWildCard(true);
                    break;
                }
            }
        }
    }

}
