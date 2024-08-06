import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable>   observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if ( !observers.contains(p_flyable) ) {
            observers.add(p_flyable);
            Logger.log("Tower: " + p_flyable.getName() + " (" + p_flyable.getId() + ") is monitored");
        }
    }

    public void unregister(Flyable p_flyable) {
        if ( observers.contains(p_flyable) )  {
            observers.remove(p_flyable);
            Logger.log("Tower: " + p_flyable.getName() + " (" + p_flyable.getId() + ") stopped being monitored");
        }
    }

    protected void conditionChanged() {
        for ( Flyable flyable : observers ) {
            flyable.updateConditions();
        }
    }
}
