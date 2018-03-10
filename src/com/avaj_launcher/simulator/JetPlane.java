package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

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
			System.out.println("Error 21");
			return ;
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
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
		else if (this.actualWeather == "RAIN")
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
		else if (this.actualWeather == "FOG")
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
		else
			newCoords = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
		move(newCoords);
	}

	protected void land()
	{
		this.log("JetPlane", "landing. - Coordinates : (" + coordinates.getLongitude() + ", "
																		+ coordinates.getLatitude() + ", "
																		+ coordinates.getHeight()
		+ ") (lat, long, height).");
		this.weatherTower.unregister(this);
	}
}
