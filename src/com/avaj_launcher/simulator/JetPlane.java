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
			if (actualWeather == "SUN")
				this.log("JetPlane", "IT'S SUNNY AND I AM GOING FAAAAST WOOOOOOOOOOW !!!!!!!!!!");
			else if (actualWeather == "SNOW")
				this.log("JetPlane", "It's beautiful !!!!");
			else if (actualWeather == "RAIN")
				this.log("JetPlane", "Well i can't see anything because of the rain but i guess it's cool to fly in a JetPlane anyway !");
			else if (actualWeather == "FOG")
				this.log("JetPlane", "Is there something in front of me ? My radar isn't working ! Do i have something to honk ?! Oh yes this ! WOW IT WAS THE EJECTABLE SEAT WOOOOOOW");
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
