package main.java.de.fortytwoberlin.aircraft;

import java.util.HashMap;
import main.java.de.fortytwoberlin.coordinates.Coordinates;
import main.java.de.fortytwoberlin.simulator.Logger;
import main.java.de.fortytwoberlin.weather.WeatherProvider;

public class Baloon extends Aircraft {
    private static HashMap<String, String> msgMap = new HashMap<>();

    static {
        msgMap.put("SUN", "Basking in the sun, I shine like a star!");
        msgMap.put("RAIN", "Raindrops make me glisten with a magical charm.");
        msgMap.put("FOG", "Even in the fog, my vibrant colors peek through.");
        msgMap.put("SNOW", "Snowflakes tickle as they land on my surface.");
    }
    
    public Baloon( long p_id, String p_name, Coordinates p_coordinate ) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

        Logger.log("Baloon #" + getName() + " (" + getId() + "): " + msgMap.get(weather));
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
