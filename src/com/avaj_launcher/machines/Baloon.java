package com.avaj_launcher.machines;

import com.avaj_launcher.maths.Coordinates;
import com.avaj_launcher.weather.WeatherTower;

public final class Baloon extends Aircraft implements  Flyable{
	Baloon(String arg_name, Coordinates arg_coordinates)
	{
		super(arg_name, arg_coordinates);
	}

	public void updateConditions()
	{

	}

	public void registerTower(WeatherTower arg_weatherTower)
	{

	}
}
