package think.java;

class Card {
    static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static final String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private final int rank;
    private final int suit;

    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        return Integer.compare(this.rank, that.rank);
    }

    public String toString() {
        return ranks[this.rank] + " of " + suits[this.suit];
    }

    boolean equals(Card that) {
        return this.rank == that.rank && this.suit == that.suit;
    }


}
