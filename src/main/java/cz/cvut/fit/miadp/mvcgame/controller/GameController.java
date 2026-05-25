package cz.cvut.fit.miadp.mvcgame.controller;

import cz.cvut.fit.miadp.mvcgame.command.*;
import cz.cvut.fit.miadp.mvcgame.proxy.IGameModel;

import java.util.List;

public class GameController {

    private IGameModel model;

    public GameController(IGameModel model) {
        this.model = model;
    }

    public void processPressedKeys(List<String> pressedKeysCodes)
    {
        for(String code : pressedKeysCodes)
        {
            switch(code){
                case "UP":
                    this.model.registerCommand(new MoveCannonAUpCmd(this.model));
                    break;
                case "DOWN":
                    this.model.registerCommand(new MoveCannonADownCmd(this.model));
                    break;
                case "RIGHT": //SPACE
                    this.model.cannonAShoot();
                    break;
                case "O":
                    this.model.registerCommand(new AimCannonAUpCmd(this.model));
                    break;
                case "P":
                    this.model.registerCommand(new AimCannonADownCmd(this.model));
                    break;
                case "K":
                    this.model.registerCommand(new CannonAPowerUpCmd(this.model));
                    break;
                case "L":
                    this.model.registerCommand(new CannonAPowerDownCmd(this.model));
                    break;
                case "M":
                    this.model.registerCommand(new ToggleMovingStrategyCmd(this.model));
                    break;
                case "N":
                    this.model.registerCommand(new ToggleShootingModeCmd(this.model));
                    break;
                case "U":
                    this.model.registerCommand(new IncreaseDynamicShootCounterCmd(this.model));
                    break;
                case "I":
                    this.model.registerCommand(new DecreaseDynamicShootCounterCmd(this.model));
                    break;
/*======================================================================*/
                case "LEFT": //SPACE
                    this.model.cannonBShoot();
                    break;
/*======================================================================*/
                /*case "R":
                    CareTaker.getInstance().createMemento();
                    break;
                case "T":
                    CareTaker.getInstance().setMemento();
                    break;*/
                case "R":
                    this.model.undoLastCommand();

                default:
                    //nothing
            }
        }
    }

}
