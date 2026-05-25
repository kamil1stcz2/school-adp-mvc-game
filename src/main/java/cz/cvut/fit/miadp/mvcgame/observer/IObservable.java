package cz.cvut.fit.miadp.mvcgame.observer;

public interface IObservable {

    public void registerObserver(IObserver obs, Aspect aspect);
    public void unregisterObserver(IObserver obs, Aspect aspect);
    public void notifyObserver(Aspect.ASPECT... aspects);

}
