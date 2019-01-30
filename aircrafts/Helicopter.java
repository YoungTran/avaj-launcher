package aircrafts;

import simulator.*;
import logger.*;

public class Helicopter extends Aircraft implements Flyable {
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String current = "Helicopter#" + this.name + "(" + this.id + ")";

        switch(weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 10,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 2
                );
                Logger.getLogger().addLog(current + ": Turning on the AC boys!");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 5,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                Logger.getLogger().addLog(current + ": Helicopter wipers on!");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 1,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                Logger.getLogger().addLog(current + ": I can't see ****!!");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 12
                );
                Logger.getLogger().addLog(current + ": My rotor is going to freeze!");
                break;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            Logger.getLogger().addLog(current + " landing.");
            this.weatherTower.unregister(this);
            Logger.getLogger().addLog("Tower says: " + current + " unregistered from the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.getLogger().addLog("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

    private WeatherTower weatherTower;
}