package com.avaj_launcher.machines;

import com.avaj_launcher.maths.Coordinates;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	private static long idCounter = 0;

	protected Aircraft(String arg_name, Coordinates arg_coordinates)
	{
		this.name = arg_name;
		this.coordinates = arg_coordinates;
		this.id = this.nextId();
	}

	private long nextId()
	{
		Aircraft.idCounter++;
		return Aircraft.idCounter - 1;
	}
}
