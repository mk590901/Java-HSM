package com.widget.testhsm.support;

public class Command {
	final private 	String		state_;
	final private	int			signal_;
	final public	Executor	executor_;
	
	public Command(String state, int signal, Executor executor) {
		state_		= state;
		signal_		= signal;
		executor_	= executor;
	}
	
}
