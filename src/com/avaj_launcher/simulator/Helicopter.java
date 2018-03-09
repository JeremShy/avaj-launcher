package com.avaj_launcher.simulator;

import com.avaj_launcher.machine_abstract.Aircraft;
import com.avaj_launcher.machine_abstract.Flyable;

public final class Helicopter extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	protected WeatherTower weatherTower = null;

	Helicopter(String arg_name, Coordinates arg_coordinates)
	{
		super(arg_name, arg_coordinates);
	}

	public void updateConditions()
	{
		System.out.println("Updating helicopter condition");
		if (this.weatherTower == null)
		{
			//TODO : Throw an error when no weather tower assigned. Shouldn't happen though.
		}
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || actualWeather != newWeather)
		{
			actualWeather = newWeather;
			if (actualWeather == "SUN")
				this.log("Helicopter", "Wow, it's hot. My rotating motor is going to explode..........");
			else if (actualWeather == "SNOW")
				this.log("Helicopter", "Brrrrr.... It's freezing !");
			else if (actualWeather == "RAIN")
				this.log("Helicopter", "HELP IT'S RAINING BLBLBLBLBL");
			else if (actualWeather == "FOG")
				this.log("Helicopter", "I can't see anything two meters in front of me..");
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
