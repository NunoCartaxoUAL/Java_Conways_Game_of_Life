package Models;

import java.util.Arrays;

public class WorkingCell extends Cell{ //cell with all methods and implementations needed to make the game of life

    private Cell[] neighbors = new Cell[9];

    public WorkingCell(boolean life) {
        super(life);
    }

    public Cell[] getNeighbors() {
        return this.neighbors;
    }
    public Cell getNeighbor(int position) {
        return this.neighbors[position];
    }

    public boolean nextState(){ //calculates next state based on its neighbors
        int count = 0;
        for (Cell cell:this.neighbors) {
            if (cell instanceof Cell){
                if (cell.isLife()){
                    count++;
                }
            }
        }
        if (this.isLife()){
            return !(count<2 || count > 3);
        }else{
            return count==3;
        }
    }


    //inserts blocked cells with an array of ints like so:
    // {1,1,1,1,0,0,1,0,0} would translate to
    //  [1][1][1]
    //  [1][x][0]
    //  [1][0][0]
    // meaning this would be a
    
    @Override
    public void insertBlockedCells(int[] dialBlockedCells) {
        for (int i = 0; i < 9; i++) {
            if (dialBlockedCells[i]==1){
                this.neighbors[i]= new BlockedCell();
            }
        }
    }

    @Override
    public void setNeighbor(Cell cell, int i) {
        this.neighbors[i] = cell;

    }
}
