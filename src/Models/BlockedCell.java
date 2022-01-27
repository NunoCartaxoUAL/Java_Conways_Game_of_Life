package Models;

public class BlockedCell extends Cell{ //cell used to block of the border of the grid cells neighbor wise

    public BlockedCell() {
        super(false);
    }

    @Override
    public void insertBlockedCells(int[] dialBlockedCells) {

    }

    @Override
    public void setNeighbor(Cell cell, int i) {

    }

    @Override
    public boolean nextState() {
        return false;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "life=" + super.isLife() +
                '}';
    }

}
