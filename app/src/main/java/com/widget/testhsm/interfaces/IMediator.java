package com.widget.testhsm.interfaces;

public abstract class IMediator {
	abstract public	IHsm 		Hsm			();
	abstract public	void 		SetHsm		(IHsm hsm);
	abstract public void 		HsmDone		(String state, int signal, Object data); 
	abstract public void 		Init		();
	abstract public void 		SetLogger	(ILogger logger);	//	4 debug 
	abstract public void 		Execute		(String state, int signal, int data);
	abstract public void 		ObjDone		(int signal, Object data);
}

