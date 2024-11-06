//	Class Samek_9BContextObject: file automatically generated at 2024-11-06 11:47:31
package com.widget.testhsm.implementation;
import	com.widget.testhsm.interfaces.ILogger;
import	com.widget.testhsm.interfaces.IMediator;
import	com.widget.testhsm.interfaces.IObject;
import	com.widget.testhsm.support.ObjectEvent;

public class Samek_9BContextObject implements IObject {
	IMediator	mediator_;
	ILogger	logger_;

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
	public void done(ObjectEvent signal) {
		mediator_.objDone(signal.Event(), signal.Data());
	}

	@Override
	public void init() {
		mediator_.init();
	}

	@Override
	public IMediator mediator() {
		return mediator_;
	}

	@Override
	public void setMediator(IMediator mediator) {
		mediator_ = mediator;
	}

	public int getEventId(final String eventName) {
		int result = 0;
		switch(eventName) {
			case "b": result = b; break;
			case "a": result = a; break;
			case "d": result = d; break;
			case "h": result = h; break;
			case "g": result = g; break;
			case "e": result = e; break;
			case "c": result = c; break;
			case "f": result = f; break;
		}
		return result;
	}

	public boolean OnInit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "top-QHsmScheme.INIT_SIG" : "top-QHsmScheme.INIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS2Entry(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s2-QHsm.Q_ENTRY_SIG" : "s2-QHsm.Q_ENTRY_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS2Exit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s2-QHsm.Q_INIT_SIG" : "s2-QHsm.Q_INIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS2c(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s2-QHsmScheme.c" : "s2-QHsmScheme.c[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS2f(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s2-QHsmScheme.f" : "s2-QHsmScheme.f[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS21Entry(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s21-QHsm.Q_ENTRY_SIG" : "s21-QHsm.Q_ENTRY_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS21Exit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s21-QHsm.Q_INIT_SIG" : "s21-QHsm.Q_INIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS21b(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s21-QHsmScheme.b" : "s21-QHsmScheme.b[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS21h(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s21-QHsmScheme.h" : "s21-QHsmScheme.h[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS211Entry(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s211-QHsm.Q_ENTRY_SIG" : "s211-QHsm.Q_ENTRY_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS211Exit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s211-QHsm.Q_EXIT_SIG" : "s211-QHsm.Q_EXIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS211g(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s211-QHsmScheme.g" : "s211-QHsmScheme.g[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1Entry(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsm.Q_ENTRY_SIG" : "s1-QHsm.Q_ENTRY_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1Exit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsm.Q_INIT_SIG" : "s1-QHsm.Q_INIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1b(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsmScheme.b" : "s1-QHsmScheme.b[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1c(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsmScheme.c" : "s1-QHsmScheme.c[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1f(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsmScheme.f" : "s1-QHsmScheme.f[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1a(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsmScheme.a" : "s1-QHsmScheme.a[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS1d(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s1-QHsmScheme.d" : "s1-QHsmScheme.d[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS11Entry(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s11-QHsm.Q_ENTRY_SIG" : "s11-QHsm.Q_ENTRY_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS11Exit(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s11-QHsm.Q_EXIT_SIG" : "s11-QHsm.Q_EXIT_SIG[" + String.valueOf(data) + "]");
		return result;
	}

	public boolean OnS11g(Object data) {
		boolean result = false;
		logger_.trace(data == null ? "s11-QHsmScheme.g" : "s11-QHsmScheme.g[" + String.valueOf(data) + "]");
		return result;
	}
}
