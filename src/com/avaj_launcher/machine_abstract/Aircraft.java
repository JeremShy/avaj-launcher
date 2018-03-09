package com.avaj_launcher.machine_abstract;

import com.avaj_launcher.input_output.Logger;
import com.avaj_launcher.simulator.Coordinates;

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

	protected void log(String type, String message)
	{
		String toLog = type + '#' + this.name + '(' + this.id + "): " + message;
		Logger.log(toLog);
	}
}
