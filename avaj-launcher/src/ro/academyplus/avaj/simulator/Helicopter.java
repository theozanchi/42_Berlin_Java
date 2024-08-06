import java.util.HashMap;

public class Helicopter extends Aircraft {
    private static HashMap<String, String> msgMap = new HashMap<>();

    static {
        msgMap.put("SUN", "Hovering in the sun, I feel like a superstar!");
        msgMap.put("RAIN", "Raindrops dance on my blades as I fly through the storm.");
        msgMap.put("FOG", "Even in the fog, my rotors slice through the mist.");
        msgMap.put("SNOW", "Snowflakes swirl around me as I hover in the winter wonderland.");
    }

    public Helicopter( long p_id, String p_name, Coordinates p_coordinate ) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

        Logger.log(getName() + " (" + getId() + "): " + msgMap.get(weather));
        switch (weather) {
            case "SUN":
                coordinates.updateLongitude(2);
                coordinates.updateHeight(4);
                break;
            case "RAIN":
                coordinates.updateHeight(-5);
                break;
            case "FOG":
                coordinates.updateHeight(-3);
                break;
            case "SNOW":
                coordinates.updateHeight(-15);
                break;
        }
    }
}
