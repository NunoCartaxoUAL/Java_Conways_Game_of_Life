package Controller;

import Models.Cell;
import Models.WorkingCell;

import java.util.Arrays;

public class Grid {
    private Cell[][] cells;
    private int size;

    public Grid(final int size) {
        this.size = size;
        Cell[][] grid = new Cell[size][size];
        this.cells=grid;
        this.fill();
    }

    public String show() {
        String map = "";
        for (Cell[] cellrow :this.cells) {
            map += "[";
            String temp ="";
            for (Cell cell: cellrow) {
                temp += (cell.isLife()?1:0)+",";
            }
            temp = temp.substring(0,temp.length()-1);
            map += temp+"] \n";
        }
        return map;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }

    public void fill() {
        //TODO fill all squared with corner cells + wall cells + normal cells
        this.createCornerCells(this.size);
        this.createWallCells(this.size);
        this.createMidCells(this.size);
        this.addNeighborsToCells();
    }

    private void addNeighborsToCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                var cell = this.cells[i][j];
                //TODO implement add neighbors to respective cells cell -> respective cells
            }
        }
    }

    public void createWallCells(final int size) {
        for (int i = 1; i <size-1 ; i++) {
            this.cells[0][i] = new WorkingCell(false);
            int[] block = {1,1,1,0,0,0,0,0,0};
            this.cells[0][i].insertBlockedCells(block);

            this.cells[i][0] = new WorkingCell(false);
            int[] block1 = {1,0,0,1,0,0,1,0,0};
            this.cells[i][0].insertBlockedCells(block1);

            this.cells[this.size-1][i] = new WorkingCell(false);
            int[] block2 = {0,0,1,0,0,1,0,0,1};
            this.cells[this.size-1][i].insertBlockedCells(block2);

            this.cells[i][this.size-1] = new WorkingCell(false);
            int[] block3 = {0,0,1,0,0,1,0,0,1};
            this.cells[i][this.size-1].insertBlockedCells(block3);
        }

    }

    public void createCornerCells(final int size){
        this.cells[0][0] = new WorkingCell(false);
        int[] block = {1,1,1,1,0,0,1,0,0};
        this.cells[0][0].insertBlockedCells(block);

        this.cells[0][size-1] = new WorkingCell(false);
        int[] block1 = {1,1,1,0,0,1,0,0,1};
        this.cells[0][size-1].insertBlockedCells(block1);


        this.cells[size-1][0] = new WorkingCell(false);
        int[] block2 = {1,0,0,1,0,0,1,1,1};
        this.cells[size-1][0].insertBlockedCells(block2);


        this.cells[size-1][size-1] = new WorkingCell(false);
        int[] block3 = {0,0,1,0,0,1,1,1,1};
        this.cells[size-1][size-1].insertBlockedCells(block3);
    }

    public void createMidCells(final int size){
        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j < size-1; j++) {
                this.cells[i][j] = new WorkingCell(false);
            }
        }
    }

    public void changeCell(int px,int py) {
        this.cells[px-1][px-1].setLife(true);
    }
}
