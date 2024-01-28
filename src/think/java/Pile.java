package think.java;

import java.util.ArrayList;
import java.util.List;

class Pile {
    private final ArrayList<Card> cards;

    Pile() {
        this.cards = new ArrayList<>();
    }

    Card popCard() {
        if (!this.cards.isEmpty())
            return this.cards.removeFirst();
        return null;
    }

    void addCard(Card card) {
        this.cards.add(card);
    }

    boolean isEmpty() {
        return this.cards.isEmpty();
    }

    void addDeck(Deck deck) {
        for (Card card : deck.getCards()) {
            this.cards.add(card);
        }
    }

    List<Card> draw4Cards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            cards.add(this.popCard());
        }
        return cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
