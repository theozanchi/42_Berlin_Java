package main.java.de.fortytwoberlin.flyable;

import main.java.de.fortytwoberlin.weather.WeatherTower;

public abstract class Flyable {   
    protected   WeatherTower    weatherTower;

    public abstract void updateConditions();

    public void registerTower( WeatherTower weatherTower)  {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public abstract String getName();
    public abstract long getId();
}
