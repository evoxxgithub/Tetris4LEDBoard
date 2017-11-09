package de.paluno.ledboard.tetris.loop;

import de.paluno.ledboard.tetris.boardcontrol.TimeModifier;

public class LoopManager {

    public LoopManager(TimeModifier timeModifier, TickSystem tickSystem) {
        this.timeModifier = timeModifier;
        this.tickSystem = tickSystem;
        this.keepRunning = true;
    }

    private TimeModifier timeModifier;
    private static final int FPS = 2;
    private TickSystem tickSystem;
    private boolean keepRunning;
    public void runloop(){
        final int min_time_per_frame = 1000/FPS;
        while(keepRunning){
            long time_before_frame = System.currentTimeMillis();
            tickSystem.tick();
            long time_after_frame = System.currentTimeMillis();
            long time_spend = time_after_frame - time_before_frame;
            if (time_spend < min_time_per_frame)
                this.timeModifier.sleep((int) (min_time_per_frame - time_spend));
        }
    }
}
