package main.java.de.fortytwoberlin.tower;

import java.util.List;
import java.util.ArrayList;
import main.java.de.fortytwoberlin.flyable.Flyable;
import main.java.de.fortytwoberlin.simulator.Logger;

public class Tower {
    private List<Flyable>   observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if ( !observers.contains(p_flyable) ) {
            observers.add(p_flyable);
            Logger.getInstance().log("Tower: " + p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + " (" + p_flyable.getId() + ") is monitored");
        }
    }

    public void unregister(Flyable p_flyable) {
        if ( observers.contains(p_flyable) )  {
            observers.remove(p_flyable);
            Logger.getInstance().log("Tower: " + p_flyable.getClass().getSimpleName() + "#" + p_flyable.getName() + " (" + p_flyable.getId() + ") stopped being monitored");
        }
    }

    protected void conditionChanged() {
        for ( int i = observers.size() - 1; i>= 0; i-- ) {
            observers.get(i).updateConditions();
        }
    }
}
