package com.avaj_launcher.weather;

import com.avaj_launcher.machines.Flyable;
import java.util.ArrayList;

public abstract class Tower {
	private ArrayList<Flyable> observers;

	public void register(Flyable flyable)
	{
		observers.add(flyable);
	}

	public  void unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}

	protected void conditionsChanged()
	{
		// TODO
	}
}
