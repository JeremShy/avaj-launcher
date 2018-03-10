package com.avaj_launcher.simulator;

import com.avaj_launcher.input_output.Logger;
import com.avaj_launcher.interfaces.Flyable;

import java.io.IOException;
import java.util.ArrayList;

public class Simulator { //TODO : Faire le main.
	public static void main(String[] args) {
		try
		{
			Logger.setOutputFile("simulation.txt");
		} catch (IOException e)
		{
			System.out.println("Error : Can't open file simulation .txt for writing.");
			return ;
		}

		WeatherTower tower = new WeatherTower();
		ArrayList<Flyable> flyables = new ArrayList<Flyable>();
		AircraftFactory factory = new AircraftFactory();

		try
		{
			flyables.add(factory.newAircraft("Baloon", "B1", 0, 0, 30));
			flyables.add(factory.newAircraft("JetPlane", "J1", 1, 0, 40));
			flyables.add(factory.newAircraft("Helicopter", "H1", 2, 0, 50));
			flyables.add(factory.newAircraft("Baloon", "B2", 3, 0, 60));
		} catch( SimulatorException e) {

		}

		for (Flyable flyable: flyables)
			flyable.registerTower(tower);

		for (int i = 0; i < 25; i++)
		{
			tower.changeWeather();
		}
	}
}
