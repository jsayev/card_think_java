package game.conway.gol;

import java.awt.*;

class Cell {
    public static final Color[] COLORS = {Color.WHITE, Color.BLACK};
    private final int x;
    private final int y;
    private final int size;
    private int state;


    Cell(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = 0;
    }

    void draw(Graphics g) {
        g.setColor(COLORS[state]);
        g.fillRect(x + 1, y + 1, size - 1, size - 1);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, size, size);
    }

    boolean isOff() {
        return state == 0;
    }

    boolean isOn() {
        return state == 1;
    }

    void turnOff() {
        state = 0;
    }

    void turnOn() {
        state = 1;
    }
}
