package main.java.de.fortytwoberlin.aircraft;

import java.util.HashMap;
import main.java.de.fortytwoberlin.coordinates.Coordinates;
import main.java.de.fortytwoberlin.simulator.Logger;
import main.java.de.fortytwoberlin.weather.WeatherProvider;

public class JetPlane extends Aircraft {
    private static HashMap<String, String> msgMap = new HashMap<>();

    static {
        msgMap.put("SUN", "Soaring through the sunlit skies, I feel unstoppable!");
        msgMap.put("RAIN", "Raindrops race past my wings as I cut through the clouds.");
        msgMap.put("FOG", "Even in the fog, my engines roar with confidence.");
        msgMap.put("SNOW", "Snowflakes dance around me as I glide through the winter air.");
    }

    public JetPlane( long p_id, String p_name, Coordinates p_coordinate ) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

        Logger.log("JetPlane #" + getName() + " (" + getId() + "): " + msgMap.get(weather));
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
