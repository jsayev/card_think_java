package think.java;

import java.util.Random;

class Deck {
    private final Card[] cards;

    Deck() {
        this.cards = new Card[52];
        int index = 0;

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    Deck(int n) {
        this.cards = new Card[n];
    }

    void print() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int randomized = randomInt(i, cards.length - 1);
            swapCards(i, randomized);
        }
    }

    void selectionSort() {
        for (int i = 0; i < cards.length; i++) {
            swapCards(i, indexLowest(i, cards.length - 1));
        }
    }

    private static int randomInt(int low, int high) {
        return new Random().nextInt(low, high + 1);
    }

    private void swapCards(int i, int j) {
        Card cardToSwap = cards[i];
        cards[i] = cards[j];
        cards[j] = cardToSwap;
    }

    private int indexLowest(int low, int high) {
        int lowest = low;
        Card lowestCard = cards[lowest];
        for (int i = low + 1; i <= high; i++) {
            Card nextCard = cards[i];
            if (nextCard.compareTo(lowestCard) == -1) {
                lowest = i;
                lowestCard = nextCard;
            }
        }
        return lowest;
    }

    Card[] getCards() {
        return cards;
    }
}
