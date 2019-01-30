package simulator;

import exceptions.*;
import aircrafts.*;
import logger.*;
import java.io.*;

class Main {
    private static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) {
        try {
            if (args.length == 1) {
                File file = new File(args[0]);
                FileReader rd = new FileReader(file);
                BufferedReader br = new BufferedReader(rd);
                Integer numSim = 0;
                String line = null;

                if ((line = br.readLine()) != null)
                    numSim = Integer.valueOf(line);
                if (numSim < 1)
                    throw new InvalidArgException();
                while ((line = br.readLine()) != null) {
                    String[] array = line.split("\\s+");
                    if (array.length != 5) {
                        throw new InvalidArgException("Incorrect num of arguemtns");
                    }
                    Flyable f = AircraftFactory.newAircraft(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]));
                    if (f != null) {
                        f.registerTower(weatherTower);
                    }
                }
                for (Integer i = 1; i <= numSim; i++) {
                    Logger.getLogger().addLog("");
                    Logger.getLogger().addLog("Day" + i);
                    weatherTower.changeWeather();
                }
                Logger.getLogger().writeToFile();
                br.close();
            } else {
                throw new InvalidArgException("Incorrect number of args.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
