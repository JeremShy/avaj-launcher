package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

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
			System.out.println("Error 23");
			return ;
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
			this.orderMove();
		}
	}

	public void registerTower(WeatherTower arg_weatherTower)
	{
		arg_weatherTower.register(this);
		this.weatherTower = arg_weatherTower;
	}

	private void orderMove()
	{
		Coordinates newCoords;
		if (this.actualWeather == "SUN")
			newCoords = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
		else if (this.actualWeather == "RAIN")
			newCoords = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
		else if (this.actualWeather == "FOG")
			newCoords = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
		move(newCoords);
	}

	protected void land()
	{
		this.log("Helicopter", "landing. - Coordinates : (" + coordinates.getLongitude() + ", "
				+ coordinates.getLatitude() + ", "
				+ coordinates.getHeight()
				+ ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
