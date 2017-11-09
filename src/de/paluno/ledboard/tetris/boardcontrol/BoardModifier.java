package de.paluno.ledboard.tetris.boardcontrol;

import ledControl.BoardController;

public class BoardModifier implements TimeModifier{

    private BoardController controller;

    public BoardModifier(){
        this.controller = BoardController.getBoardController();
    }

    public void setCell(int x, int y, int red, int green, int blue){
        this.controller.setColor(x,y,red,green,blue);
    }

    public void update(){
        this.controller.updateLedStripe();
    }

    public void setBackgroundColor(int red, int green, int blue) {
        this.controller.setBackgroundColor(red, green, blue);
    }


    public void reset() {
        this.controller.resetColors();
    }

    @Override
    public void sleep(int ms) {
        this.controller.sleep(ms);
    }
}
