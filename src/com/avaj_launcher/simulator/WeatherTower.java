package com.avaj_launcher.simulator;

public final class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates)
	{
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather()
	{
		this.conditionsChanged();
	}
}
