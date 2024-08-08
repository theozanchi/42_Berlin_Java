package main.java.de.fortytwoberlin.simulator;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import main.java.de.fortytwoberlin.weather.*;
import main.java.de.fortytwoberlin.aircraft.*;
import main.java.de.fortytwoberlin.coordinates.*;

public class Simulator {
    private static BufferedReader   reader;
    private static String           line;
    private static WeatherTower     tower;
    private static int              loops;

    private static void initSimulation( File file ) throws SimulationException {
        try {
            reader = new BufferedReader(new FileReader(file));
            loops = Integer.parseInt(reader.readLine());
            tower = new WeatherTower();

        } catch (IOException e) {
            throw (new SimulationException(e));
        }
    }

    private static void loadFlyables( ) throws SimulationException {
        String[] flyableInfos;
        
        try {
            while ( (line = reader.readLine()) != null ) {
                flyableInfos = line.split(" ");
                AircraftFactory.getInstance().newAircraft(
                    flyableInfos[0],
                    flyableInfos[1],
                    new Coordinates(Integer.parseInt(flyableInfos[2]),
					                Integer.parseInt(flyableInfos[3]),
                                    Integer.parseInt(flyableInfos[4]))
                ).registerTower(tower);
            }
            reader.close();
        } catch (IOException e) {
            throw (new SimulationException(e));
        }
    }

    public static void main( String[] aStrings ) {
        if ( aStrings.length < 1 ) {
            return;
        }
        try {
            initSimulation(new File(aStrings[0]));
            loadFlyables();

        } catch (SimulationException e) {
            System.out.println(e.getMessage());
            return;
        }

        while ( loops-- > 0 ) {
            Logger.getInstance().log("Loop #" + loops);
            tower.changeWeather();
        }
    }
}
