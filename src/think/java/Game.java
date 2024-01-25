package think.java;

class Game {
    public static void main(String[] args) {
        int index = 0;
        Card[] cards = new Card[52];
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        Game game = new Game();
        System.out.println(game.sequentialSearch(cards, new Card(11, 0)));
        System.out.println(game.binarySearch(cards, new Card(11, 0)));
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
