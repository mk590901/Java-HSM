package com.widget.testhsm.interfaces;

import com.widget.testhsm.hsm.QEvent;

public interface IHsm {
	IMediator 	mediator();
	void 		setMediator(IMediator mediator);
	void 		init();
	void 		dispatch(QEvent event);
}
