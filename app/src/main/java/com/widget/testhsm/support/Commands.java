package com.widget.testhsm.support;

import java.util.Hashtable;

public class Commands
{
	private Hashtable<String,Command>
		container_ 	= new Hashtable<String,Command>()
	;
	public	int Number()
	{
		return	container_.size();
	}
	
	public	boolean	Add	(String state, int signal, Executor executor)
	{
		boolean	result = false
		;
		String	key = GetKey(state,signal);
		if (container_.containsKey(key))
			return	result
		;
		try
		{
			container_.put(key, new Command(state, signal, executor));
			result = true;
		}
		catch(Exception exception)
		{
		}
		return	result;
	}

	public	Command	Get(String state, int signal)
	{
		Command	result = null;
		String	key = GetKey(state,signal);
		if (!container_.containsKey(key))
			return	result
		;
		result	= container_.get(key)
		;
		return	result;
	}
	
	public String GetKey(String state, int signal)
	{
		String	result = state + "$" + Integer.toString(signal);
		return	result;
	}
}
