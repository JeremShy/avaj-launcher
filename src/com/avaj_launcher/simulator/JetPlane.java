package com.avaj_launcher.simulator;

import com.avaj_launcher.machine_abstract.Aircraft;
import com.avaj_launcher.machine_abstract.Flyable;

public final class JetPlane extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	protected WeatherTower weatherTower = null;

	JetPlane(String arg_name, Coordinates arg_coordinates)
	{
		super(arg_name, arg_coordinates);
	}

	public void updateConditions()
	{
		System.out.println("Updating JetPlane condition");
		if (this.weatherTower == null)
		{
			//TODO : Throw an error when no weather tower assigned. Shouldn't happen though.
		}
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || actualWeather != newWeather)
		{
			actualWeather = newWeather;
			//TODO : Print funny message according to the new weather conditions.
		}
	}

	public void registerTower(WeatherTower arg_weatherTower)
	{
		arg_weatherTower.register(this);
		this.weatherTower = arg_weatherTower;
	}

	private void move()
	{
		//TODO : Move according to weather.
	}
}
