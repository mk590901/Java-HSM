package com.widget.testhsm.interfaces;

import com.widget.testhsm.hsm.QEvent;

public interface IHsm {
	IMediator 	Mediator	();
	void 		SetMediator	(IMediator mediator);
	void 		Init		();
	void 		Dispatch	(QEvent event);
}
