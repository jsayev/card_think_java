package game.card.war;

import game.card.Card;

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
        for (int i = 0; i < this.cards.length; i++) {
            int randomized = randomInt(i, this.cards.length);
            swapCards(i, randomized);
        }
    }

    void selectionSort() {
        for (int i = 0; i < this.cards.length; i++) {
            swapCards(i, indexLowest(i, this.cards.length - 1));
        }
    }

    /**
     * @param low  inclusive starting position
     * @param high inclusive ending position
     * @return Deck object
     */
    Deck createSubdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    //fake one due to having using selectionSort
    Deck almostMergeSort() {
        Deck d1 = createSubdeck(0, (this.cards.length - 1) / 2);
        Deck d2 = createSubdeck((this.cards.length - 1) / 2 + 1, this.cards.length - 1);
        selectionSort();
        return merge(d1, d2);
    }

    Deck mergeSort() {
        int len = this.cards.length;
        if (len < 2) {
            return this;
        }
        int mid = len / 2;
        Deck d1 = this.createSubdeck(0, mid - 1);
        Deck d2 = this.createSubdeck(mid, len - 1);
        d1 = d1.mergeSort();
        d2 = d2.mergeSort();
        return merge(d1, d2);
    }

    private static int randomInt(int low, int high) {
        return new Random().nextInt(low, high);
    }

    void swapCards(int i, int j) {
        Card cardToSwap = cards[i];
        cards[i] = cards[j];
        cards[j] = cardToSwap;
    }

    private int indexLowest(int low, int high) {
        int indexOfLowest = low;
        Card lowestIndexCard = this.cards[indexOfLowest];
        for (int i = low + 1; i <= high; i++) {
            Card nextCard = this.cards[i];
            if (nextCard.compareTo(lowestIndexCard) == -1) {
                indexOfLowest = i;
                lowestIndexCard = nextCard;
            }
        }
        return indexOfLowest;
    }

    static Deck merge(Deck d1, Deck d2) {
        Deck mergedDeck = new Deck(d1.cards.length + d2.cards.length);
        int d1Index = 0;
        int d2Index = 0;

        for (int i = 0; i < mergedDeck.cards.length; i++) {
            if (d1Index >= d1.cards.length) {
                mergedDeck.cards[i] = d2.cards[d2Index];
                d2Index++;
                continue;
            }
            if (d2Index >= d2.cards.length) {
                mergedDeck.cards[i] = d1.cards[d1Index];
                d1Index++;
                continue;
            }
            if (d1.cards[d1Index].compareTo(d2.cards[d2Index]) == -1) {
                mergedDeck.cards[i] = d1.cards[d1Index];
                d1Index++;
                continue;
            }
            if (d2.cards[d2Index].compareTo(d1.cards[d1Index]) == -1) {
                mergedDeck.cards[i] = d2.cards[d2Index];
                d2Index++;
            } else {
                mergedDeck.cards[i] = d2.cards[d2Index];
                mergedDeck.cards[++i] = d1.cards[d1Index];
                d2Index++;
                d1Index++;
            }
        }
        return mergedDeck;
    }

    Card[] getCards() {
        return cards;
    }
}
