package aircrafts;

import exceptions.*;

public abstract class AircraftFactory {
    private AircraftFactory() {}

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws BadAircraftException, MispelledBaloonException
    {
        Coordinates coordinates = null;
        coordinates = new Coordinates(longitude, latitude, height);

        try {
            switch(type) {
                case "Baloon":
                    return new Baloon(name, coordinates);
                case "Helicopter":
                    return new Helicopter(name, coordinates);
                case "JetPlane":
                    return new JetPlane(name, coordinates);
                default:
                    throw new BadAircraftException("Bad aircraft type");
            }
        } catch (Exception e) {
            System.out.println(e);
        } return null;
    }
}
