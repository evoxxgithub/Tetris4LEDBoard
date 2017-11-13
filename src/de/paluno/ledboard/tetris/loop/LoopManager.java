package de.paluno.ledboard.tetris.loop;

import de.paluno.ledboard.tetris.boardcontrol.TimeModifier;
import de.paluno.ledboard.tetris.victorycondition.LooseChecker;

public class LoopManager {

    public LoopManager(TimeModifier timeModifier, TickSystem tickSystem, LooseChecker looseChecker) {
        this.timeModifier = timeModifier;
        this.tickSystem = tickSystem;
        this.keepRunning = true;
        this.looseChecker = looseChecker;
    }

    private final TimeModifier timeModifier;
    private static final int FPS = 2;
    private TickSystem tickSystem;
    private boolean keepRunning;
    private final LooseChecker looseChecker;
    public void runloop(){
        final int min_time_per_frame = 1000/FPS;
        while(keepRunning){
            long time_before_frame = System.currentTimeMillis();
            tickSystem.tick();
            long time_after_frame = System.currentTimeMillis();
            long time_spend = time_after_frame - time_before_frame;
            if (time_spend < min_time_per_frame)
                this.timeModifier.sleep((int) (min_time_per_frame - time_spend));
            if (looseChecker.gameIsLost()) {
                keepRunning = false;
                System.out.println("game is lost");
            }
        }
    }
}
