public class AircraftFactory {
    private static AircraftFactory  instance;
    private static int              id;
    private static int              helicopter_count;
    private static int              jetplane_count;
    private static int              baloon_count;

    private AircraftFactory() { 
        id = 1;
        helicopter_count = 1;
        jetplane_count = 1;
        baloon_count = 1;
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return (instance);
    }

    public Flyable newAircraft(String p_type, Coordinates p_coordinates) {
        switch (p_type.toLowerCase()) {
            case "helicopter":
                return (new Helicopter(id++, "Helicopter #H" + helicopter_count++, p_coordinates));
            case "jetplane":
                return (new JetPlane(id++, "Jetplane #J" + jetplane_count++, p_coordinates));
            case "baloon":
                return (new Baloon(id++, "Baloon #B" + baloon_count++, p_coordinates));
            default:
                throw (new IllegalArgumentException("Invalid Flyable type"));
        }
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
