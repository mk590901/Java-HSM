package com.widget.testhsm.support;

import java.util.Hashtable;

public class Commands {
	private final Hashtable<String,Command>
		container_ 	= new Hashtable<>();
	public	int number()
	{
		return	container_.size();
	}
	
	public	boolean add(String state, int signal, Executor executor) {
		boolean	result = false;
		String	key = getKey(state,signal);
		if (container_.containsKey(key))
			return	result;
		try {
			container_.put(key, new Command(state, signal, executor));
			result = true;
		}
		catch(Exception exception) {
		}
		return	result;
	}

	public	Command get(String state, int signal) {
		Command	result = null;
		String	key = getKey(state,signal);
		if (!container_.containsKey(key))
			return	result;
		result	= container_.get(key);
		return	result;
	}
	
	public String getKey(String state, int signal) {
		String	result = state + "$" + Integer.toString(signal);
		return	result;
	}
}
