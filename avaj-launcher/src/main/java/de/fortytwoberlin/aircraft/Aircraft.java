package main.java.de.fortytwoberlin.aircraft;

import main.java.de.fortytwoberlin.flyable.Flyable;
import main.java.de.fortytwoberlin.coordinates.Coordinates;
import main.java.de.fortytwoberlin.simulator.Logger;

public abstract class Aircraft extends Flyable {
    protected   long            id;
    protected   String          name;
    protected   Coordinates     coordinates;

    protected Aircraft( long p_id, String p_name, Coordinates p_coordinate ) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    @Override
    public long         getId( ) { return (id); }

    @Override
    public String       getName( ) { return (name); }

    public Coordinates  getCoordinates( ) { return (coordinates); }

    protected void land( ) {
        Logger.log(getName() + " (" + getId() + "): landing.");
        weatherTower.unregister(this);
    }
}
