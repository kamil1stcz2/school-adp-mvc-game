package cz.cvut.fit.miadp.mvcgame.bridge;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.Position;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class JavaFxGraphics implements IGameGraphicsImplementor {

    private GraphicsContext gr;

    public JavaFxGraphics(GraphicsContext gr) {
        this.gr = gr;
    }

    @Override
    public void drawBackground(String path) {
        Image image = new Image(path);
        this.gr.drawImage(image,0,0,MvcGameConfig.MAX_X,MvcGameConfig.MAX_Y);
    }

    @Override
    public void drawImage(String path, Position pos) {
        Image image = new Image(path);
        this.gr.drawImage(image,pos.getX(),pos.getY());
    }

    @Override
    public void drawText(String text, Position pos) {
        this.gr.fillText(text,pos.getX(),pos.getY());
    }

    @Override
    public void drawLine(Position begin, Position end) {
        this.gr.strokeLine(begin.getX(),begin.getY(),end.getX(),end.getY());
    }

    @Override
    public void drawPoint(Position pos) {
        this.gr.strokeRect(pos.getX(),pos.getX()+1,pos.getY(),pos.getY()+1);
    }

    @Override
    public void clear() {
        this.gr.clearRect(0,0, MvcGameConfig.MAX_X,MvcGameConfig.MAX_Y);
    }

    @Override
    public boolean checkCollision(AbstractEnemy enemy, AbstractMissile missile) {
        Image imageEnemy = new Image("images/enemy1.png");
        Image imageMissile = new Image("images/missile1B_shrink.png");

        Rectangle rectangleEnemy = new Rectangle();
        rectangleEnemy.setX(enemy.getPosition().getX());
        rectangleEnemy.setY(enemy.getPosition().getY());
        rectangleEnemy.setHeight(imageEnemy.getHeight());
        rectangleEnemy.setWidth(imageEnemy.getWidth());

        Rectangle rectangleMissile = new Rectangle();
        rectangleMissile.setX(missile.getPosition().getX());
        rectangleMissile.setY(missile.getPosition().getY());
        rectangleMissile.setHeight(imageMissile.getHeight());
        rectangleMissile.setWidth(imageMissile.getWidth());

        return rectangleEnemy.getBoundsInParent().intersects(rectangleMissile.getBoundsInParent());
    }

}
