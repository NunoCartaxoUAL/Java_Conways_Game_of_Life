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
}
