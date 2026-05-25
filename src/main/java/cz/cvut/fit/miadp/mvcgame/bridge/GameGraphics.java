package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

public class GameGraphics implements IGameGraphics {

    IGameGraphicsImplementor impl;

    public GameGraphics(IGameGraphicsImplementor impl) {
        this.impl = impl;
    }

    @Override
    public void drawBackground(String path) {
        this.impl.drawBackground(path);
    }

    @Override
    public void drawImage(String path, Position pos) {
        this.impl.drawImage(path,pos);
    }

    @Override
    public void drawText(String text, Position pos) {
        this.impl.drawText(text,pos);
    }

    @Override
    public void drawRectangle(Position leftTop, Position rightBot) {
        this.impl.drawLine( leftTop, new Position( rightBot.getX( ), leftTop.getY( ) ) );
        this.impl.drawLine( new Position( rightBot.getX( ), leftTop.getY( ) ), rightBot );
        this.impl.drawLine( rightBot, new Position( leftTop.getX( ), rightBot.getY( ) ) );
        this.impl.drawLine( new Position( leftTop.getX( ), rightBot.getY( ) ), leftTop );
    }

    @Override
    public void drawPoint(Position pos) {
        this.impl.drawPoint(pos);
    }

    @Override
    public void clear() {
        this.impl.clear();
    }

    @Override
    public boolean checkCollision(AbstractEnemy enemy, AbstractMissile missile) {
        return this.impl.checkCollision(enemy,missile);
    }

}
