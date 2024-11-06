package com.widget.testhsm.interfaces;

public interface IMediator {
	IHsm hsm		();
	void setHsm		(IHsm hsm);
	void hsmDone	(String state, int signal, Object data);
	void init		();
	void setLogger	(ILogger logger);	//	4 debug
	void execute	(String state, int signal, int data);
	void objDone	(int signal, Object data);
}
