package Models;

public class WorkingCell extends Cell{
/*
-Cell[] Neighbors
    +Cell[] getNeighbors()
    +Cell getNeighbor()
    +Void setLife()
    +Void calculateNextMoment()
*/
    private Cell[] neighbors;

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
}
