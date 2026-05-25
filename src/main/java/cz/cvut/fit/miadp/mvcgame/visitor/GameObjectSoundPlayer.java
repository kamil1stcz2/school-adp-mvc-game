package cz.cvut.fit.miadp.mvcgame.visitor;

import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractEnemy;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractMissile;

import javafx.scene.media.AudioClip;

import java.io.File;
import java.net.URL;

public class GameObjectSoundPlayer implements IVisitor {

    AudioClip playCannonAShoot;
    AudioClip playMissileADestroy;
    AudioClip playCannonBShoot;
    AudioClip playMissileBDestroy;
    AudioClip playEnemyDeath;

    public GameObjectSoundPlayer() {
        File cannonAShootResource =    new File("src/main/resources/sounds/mixkit-shot-light-explosion-1682.mp3");
        File cannonBShootResource =    new File("src/main/resources/sounds/mixkit-laser-weapon-shot-1681.mp3");
        File missileADestroyResource =  new File("src/main/resources/sounds/mixkit-war-explosions-2773.mp3");
        File missileBDestroyResource = new File("src/main/resources/sounds/mixkit-bomb-explosion-in-battle-2800.mp3");
        File enemyDeathResource = new File("src/main/resources/sounds/mixkit-cartoon-panic-squeak-1010.wav");

        this.playCannonAShoot = new AudioClip(cannonAShootResource.toURI().toString());
        this.playCannonBShoot = new AudioClip(cannonBShootResource.toURI().toString());
        this.playMissileADestroy = new AudioClip(missileADestroyResource.toURI().toString());
        this.playMissileBDestroy = new AudioClip(missileBDestroyResource.toURI().toString());
        this.playEnemyDeath = new AudioClip(enemyDeathResource.toURI().toString());

    }

    @Override
    public void visitCannonA(AbstractCannon cannon) {
        this.playCannonAShoot.play();
    }

    @Override
    public void visitMissileA(AbstractMissile missile) {
        this.playMissileADestroy.play();
    }

    @Override
    public void visitCannonB(AbstractCannon cannon) {
        this.playCannonBShoot.play();
    }

    @Override
    public void visitMissileB(AbstractMissile missile) {
        this.playMissileBDestroy.play();
    }

    @Override
    public void visitEnemy(AbstractEnemy enemy) {
        this.playEnemyDeath.play();
    }
}
