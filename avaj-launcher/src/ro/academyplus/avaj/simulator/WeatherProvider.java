import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider  instance;
    private static final String[]   weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return (instance);
    }

    public String   getCurrentWeather( Coordinates p_coordinates ) {
        int seed = p_coordinates.getLatitude() + p_coordinates.getLongitude() + p_coordinates.getHeight();
        seed += new Random().nextInt(100);

        return (weather[seed % 4]);
    }
}
