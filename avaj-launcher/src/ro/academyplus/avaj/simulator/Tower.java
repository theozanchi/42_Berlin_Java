import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable>   observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        if ( !observers.contains(p_flyable) ) {
            observers.add(p_flyable);
            Logger.log("Tower: flyable " + p_flyable.getId() + " is monitored");
        }
    }

    public void unregister(Flyable p_flyable) {

    }

    protected void conditionChanged() {
        
    }
}
