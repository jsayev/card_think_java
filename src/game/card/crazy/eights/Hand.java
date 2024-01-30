package game.card.crazy.eights;

/**
 * @author jsayev
 */
class Hand extends CardCollection {
    Hand(String label) {
        super(label);
    }

    void display() {
        System.out.println(getLabel() + ": ");
        for (int i = 0; i < size(); i++) {
            System.out.println(getCard(i));
        }
        System.out.println();
    }
}
