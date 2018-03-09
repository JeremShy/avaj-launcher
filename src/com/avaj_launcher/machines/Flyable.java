package com.avaj_launcher.machines;

import com.avaj_launcher.weather.WeatherTower;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
