package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

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
			System.out.println("Error 22");
			return ;
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
			newCoords = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
		else if (this.actualWeather == "RAIN")
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
		else if (this.actualWeather == "FOG")
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
		move(newCoords);
	}

	protected void land()
	{
		this.log("Baloon", "landing. - Coordinates : (" + coordinates.getLongitude() + ", "
				+ coordinates.getLatitude() + ", "
				+ coordinates.getHeight()
				+ ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
