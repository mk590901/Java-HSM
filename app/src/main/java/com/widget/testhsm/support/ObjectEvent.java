package com.widget.testhsm.support;

public class ObjectEvent
{
	private int		event_	= 0x00;
	private Object	data_	= null;
	
	public ObjectEvent(int event, Object data)
	{
		event_	= event;
		data_	= data;
	}

	public	int Event()
	{
		return	event_;
	}

	public	Object Data()
	{
		return	data_;
	}
}
