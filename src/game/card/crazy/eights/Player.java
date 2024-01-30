package game.card.crazy.eights;

import game.card.Card;

/**
 * @author jsayev
 */
class Player {
    private final String name;
    private final Hand hand;


    Player(String name) {
        this.name = name;
        this.hand = new Hand(name);
    }

    Card play(Eights eights, Card prev) {
        Card card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    int score() {
        int score = 0;
        for (int i = 0; i < hand.size(); i++) {
            int point = hand.getCard(i).getRank();
            score += point >= 10 || point == 1
                    ? 10
                    : point;
        }
        return score;
    }

    private Card drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.drawCard();
            System.out.println(name + " draws " + card);
            if (cardMatches(card, prev)) {
                return card;
            }
            hand.addCard(card);
        }
    }

    private static boolean cardMatches(Card drawnCard, Card cardOnPile) {
        return drawnCard.getRank() == cardOnPile.getRank()
                || drawnCard.getSuit() == cardOnPile.getSuit()
                || drawnCard.getRank() == 8;
    }

    private Card searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            if (cardMatches(card, prev)) {
                return hand.popCard(i);
            }
        }
        return null;
    }

    Hand getHand() {
        return hand;
    }

    String getName() {
        return name;
    }
}
