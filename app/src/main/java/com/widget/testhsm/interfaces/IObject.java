package com.widget.testhsm.interfaces;
import com.widget.testhsm.support.ObjectEvent;

public interface IObject {
	void		Done		(ObjectEvent signal);
	IMediator	Mediator 	();
	void		SetMediator (IMediator mediator);
	void		Init		();
}
