package com.avaj_launcher;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	static long idCounter = 0;

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
