package Models;

public abstract class Cell {
    private boolean life;

    public Cell(boolean life) {
        this.life = life;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "life=" + life +
                '}';
    }
    public abstract void insertBlockedCells(int[] dialBlockedCells);
}
