package com.widget.testhsm.support;

public class Command
{
	private String		state_ = "";
	private	int			signal_= 0;
	public	Executor	executor_;
	
	public Command(String state, int signal, Executor executor)
	{
		state_		= state;
		signal_		= signal;
		executor_	= executor;
	}
	
}
