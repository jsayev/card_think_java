package think.java;

import java.util.ArrayList;

class Game {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Deck mergedSort = deck.mergeSort();
        System.out.println("\nmerged sort");
        mergedSort.print();
//        Pile p1 = new Pile();
//        p1.addDeck(deck.createSubdeck(0, 25));
//
//        Pile p2 = new Pile();
//        p2.addDeck(deck.createSubdeck(26, 51));
//
//        Game.startWarGame(p1, p2);
    }

    private static void startWarGame(Pile p1, Pile p2) {
        while (!p1.isEmpty() && !p2.isEmpty()) {
            Card c1 = p1.popCard();
            Card c2 = p2.popCard();

            int diff = c1.getRank() - c2.getRank();

            if (diff > 0) {
                p1.addCard(c1);
                p1.addCard(c2);
            } else if (diff < 0) {
                p2.addCard(c1);
                p2.addCard(c2);
            } else {
                ArrayList<Card> p1Cards = new ArrayList<>();
                ArrayList<Card> p2Cards = new ArrayList<>();
                // initially, each players draws 4 cards
                draw4Cards(p1, p2, p1Cards, p2Cards);

                int nthFour = 1;
                int fourthCardDiff = p1Cards.get(4 * nthFour - 1).getRank() - p2Cards.get(4 * nthFour - 1).getRank();

                while (fourthCardDiff == 0) {
                    nthFour++;
                    draw4Cards(p1, p2, p1Cards, p2Cards);
                    fourthCardDiff = p1Cards.get(4 * nthFour - 1).getRank() - p2Cards.get(4 * nthFour - 1).getRank();
                }

                if (fourthCardDiff > 0) {
                    for (int i = 0; i < p1Cards.size(); i++) {
                        p1.addCard(p1Cards.removeFirst());
                    }
                    for (int i = 0; i < p2Cards.size(); i++) {
                        p1.addCard(p2Cards.removeFirst());
                    }
                } else {
                    for (int i = 0; i < p2Cards.size(); i++) {
                        p2.addCard(p2Cards.removeFirst());
                    }
                    for (int i = 0; i < p1Cards.size(); i++) {
                        p2.addCard(p1Cards.removeFirst());
                    }
                }
            }
        }

        if (p2.isEmpty()) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    private static void draw4Cards(Pile p1, Pile p2, ArrayList<Card> c1Cards, ArrayList<Card> c2Cards) {
        for (int i = 0; i <= 3; i++) {
            c1Cards.add(p1.popCard());
            c2Cards.add(p2.popCard());
        }
    }

    int sequentialSearch(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    int binarySearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (cards[mid].equals(target)) {
                return mid;
            }
            if (cards[mid].compareTo(target) == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
