package com.widget.testhsm.interfaces;
import com.widget.testhsm.support.ObjectEvent;

public abstract class IObject
{
	abstract	public 	void		Done		(ObjectEvent signal);
	abstract	public	IMediator	Mediator 	();
	abstract	public	void		SetMediator (IMediator mediator);
	abstract	public	void		Init		();
}
