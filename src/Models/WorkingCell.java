package Models;

import java.util.Arrays;

public class WorkingCell extends Cell{

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

    public void calculateNextMoment(){
        //TODO impletent
    }

    @Override
    public String toString() {
        return "WorkingCell{" +
                "neighbors=" + Arrays.toString(neighbors) +
                '}';
    }

    @Override
    public void insertBlockedCells(int[] dialBlockedCells) {
        for (int i = 0; i < 9; i++) {
            if (dialBlockedCells[i]==1){
                this.neighbors[i]= new BlockedCell();
            }
        }
    }
}
