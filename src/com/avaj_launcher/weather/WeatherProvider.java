package com.avaj_launcher.weather;

import com.avaj_launcher.maths.Coordinates;

public class WeatherProvider {
    private WeatherProvider()
    {
    }

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather;

    public static WeatherProvider getProvider()
    {
      return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        // TODO
        return ("TODO");
    }
}
