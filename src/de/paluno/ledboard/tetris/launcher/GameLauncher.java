package de.paluno.ledboard.tetris.launcher;

import de.paluno.ledboard.tetris.boardcontrol.BoardModifier;
import de.paluno.ledboard.tetris.drawing.DrawSystem;
import de.paluno.ledboard.tetris.loop.LoopManager;
import de.paluno.ledboard.tetris.objects.RowCollapseManager;
import de.paluno.ledboard.tetris.objects.ScoreCalculator;
import de.paluno.ledboard.tetris.objects.collision.CollisionHandler;
import de.paluno.ledboard.tetris.objects.collision.GameBoard;
import de.paluno.ledboard.tetris.objects.tetrispieces.Piecefactory;
import de.paluno.ledboard.tetris.loop.TickSystem;
import de.paluno.ledboard.tetris.victorycondition.LooseChecker;

public class GameLauncher {

    public static void main(String[] args) {
        GameLauncher launcher = new GameLauncher();
        launcher.launchNewGame();
    }

    private void launchNewGame() {
        BoardModifier boardModifier = new BoardModifier();
        DrawSystem drawSystem = new DrawSystem(boardModifier);
        GameBoard board = new GameBoard();
        Piecefactory pieceFactory = new Piecefactory(board, drawSystem);
        CollisionHandler collisionHandler = new CollisionHandler(board, pieceFactory);
        pieceFactory.setCollisionHandler(collisionHandler);
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        RowCollapseManager rowCollapseManager = new RowCollapseManager(scoreCalculator, collisionHandler);
        TickSystem tickSystem = new TickSystem(collisionHandler, drawSystem, rowCollapseManager);
        LooseChecker looseChecker = new LooseChecker(collisionHandler);
        LoopManager loopManager = new LoopManager(boardModifier, tickSystem, looseChecker);
        loopManager.runloop();
    }
}
