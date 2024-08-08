package main.java.de.fortytwoberlin.aircraft;

import main.java.de.fortytwoberlin.flyable.Flyable;
import main.java.de.fortytwoberlin.coordinates.Coordinates;

public class AircraftFactory {
    private static AircraftFactory  instance;
    private static int              id;

    private AircraftFactory() { id = 1; }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return (instance);
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        switch (p_type.toLowerCase()) {
            case "helicopter":
                return (new Helicopter(id++, p_name, p_coordinates));
            case "jetplane":
                return (new JetPlane(id++, p_name, p_coordinates));
            case "baloon":
                return (new Baloon(id++, p_name, p_coordinates));
            default:
                throw (new IllegalArgumentException("Invalid Flyable type"));
        }
    }
}
