package aircrafts;

import logger.*;
import simulator.*;

public class JetPlane extends Aircraft implements Flyable {
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String current = "JetPlane#" + this.name + "(" + this.id + ")";

        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2
                );
                Logger.getLogger().addLog(current + ": Yo, co-pilot hand me a water!");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getHeight()
                );
                Logger.getLogger().addLog(current + ": Attention passengers, there is lightning.");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getHeight()
                );
                Logger.getLogger().addLog(current + ": good thing we have gps.. cause I can't see ****.");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() - 7,
                        this.coordinates.getHeight()
                );
                Logger.getLogger().addLog(current + ": Heater and defroster activate!!");
                break;
        }

        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().addLog(current + " landing.");
            this.weatherTower.unregister(this);
            Logger.getLogger().addLog("Tower says: " + current + " unregistered from the weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.getLogger().addLog("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

    private WeatherTower weatherTower;
}

