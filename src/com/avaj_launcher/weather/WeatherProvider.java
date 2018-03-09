package com.avaj_launcher.weather;

import java.util.ArrayList;

public class WeatherProvider {
    private WeatherProvider()
    {
    }

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

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
