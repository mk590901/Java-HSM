//	MediatorJavaCompileVisitor: file automatically generated at 2024-10-30 14:48:54
package com.widget.testhsm.implementation;

import com.widget.testhsm.hsm.QEvent;
import com.widget.testhsm.interfaces.IHsm;
import com.widget.testhsm.interfaces.ILogger;
import com.widget.testhsm.interfaces.IMediator;
import com.widget.testhsm.support.Command;
import com.widget.testhsm.support.Commands;
import com.widget.testhsm.support.Executor;
import com.widget.testhsm.support.Interceptor;
import com.widget.testhsm.support.SignalPairs;

public class Samek_9BMediator extends IMediator {
	private	IHsm	hsm_	= null;
	private	ILogger	logger_	= null;
	private	Commands	commands_	= null;
	private	SignalPairs	connector_	= null;
	private	Samek_9BContextObject	context_	= null;
	private	Interceptor	interceptor_	= null;
	public Samek_9BMediator(Samek_9BContextObject context, Interceptor interceptor, ILogger logger) {
		logger_ = logger;
		context_ = context;
		interceptor_ = interceptor;
		context_.SetMediator(this);
		createCommands	();
		createConnector	();
	}


	private void createConnector() {
		connector_ = new SignalPairs();
		connector_.Add(Samek_9BContextObject.	INIT,	Samek_9BQHsmScheme.INIT);
		connector_.Add(Samek_9BContextObject.	FINAL,	Samek_9BQHsmScheme.FINAL);
		connector_.Add(Samek_9BContextObject.	b,	Samek_9BQHsmScheme.b);
		connector_.Add(Samek_9BContextObject.	a,	Samek_9BQHsmScheme.a);
		connector_.Add(Samek_9BContextObject.	d,	Samek_9BQHsmScheme.d);
		connector_.Add(Samek_9BContextObject.	h,	Samek_9BQHsmScheme.h);
		connector_.Add(Samek_9BContextObject.	g,	Samek_9BQHsmScheme.g);
		connector_.Add(Samek_9BContextObject.	e,	Samek_9BQHsmScheme.e);
		connector_.Add(Samek_9BContextObject.	c,	Samek_9BQHsmScheme.c);
		connector_.Add(Samek_9BContextObject.	f,	Samek_9BQHsmScheme.f);
	}

	@Override
	public IHsm Hsm() {
		return hsm_;
	}

	@Override
	public void SetHsm(IHsm hsm) {
		hsm.SetMediator(this);
		hsm_ = hsm;
	}

	@Override
	public void HsmDone(String state, int signal, Object data) {
	}

	@Override
	public void Init() {
			logger_.clear("[INIT]: ");
		hsm_.Init();
			logger_.printTrace();
	}

	@Override
	public void SetLogger(ILogger logger) {
		logger_ = logger;
	}

	@Override
	public void ObjDone(int signal, Object objectData) {
		int hsmEvt = EventObj2Hsm(signal);
		int	data	= interceptor_.PutTicket(objectData);
		QEvent e	= new QEvent(hsmEvt, data);
			logger_.clear(DecodeSignal(hsmEvt) + ": ");
		hsm_.Dispatch(e);
			logger_.printTrace();
	}

	public void SetInterceptor(Interceptor interceptor) {
		interceptor_ = interceptor;
	}

	private int EventObj2Hsm(int objectSignal) {
		return	connector_.Get(objectSignal);
	}

	private String DecodeSignal(int signal) {
		String	result = "?Signal";
		switch(signal) {
			case Samek_9BQHsmScheme.Q_EMPTY_SIG: result = "@Q_EMPTY_SIG"; break;
			case Samek_9BQHsmScheme.Q_INIT_SIG: result = "@Q_INIT_SIG"; break;
			case Samek_9BQHsmScheme.Q_ENTRY_SIG: result = "@Q_ENTRY_SIG"; break;
			case Samek_9BQHsmScheme.Q_EXIT_SIG: result = "@Q_EXIT_SIG"; break;
			case Samek_9BQHsmScheme.INIT: result = "@INIT"; break;
			case Samek_9BQHsmScheme.FINAL: result = "@FINAL"; break;
			case Samek_9BQHsmScheme.b: result = "@b"; break;
			case Samek_9BQHsmScheme.a: result = "@a"; break;
			case Samek_9BQHsmScheme.d: result = "@d"; break;
			case Samek_9BQHsmScheme.h: result = "@h"; break;
			case Samek_9BQHsmScheme.g: result = "@g"; break;
			case Samek_9BQHsmScheme.e: result = "@e"; break;
			case Samek_9BQHsmScheme.c: result = "@c"; break;
			case Samek_9BQHsmScheme.f: result = "@f"; break;
		}
		return	result;
	}

	@Override
	public void Execute(String state, int signal, int ticket) {
		Command command = commands_.Get(state, signal);
		if (command == null) {
			Object data = interceptor_.GetTicket(ticket);
			if (data == null) {
				logger_.trace(String.format("%s-%s", state, DecodeSignal(signal)));
			}
			else {
				logger_.trace(String.format("%s-%s[%s]", state, DecodeSignal(signal), String.valueOf(data)));
			}
		}
		else {
			boolean result = command.executor_.Execute(signal, ticket);
		}
	}

	public void createCommands() {
		try {
			commands_ = new Commands();
			commands_.Add("init",	Samek_9BQHsmScheme.INIT,  new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnInit(value);
							return	true;
						}
					}
			);

			commands_.Add("s2",	Samek_9BQHsmScheme.Q_ENTRY_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS2Entry(value);
							return	true;
						}
					}
			);
			commands_.Add("s2",	Samek_9BQHsmScheme.Q_EXIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS2Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s2",	Samek_9BQHsmScheme.Q_INIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS2Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s2",	Samek_9BQHsmScheme.c, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS2c(value);
							return	true;
						}
					}
			);
			commands_.Add("s2",	Samek_9BQHsmScheme.f, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS2f(value);
							return	true;
						}
					}
			);

			commands_.Add("s21",	Samek_9BQHsmScheme.Q_ENTRY_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS21Entry(value);
							return	true;
						}
					}
			);
			commands_.Add("s21",	Samek_9BQHsmScheme.Q_EXIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS21Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s21",	Samek_9BQHsmScheme.Q_INIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS21Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s21",	Samek_9BQHsmScheme.b, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS21b(value);
							return	true;
						}
					}
			);
			commands_.Add("s21",	Samek_9BQHsmScheme.h, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS21h(value);
							return	true;
						}
					}
			);

			commands_.Add("s211",	Samek_9BQHsmScheme.Q_ENTRY_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS211Entry(value);
							return	true;
						}
					}
			);
			commands_.Add("s211",	Samek_9BQHsmScheme.Q_EXIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS211Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s211",	Samek_9BQHsmScheme.g, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS211g(value);
							return	true;
						}
					}
			);

			commands_.Add("s1",	Samek_9BQHsmScheme.Q_ENTRY_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1Entry(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.Q_EXIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.Q_INIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.b, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1b(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.c, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1c(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.f, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1f(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.a, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1a(value);
							return	true;
						}
					}
			);
			commands_.Add("s1",	Samek_9BQHsmScheme.d, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS1d(value);
							return	true;
						}
					}
			);

			commands_.Add("s11",	Samek_9BQHsmScheme.Q_ENTRY_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS11Entry(value);
							return	true;
						}
					}
			);
			commands_.Add("s11",	Samek_9BQHsmScheme.Q_EXIT_SIG, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS11Exit(value);
							return	true;
						}
					}
			);
			commands_.Add("s11",	Samek_9BQHsmScheme.g, new Executor() {
						public boolean	Execute (int signal, int ticket) {
							Object value = interceptor_.GetTicket(ticket);
							context_.OnS11g(value);
							return	true;
						}
					}
			);
		}
		catch(Exception exception) {
		}
	}
}
