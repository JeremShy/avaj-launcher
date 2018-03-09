package com.avaj_launcher.simulator;

import com.avaj_launcher.machine_abstract.Aircraft;
import com.avaj_launcher.machine_abstract.Flyable;

public final class Baloon extends Aircraft implements Flyable
{
	protected String actualWeather = null;
	protected WeatherTower weatherTower = null;

	Baloon(String arg_name, Coordinates arg_coordinates)
	{
		super(arg_name, arg_coordinates);
	}

	public void updateConditions()
	{
		System.out.println("Updating baloon condition");
		if (this.weatherTower == null)
		{
			//TODO : Throw an error when no weather tower assigned. Shouldn't happen though.
		}
		String newWeather = weatherTower.getWeather(coordinates);

		if (actualWeather == null || actualWeather != newWeather)
		{
			actualWeather = newWeather;
			if (actualWeather == "SUN")
				this.log("Baloon", "I have the sun in my eyes, it's not cool");
			else if (actualWeather == "SNOW")
				this.log("Baloon", "It's snowing, we're gonna crash !");
			else if (actualWeather == "RAIN")
				this.log("Baloon", "The experience is a bit ruined. You ever been in a hot air balloon under rain ?!");
			else if (actualWeather == "FOG")
				this.log("Baloon", "There is such a view up there... Too bad i can't see anything....");
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
