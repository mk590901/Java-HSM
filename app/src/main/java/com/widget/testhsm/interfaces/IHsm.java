package com.widget.testhsm.interfaces;

import com.widget.testhsm.hsm.QEvent;

public abstract class IHsm {
	abstract public	IMediator 	Mediator	();
	abstract public	void 		SetMediator	(IMediator mediator);
	abstract public void 		Init		(); 
	abstract public void 		Dispatch	(QEvent event); 
}
