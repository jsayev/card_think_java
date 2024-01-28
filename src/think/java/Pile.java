package think.java;

import java.util.ArrayList;

class Pile {
    private final ArrayList<Card> cards;

    Pile() {
        this.cards = new ArrayList<>();
    }

    Card popCard() {
        return this.cards.removeFirst();
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
}
