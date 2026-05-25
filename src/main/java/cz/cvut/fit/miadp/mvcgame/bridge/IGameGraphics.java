package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public interface IGameGraphics {

    public void drawBackground(String path);
    public void drawImage(String path, Position pos);
    public void drawText(String text, Position pos);
    public void drawRectangle(Position leftTop, Position rightBot);
    public void drawPoint(Position pos);
    public void clear();

    public boolean checkCollision(AbstractEnemy enemy, AbstractMissile missile);
}
