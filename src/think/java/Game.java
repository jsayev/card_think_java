package think.java;

class Game {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println("Shuffling \n");
        deck.shuffle();
        deck.print();
        System.out.println("\nselection sorting \n");
        deck.selectionSort();
        deck.print();

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
