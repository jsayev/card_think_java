package game.card.crazy.eights;

import game.card.Card;

/**
 * @author jsayev
 */
class Deck extends CardCollection {
    Deck(String label) {
        super(label);
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                addCard(new Card(rank, suit));
            }
        }
    }
}
