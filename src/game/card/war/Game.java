package game.card.war;

import game.card.Card;

import java.util.ArrayList;
import java.util.List;

class Game {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Pile p1 = new Pile();
        p1.addDeck(deck.createSubdeck(0, 25));

        Pile p2 = new Pile();
        p2.addDeck(deck.createSubdeck(26, 51));

        Game.startWarGame(p1, p2);
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
                p1Cards.add(c1);
                p2Cards.add(c2);
                // initially, each player draws 4 cards
                p1Cards.addAll(p1.draw4Cards());
                p2Cards.addAll(p2.draw4Cards());

                int rankDiff = getRankDiff(p1Cards, p2Cards);

                while (rankDiff == 0) {
                    List<Card> p1DrawnNewCards = p1.draw4Cards();
                    List<Card> p2DrawnNewCards = p2.draw4Cards();
                    rankDiff = getRankDiff(p1DrawnNewCards, p2DrawnNewCards);
                    p1Cards.addAll(p1DrawnNewCards);
                    p2Cards.addAll(p2DrawnNewCards);
                }

                removeNulls(p1Cards);
                removeNulls(p2Cards);
                int totalCards = p1Cards.size() + p2Cards.size();
                if (rankDiff > 0) {
                    for (int i = 0; i < totalCards; i++) {
                        if (!p1Cards.isEmpty()) {
                            p1.addCard(p1Cards.removeFirst());
                        } else {
                            p1.addCard(p2Cards.removeFirst());
                        }
                    }
                } else {
                    for (int i = 0; i < totalCards; i++) {
                        if (!p2Cards.isEmpty()) {
                            p2.addCard(p2Cards.removeFirst());
                        } else {
                            p2.addCard(p1Cards.removeFirst());
                        }
                    }
                }
            }
        }

        if (p1.isEmpty()) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("Player 1 wins!");
        }
    }

    private static void removeNulls(List<Card> cards) {
        while (cards.contains(null)) {
            cards.remove(null);
        }
    }

    /**
     * @param p1Cards cards drawn from P1's deck
     * @param p2Cards cards drawn from P2's deck
     * @return rank difference between P1 and P2. P1 has higher rank if positive number otherwise lower rank
     */
    private static int getRankDiff(List<Card> p1Cards, List<Card> p2Cards) {
        if (!p1Cards.contains(null) && !p2Cards.contains(null)) {
            int i = p1Cards.size() - 1; // 5-1 if it is initial rank diff else 4-1
            int p1RankForNthFourCard = p1Cards.get(i).getRank();
            int p2RankForNthFourCard = p2Cards.get(i).getRank();

            return p1RankForNthFourCard - p2RankForNthFourCard;
        }

        int indexOfNullOnP1Cards = p1Cards.indexOf(null);
        int indexOfNullOnP2Cards = p2Cards.indexOf(null);
        if (!p1Cards.contains(null) && p2Cards.contains(null)) {
            return 1;
        } else if (p1Cards.contains(null) && !p2Cards.contains(null)) {
            return -1;
        }
        return indexOfNullOnP1Cards - indexOfNullOnP2Cards;
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
