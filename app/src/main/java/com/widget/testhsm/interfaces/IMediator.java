package com.widget.testhsm.interfaces;

public interface IMediator {
	IHsm 		Hsm			();
	void 		SetHsm		(IHsm hsm);
	void 		HsmDone		(String state, int signal, Object data);
	void 		Init		();
	void 		SetLogger	(ILogger logger);	//	4 debug
	void 		Execute		(String state, int signal, int data);
	void 		ObjDone		(int signal, Object data);
}
