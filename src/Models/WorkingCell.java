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
        var text = "WorkingCell_{" + "life="+super.isLife()+",";
        var count = 0;

        for (Cell cell:this.neighbors) {
            text+="("+count+")";
            if (cell instanceof Cell){
                text += "neighbor"+count+" =" + cell.isLife()+" ,";
            }

            count++;
        }
        text += "}_";
        return text;
    }

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
