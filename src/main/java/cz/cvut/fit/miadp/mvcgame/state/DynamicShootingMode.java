package cz.cvut.fit.miadp.mvcgame.state;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.model.objects.AbstractCannon;

public class DynamicShootingMode implements IShootingMode  {

    private int shotsCount;

    public DynamicShootingMode() {
        this.shotsCount = 0;
    }

    public void increaseShot() {
        if (this.shotsCount < MvcGameConfig.MAX_SHOTS) {
            this.shotsCount++;
        }
    }

    public void decreaseShot() {
        if (this.shotsCount > 0) {
            this.shotsCount--;
        }
    }

    public int getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    @Override
    public void shoot(AbstractCannon cannon) {
        for (int i = 0; i < this.shotsCount; i++) {
            for (int j = 0; j < i; j++) {
                if (i % 2 == 0) {
                    cannon.aimUp();
                }
                else {
                    cannon.aimDown();
                }
            }

            cannon.primitiveShoot();

            for (int j = 0; j < i; j++) {
                if (i % 2 == 0) {
                    cannon.aimDown();
                }
                else {
                    cannon.aimUp();
                }
            }
        }
    }

    /*
    *     public void shoot(AbstractCannon cannon) {
        for (int i = 0; i < this.shotsCount; i++) {
            for (int j = 0; j < i; j++)
                cannon.aimUp();

            cannon.primitiveShoot();

            for (int j = 0; j < i; j++)
                cannon.aimDown();
        }
    }
    *
    *
    * */

    @Override
    public String getName() {
        return "DynamicShootingMode";
    }
}
