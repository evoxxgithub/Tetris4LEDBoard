package de.paluno.ledboard.tetris.objects.collision;

import java.util.Comparator;

public class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell c1, Cell c2) {
        if (c1.getY() != c2.getY()) return c2.getY()- c1.getY();
        else return c1.getX() - c2.getX();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
