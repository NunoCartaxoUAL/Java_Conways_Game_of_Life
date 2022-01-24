package Controller;

import Models.Cell;

public class Grid {
    public Cell[][] cells;

    public Grid(final int size) {
        Cell[][] grid = new Cell[size+2][size+2];
        this.cells=grid;
    }
}
