package com.avaj_launcher.simulator;

import com.avaj_launcher.machine_abstract.Flyable;

import java.util.ArrayList;

public class Simulator {
	public static void main(String[] args) {
		System.out.println("Coucou! pouet ");

		WeatherTower tower = new WeatherTower();
		ArrayList<Flyable> flyables = new ArrayList<Flyable>();
		AircraftFactory factory = new AircraftFactory();

		flyables.add(factory.newAircraft("Balloon", "B1", 0, 0, 0));
		flyables.add(factory.newAircraft("JetPlane", "J1", 1, 0, 0));
		flyables.add(factory.newAircraft("Helicopter", "H1", 2, 0, 0));
		flyables.add(factory.newAircraft("Balloon", "B2", 3, 0, 0));

		for (Flyable flyable: flyables)
			flyable.registerTower(tower);

		for (int i = 0; i < 2; i++)
		{
			tower.changeWeather();
		}
	}
}
