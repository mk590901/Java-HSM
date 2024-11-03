//	Class Samek_9BContextObject: file automatically generated at 2024-10-30 14:48:54
package com.widget.testhsm.implementation;
import com.widget.testhsm.interfaces.ILogger;
import com.widget.testhsm.interfaces.IMediator;
import com.widget.testhsm.interfaces.IObject;
import com.widget.testhsm.support.ObjectEvent;

public class Samek_9BContextObject extends IObject {
	IMediator	mediator_ = null;
	ILogger	logger_	= null;

	public	static	final	int	APP_START_ENUM	= 1;
	public	static	final	int	INIT	= APP_START_ENUM;
	public	static	final	int	FINAL	= APP_START_ENUM + 1;
	public	static	final	int	b	= APP_START_ENUM + 2;
	public	static	final	int	a	= APP_START_ENUM + 3;
	public	static	final	int	d	= APP_START_ENUM + 4;
	public	static	final	int	h	= APP_START_ENUM + 5;
	public	static	final	int	g	= APP_START_ENUM + 6;
	public	static	final	int	e	= APP_START_ENUM + 7;
	public	static	final	int	c	= APP_START_ENUM + 8;
	public	static	final	int	f	= APP_START_ENUM + 9;

	public Samek_9BContextObject(ILogger logger) {

		mediator_ = null;
		logger_	= logger;
	}

	@Override
	public void Done(ObjectEvent signal) {
		mediator_.ObjDone(signal.Event(), signal.Data());
	}

	@Override
	public void Init() {
		mediator_.Init();
	}

	@Override
	public IMediator Mediator() {
		return mediator_;
	}

	@Override
	public void SetMediator(IMediator mediator) {
		mediator_ = mediator;
	}


	public boolean OnInit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnInit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS2Entry(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS2Entry is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS2Exit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS2Exit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS2Init(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS2Init is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS2c(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS2c is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS2f(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS2f is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS21Entry(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS21Entry is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS21Exit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS21Exit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS21Init(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS21Init is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS21b(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS21b is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS21h(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS21h is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS211Entry(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS211Entry is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS211Exit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS211Exit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS211g(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS211g is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1Entry(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1Entry is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1Exit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1Exit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1Init(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1Init is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1b(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1b is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1c(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1c is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1f(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1f is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1a(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1a is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS1d(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS1d is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS11Entry(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS11Entry is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS11Exit(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS11Exit is done [%s]", String.valueOf(data)));
		return result;
	}

	public boolean OnS11g(Object data) {
		boolean result = false;
		logger_.print(String.format("OnS11g is done [%s]", String.valueOf(data)));
		return result;
	}
}
