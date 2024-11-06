package com.widget.testhsm.interfaces;
import com.widget.testhsm.support.ObjectEvent;

public interface IObject {
	void 		done		(ObjectEvent signal);
	IMediator 	mediator	();
	void 		setMediator	(IMediator mediator);
	void 		init		();
}
