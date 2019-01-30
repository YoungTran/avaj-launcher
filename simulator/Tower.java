package simulator;

import aircrafts.*;
import java.util.*;

abstract class Tower {
    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        landed.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable f : this.observers) {
            f.updateConditions();
        }

        this.observers.removeAll(this.landed);
        this.landed = new ArrayList<Flyable>();
    }
    private List<Flyable> observers = new ArrayList<Flyable>();
    private List<Flyable> landed = new ArrayList<Flyable>();
}
