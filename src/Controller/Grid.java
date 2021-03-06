package Controller;

import Models.Cell;
import Models.WorkingCell;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grid extends JPanel{
    private Cell[][] cells;
    private int size;

    public Grid(final int size) {
        this.size = size;
        Cell[][] grid = new Cell[size][size];
        this.cells=grid;
        this.fill();
    }

    public String showGrid() {
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


    public void fill() {
        this.createCornerCells(this.size);
        this.createWallCells(this.size);
        this.createMidCells(this.size);
        this.addNeighborsToCells();
    }

    private void addNeighborsToCells() {
        // Adds cells to the neighbors they belong to , so the first cell would add itself to the 2second cell and the one below itself as a neighbor
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.println();
                var cell = this.cells[i][j];
                int count = 8;
                for (int k = -1; k <=1 ; k++) {
                    for (int l = -1; l <=1 ; l++) {
                        if (!(k==0 && l==0)){
                            if ((i+k>=0) && (j+l>=0) && (i+k<this.size) && (j+l<this.size)){
                                var targetCell = this.cells[i+k][j+l];
                                if (targetCell instanceof WorkingCell){
                                    targetCell.setNeighbor(cell,count);
                                }

                            }

                        }
                    count--;
                    }
                }
            }
        }
    }

    // creates wall cells and adds the block neighbor cells to the non corner wall cells
    public void createWallCells(final int size) {
        for (int i = 1; i <size-1 ; i++) {
            this.cells[0][i] = new WorkingCell(false);
            int[] block = {1,1,1,0,0,0,0,0,0};
            this.cells[0][i].insertBlockedCells(block);

            this.cells[i][0] = new WorkingCell(false);
            int[] block1 = {1,0,0,1,0,0,1,0,0};
            this.cells[i][0].insertBlockedCells(block1);

            this.cells[this.size-1][i] = new WorkingCell(false);
            int[] block2 = {0,0,0,0,0,0,1,1,1};
            this.cells[this.size-1][i].insertBlockedCells(block2);

            this.cells[i][this.size-1] = new WorkingCell(false);
            int[] block3 = {0,0,1,0,0,1,0,0,1};
            this.cells[i][this.size-1].insertBlockedCells(block3);
        }

    }

    // creates adds the block neighbor to corner wall cells
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

    //Creates the cells in the middles
    public void createMidCells(final int size){
        for (int i = 1; i < this.size-1; i++) {
            for (int j = 1; j < this.size-1; j++) {
                this.cells[i][j] = new WorkingCell(false);
            }
        }
    }

    public void changeCell(int px,int py) {
        this.cells[px-1][py-1].setLife(!this.cells[px-1][py-1].isLife());
    }

    public void calculateNextMoment(){
        boolean[][] nextStates = new boolean[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                nextStates[i][j]=this.cells[i][j].nextState();
            }
        }
        this.updateAll(nextStates);
    }

    public void updateAll(final boolean[][] nextStates){
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.cells[i][j].setLife(nextStates[i][j]);
            }
        }
    }

    public int getGridSize() {
        return this.size;
    }

    public void Randomize() {
        size = this.getGridSize();
        Random rd = new Random(); // creating Random object
        boolean[][] newValues2 = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newValues2[i][j] = (rd.nextInt(2)==1);
            }
        }
        this.updateAll(newValues2);
    }
    public Cell[][] getCells() {
        return cells;
    }
}
