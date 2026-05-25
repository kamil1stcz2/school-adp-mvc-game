package cz.cvut.fit.miadp.mvcgame.observer;

import java.util.*;

public class Aspect {

    public enum ASPECT {CANNON, MISSILE, ENEMY};

    Set<ASPECT> aspectSet;

    public Aspect () {
        this.aspectSet = new HashSet<>();
        this.aspectSet.addAll(Arrays.asList(ASPECT.values()));
    }

    public Aspect(ASPECT... aspects) {
        this.aspectSet = new HashSet<>();
        Collections.addAll(aspectSet, aspects);
    }

    public void addAdditionalAspects(Set<ASPECT> aspects) {
        aspectSet.addAll(aspects);
    }

    public Set<ASPECT> getAspectSet() {
        return this.aspectSet;
    }

    public boolean containsAny(ASPECT... aspects) {
        List<ASPECT> givenAspectList = Arrays.asList(aspects);
        return !Collections.disjoint(aspectSet, givenAspectList);
    }
}
