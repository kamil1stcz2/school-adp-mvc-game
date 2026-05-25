package cz.cvut.fit.miadp.mvcgame.view;

import cz.cvut.fit.miadp.mvcgame.bridge.IGameGraphics;
import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.controller.GameController;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.Aspect;
import cz.cvut.fit.miadp.mvcgame.observer.IObserver;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;
import cz.cvut.fit.miadp.mvcgame.state.DynamicShootingMode;
import cz.cvut.fit.miadp.mvcgame.visitor.GameRenderer;

public class GameView implements IObserver {

    private IGameModel model;
    private GameController controller;
    private IGameGraphics gr;
    private GameRenderer renderer;

    public GameView(IGameModel model) {
        this.model = model;
        this.controller = new GameController(this.model);
        this.gr = null;
        this.model.registerObserver(this, new Aspect());
        this.renderer = new GameRenderer();
    }

    public GameController getController() {
        return this.controller;
    }

    public void render()  {
        gr.clear();
        gr.drawBackground("images/backgrounds/warfield3.jpg");
        drawMenu();
        //drawTrajectory();
        gr.drawRectangle(new Position(MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_X,MvcGameConfig.LEFT_TOP_ENEMY_SPAWN_Y),
                         new Position(MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_X,MvcGameConfig.RIGHT_BOT_ENEMY_SPAWN_Y));
        for (GameObject go : this.model.getGameObjects()) {
            go.acceptVisitor(this.renderer);
        }
    }

    /*public void drawTrajectory() {
        ITrajectory trajectory = this.model.getCannonA().getTrajectory();
        if (trajectory != null ) {
            trajectory.constructTrajectory(this.model.getCannonA().getMovingStrategy());
            trajectory.drawTrajectory(this.gr);
            System.out.println("Trajectory has " + trajectory.getTrajectoryStep() + " steps.");
        }
    }*/

    public void drawMenu() {
        gr.drawText("Score: " + this.model.getScore(),new Position(20,20));
        gr.drawText("Level: " + this.model.getDirector().getBuilder().getLevelName(),new Position(20,35));

        gr.drawText("Shooting strategy: " + this.model.getCannonA().getMovingStrategy().getStrategyName(),new Position(20,50));
        gr.drawText("Shooting mode: " + this.model.getCannonA().getShootingMode().getName(),new Position(20,65));
        if (this.model.getCannonA().getShootingMode() instanceof DynamicShootingMode) {
            gr.drawText("Shots in DynamicShootingMode: " + ((DynamicShootingMode) this.model.getCannonA().getShootingMode()).getShotsCount(),new Position(20,80));
        }
        else {
            gr.drawText("Enable DynamicShootingMode to show number of shots" ,new Position(20,80));
        }
        gr.drawText("Cannon angle: " + this.model.getCannonA().getAngle(),new Position(20,95));
        gr.drawText("Cannon power: " + this.model.getCannonA().getPower(),new Position(20,110));

        gr.drawText("Cannon move up: UP (arrows)",new Position(20,150));
        gr.drawText("Cannon move down: DOWN (arrows)",new Position(20,165));
        gr.drawText("Cannon shoot: RIGHT (arrows)",new Position(20,180));
        gr.drawText("Moving cannon shoot:: LEFT (arrows)",new Position(20,195));
        gr.drawText("Aim cannon up/down: O/P",new Position(20,210));
        gr.drawText("Cannon power up/down: K/L",new Position(20,225));
        gr.drawText("Change cannon shooting mode: N",new Position(20,240));
        gr.drawText("Change missile moving strategy: M",new Position(20,255));
        gr.drawText("Increase/decrease missiles in DynamicShootingMode: U/I",new Position(20,270));
        gr.drawText("Reverse last step: R",new Position(20,285));

    }

    public void setGraphicContext(IGameGraphics gr) {
        this.gr = gr;
        this.renderer.setGr(gr);
        this.update();
    }

    @Override
    public void update() {
        this.render();
    }
}
