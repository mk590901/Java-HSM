package com.widget.testhsm.support;

import com.widget.testhsm.hsm.QHsm;
import java.util.Hashtable;

public class SignalPairs
{
	private Hashtable<Integer,Integer>
		container_ 	= new Hashtable<Integer,Integer>()
	;
	public	int Number()
	{
		return	container_.size();
	}

	public	boolean	Add	(int objectAction, int hsmSignal)
	{
		boolean	result = false
		;
		if (container_.containsKey(objectAction))
			return	result
		;
		try
		{
			container_.put(objectAction, hsmSignal);
			result = true;
		}
		catch(Exception exception)
		{
		}
		return	result;
	}
	
	public	int	Get(int objectAction)
	{
		int result = QHsm.Q_EMPTY_SIG;
		if (!container_.containsKey(objectAction))
			return	result
		;
		result	= container_.get(objectAction)
		;
		return	result;
	}
}
