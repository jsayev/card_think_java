package game.conway.gol;

import javax.swing.*;

class Conway {
    private GridCanvas grid;

    Conway() {
        this.grid = new GridCanvas(5, 10, 20);
        grid.turnOn(2, 1);
        grid.turnOn(2, 2);
        grid.turnOn(2, 3);

        grid.turnOn(1, 7);
        grid.turnOn(2, 7);
        grid.turnOn(3, 7);
    }

    public static void main(String[] args) {
        String title = "Conway's game of life";
        Conway game = new Conway();
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
    }

    private void mainloop() {
        int count = 0;
        while(count<10){
            this.update();
        }
    }
}
