package de.paluno.ledboard.tetris.drawing;

import de.paluno.ledboard.tetris.boardcontrol.BoardModifier;

import java.util.ArrayList;
import java.util.List;

public class DrawSystem {

    private final List<Drawable> drawables;
    private final BoardModifier boardModifier;

    public DrawSystem(BoardModifier boardModifier) {
        this.boardModifier = boardModifier;
        this.drawables = new ArrayList<>();
        this.boardModifier.setBackgroundColor(50, 50, 50);
    }

    public void draw(){
        this.boardModifier.reset();
        this.drawables.forEach(d -> d.draw(this.boardModifier));
        this.boardModifier.update();

    }

    public void registerDrawable(Drawable d) {
        this.drawables.add(d);
    }
    public void removeDrawable(Drawable d) {
        this.drawables.remove(d);
    }
}
