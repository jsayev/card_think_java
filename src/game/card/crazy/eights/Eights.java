package game.card.crazy.eights;

import game.card.Card;

import java.util.Scanner;

/**
 * @author jsayev
 */
class Eights {
    private Player one;
    private Player two;
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;

    Eights() {
        this.one = new Player("One");
        this.two = new Player("Two");
        this.drawPile = new Hand("Draw pile");
        this.discardPile = new Hand("Discard pile");
        this.in = new Scanner(System.in);
    }

    boolean isDone() {
        return one.getHand().isEmpty() || two.getHand().isEmpty();
    }

    void reshuffle() {
        Card cardOnTop = discardPile.popCard();
        discardPile.dealAll(drawPile);
        drawPile.shuffle();
        drawPile.addCard(cardOnTop);
    }

    Card drawCard() {
        if (drawPile.isEmpty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    Player nextPlayer(Player current) {
        if (current == one) return two;
        return one;
    }

    void displayState() {
        one.getHand().display();
        two.getHand().display();
        discardPile.display();
        System.out.println("Draw pile:");
        System.out.println(drawPile.size() + " cards");
//        in.nextLine();
    }

    void takeTurn(Player player) {
        Card prev = discardPile.getLastCard();
        Card next = player.play(this, prev);
        discardPile.addCard(next);
        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    void playGame() {
        Deck deck = new Deck("Game Cards");
        deck.shuffle();
        deck.deal(one.getHand(), 5);
        deck.deal(two.getHand(), 5);
        one.getHand().display();
        two.getHand().display();
        deck.dealAll(drawPile);
        discardPile.addCard(drawPile.getLastCard());
        Player player = one;

        while (!isDone()) {
            displayState();
            takeTurn(player);
            player = nextPlayer(player);
        }

        if (one.getHand().isEmpty()) System.out.println("Player one wins with score of " + two.score());
        if (two.getHand().isEmpty()) System.out.println("Player two wins with score of " + one.score());
    }
}
