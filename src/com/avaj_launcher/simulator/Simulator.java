package com.avaj_launcher.simulator;

import com.avaj_launcher.input_output.Logger;
import com.avaj_launcher.machine_abstract.Flyable;

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

		flyables.add(factory.newAircraft("Baloon", "B1", 0, 0, 0));
		flyables.add(factory.newAircraft("JetPlane", "J1", 1, 0, 0));
		flyables.add(factory.newAircraft("Helicopter", "H1", 2, 0, 0));
		flyables.add(factory.newAircraft("Baloon", "B2", 3, 0, 0));

		for (Flyable flyable: flyables)
			flyable.registerTower(tower);

		for (int i = 0; i < 2; i++)
		{
			tower.changeWeather();
		}
	}
}
