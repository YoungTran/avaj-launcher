package aircrafts;

import simulator.*;
import logger.*;

public class Baloon extends Aircraft implements Flyable {
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String current = "Baloon#" + this.name + "(" + this.id + ")";

        switch(weatherTower.getWeather(this.coordinates)) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4
                );
                Logger.getLogger().addLog(current + ": Baloon is heating up!");
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5
                );
                Logger.getLogger().addLog(current + ": It's raining ! Good thing we in a baloon..");
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3
                );
                Logger.getLogger().addLog(current + ": I can't see **** hope my Baloon is okay..");
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15
                );
                Logger.getLogger().addLog(current + ": Its cold as **** in this baloon...");
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
        Logger.getLogger().addLog("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to the tower.");
    }

    private WeatherTower weatherTower;
}
