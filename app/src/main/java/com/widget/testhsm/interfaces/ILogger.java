package com.widget.testhsm.interfaces;

public interface ILogger {
	void trace (final String string);
	String string  ();
	String toTrace ();
	void clear (final String label);
	void printTrace();
}
