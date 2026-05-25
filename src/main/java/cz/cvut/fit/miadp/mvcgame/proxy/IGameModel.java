package cz.cvut.fit.miadp.mvcgame.proxy;

import cz.cvut.fit.miadp.mvcgame.abstractfactory.IGameObjectFactory;
import cz.cvut.fit.miadp.mvcgame.builder.Director;
import cz.cvut.fit.miadp.mvcgame.command.AbstractGameCommand;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.GameObject;
import cz.cvut.fit.miadp.mvcgame.observer.IObservable;
import cz.cvut.fit.miadp.mvcgame.strategy.IMovingStrategy;

import java.util.List;

public interface IGameModel extends IObservable {

    public void update( );
    public AbstractCannon getCannonA();
    public AbstractCannon getCannonB();
    public void moveCannonAUp();
    public void moveCannonADown();
    public void cannonAShoot();
    public void cannonBShoot();
    public List<GameObject> getGameObjects();
    public void aimCannonAUp( );
    public void aimCannonADown( );
    public void cannonAPowerUp( );
    public void cannonAPowerDown( );
    public void toggleShootingModeA( );
    public void toggleMovingStrategyA();
    public IMovingStrategy getCannonAMovingStrategy();
    public Object createMemento( );
    public void setMemento( Object memento );
    public void increaseDynamicShootCounterA( );
    public void decreaseDynamicShootCounterA( );

    public Position getCannonAPosition();
    public Position getCannonBPosition();
    public IGameObjectFactory getGoFactoryA();

    public void registerCommand(AbstractGameCommand command);
    public void undoLastCommand();
    public int getScore();
    public Director getDirector();
}
