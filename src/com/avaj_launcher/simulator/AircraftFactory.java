package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int latitude, int longitude, int height) throws SimulatorException {
		Coordinates coordinates = new Coordinates(latitude, longitude, height);
		if (type == "Baloon")
		{
			return new Baloon(name, coordinates);
		}
		else if (type == "JetPlane")
		{
			return new JetPlane(name, coordinates);
		}
		else if (type == "Helicopter")
		{
			return new Helicopter(name, coordinates);
		}
		else
		{
			throw new SimulatorException("Syntax error : Unknown type [" + type + "]");
		}
	}
}
