package com.avaj_launcher.simulator;

public final class WeatherProvider {
    private WeatherProvider()
    {
    }

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static final String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getProvider()
    {
      return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        // TODO
		int idx = (coordinates.getLongitude() + coordinates.getHeight() + coordinates.getLatitude()) % 4;
        return (weather[idx]);
    }
}
