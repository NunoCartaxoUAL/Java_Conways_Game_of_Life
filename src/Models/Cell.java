package Models;

import javax.swing.*;

public abstract class Cell extends JButton{
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


    public abstract void setNeighbor(Cell cell, int i);

    public abstract boolean nextState();
}
