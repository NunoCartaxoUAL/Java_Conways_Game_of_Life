package Models;

public class BlockedCell extends Cell{

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
