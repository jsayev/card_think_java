package game.conway.gol;

import java.awt.*;

class GridCanvas extends Canvas {
    private Cell[][] array;

    GridCanvas(int rows, int cols, int size) {
        this.array = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            int y = r * size;
            for (int c = 0; c < cols; c++) {
                int x = c * size;
                array[r][c] = new Cell(x, y, size);
            }
        }
        setSize(cols * size, rows * size);
    }

    void draw(Graphics g) {
        for (Cell[] row : array) {
            for (Cell cell : row) {
                cell.draw(g);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }

    int numRows() {
        return array.length;
    }

    int numCols() {
        return array[0].length;
    }

    Cell getCell(int r,int c){
        return array[r][c];
    }

    void turnOn(int r,int c){
        array[r][c].turnOn();
    }
}
