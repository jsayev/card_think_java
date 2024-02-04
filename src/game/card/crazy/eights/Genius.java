package game.card.crazy.eights;

import game.card.Card;

class Genius extends Player {

    Genius(String name) {
        super(name);
    }

    @Override
    Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    Card searchForMatch(Card prev) {

        return null;
    }
}
