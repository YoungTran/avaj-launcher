package weatherprovider;

import aircrafts.*;
import java.util.Random;
import java.lang.Math;

public final class WeatherProvider {
    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        return (weather[Math.abs(new Random().nextInt()) % 4]);
    }
    private static WeatherProvider weatherProvider;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

}