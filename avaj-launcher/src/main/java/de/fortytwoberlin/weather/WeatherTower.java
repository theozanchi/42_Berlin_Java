package main.java.de.fortytwoberlin.weather;

import main.java.de.fortytwoberlin.tower.Tower;
import main.java.de.fortytwoberlin.coordinates.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}
