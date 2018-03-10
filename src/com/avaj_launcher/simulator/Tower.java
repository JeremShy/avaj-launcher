package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;
import java.util.ArrayList;

public abstract class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable)
	{
		System.out.println("New flyable added with name");
		observers.add(flyable);
	}

	public  void unregister(Flyable flyable)
	{
		observers.remove(flyable);
	}

	protected void conditionsChanged()
	{
		System.out.println("In  conditions changed");
		for(int i = 0; i < observers.size(); i++)
		{
			observers.get(i).updateConditions();
		}
	}
}
