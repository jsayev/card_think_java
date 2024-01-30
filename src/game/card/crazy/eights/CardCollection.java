package game.card.crazy.eights;

import game.card.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jsayev
 */
class CardCollection {
    private final String label;
    private final ArrayList<Card> cards;

    CardCollection(String label) {
        this.label = label;
        this.cards = new ArrayList<>();
    }

    void addCard(Card card) {
        cards.add(card);
    }

    /**
     * @param i index of Card to be removed from cards
     * @return removed card object
     */
    Card popCard(int i) {
        return cards.remove(i);
    }

    Card popCard() {
        int i = cards.size() - 1;
        return popCard(i);
    }

    boolean isEmpty() {
        return cards.isEmpty();
    }

    int size() {
        return cards.size();
    }

    Card getCard(int i) {
        return cards.get(i);
    }

    Card getLastCard() {
        int i = cards.size() - 1;
        return cards.get(i);
    }

    void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(i, cards.size());
            swapCards(i, j);
        }
    }

    void deal(CardCollection that, int n) {
        for (int i = 0; i < n; i++) {
            Card card = popCard();
            that.addCard(card);
        }
    }

    void dealAll(CardCollection that) {
        int n = cards.size();
        deal(that, n);
    }

    String getLabel() {
        return label;
    }
}
