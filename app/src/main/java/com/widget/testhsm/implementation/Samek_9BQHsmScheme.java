//	SchemeJavaCompileVisitor: file automatically generated at 2024-10-30 14:48:54
package com.widget.testhsm.implementation;

import com.widget.testhsm.hsm.QHsm;
import com.widget.testhsm.hsm.QEvent;
import com.widget.testhsm.interfaces.ILogger;
import com.widget.testhsm.interfaces.IMediator;

public class Samek_9BQHsmScheme extends QHsm {

	public  ILogger	logger_	= null;
	private IMediator	mediator_	= null;

	public static final int	INIT	= QHsm.Q_USER_SIG;
	public static final int FINAL 	= QHsm.Q_USER_SIG + 1;
	public static final int	 b	= QHsm.Q_USER_SIG + 2;
	public static final int	 a	= QHsm.Q_USER_SIG + 3;
	public static final int	 d	= QHsm.Q_USER_SIG + 4;
	public static final int	 h	= QHsm.Q_USER_SIG + 5;
	public static final int	 g	= QHsm.Q_USER_SIG + 6;
	public static final int	 e	= QHsm.Q_USER_SIG + 7;
	public static final int	 c	= QHsm.Q_USER_SIG + 8;
	public static final int	 f	= QHsm.Q_USER_SIG + 9;

	public Samek_9BQHsmScheme(IMediator mediator, ILogger logger) {
		mediator_	= mediator;
		logger_ 	= logger;
	}

	protected QState	s0State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s0", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s0", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_INIT_SIG: {
					mediator_.Execute("s0", event.sig_, event.ticket_);
					Q_TRAN(s1State);
					return	null;
				}
				case e: {
					mediator_.Execute("s0", event.sig_, event.ticket_);
					Q_TRAN(s211State);
					return	null;
				}
			}
			return	QHsm.top;
		}
	};

	public void init(QEvent event) {
		mediator_.Execute("init", event.sig_, 0);
		super.init_tran(s0State);
	}

	protected QState	s2State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s2", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s2", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_INIT_SIG: {
					mediator_.Execute("s2", event.sig_, event.ticket_);
					Q_TRAN(s21State);
					return	null;
				}
				case c: {
					mediator_.Execute("s2", event.sig_, event.ticket_);
					Q_TRAN(s1State);
					return	null;
				}
				case f: {
					mediator_.Execute("s2", event.sig_, event.ticket_);
					Q_TRAN(s11State);
					return	null;
				}
			}
			return	s0State;
		}
	};

	protected QState	s21State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s21", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s21", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_INIT_SIG: {
					mediator_.Execute("s21", event.sig_, event.ticket_);
					Q_TRAN(s211State);
					return	null;
				}
				case b: {
					mediator_.Execute("s21", event.sig_, event.ticket_);
					Q_TRAN(s211State);
					return	null;
				}
				case h: {
					mediator_.Execute("s21", event.sig_, event.ticket_);
					Q_TRAN(s21State);
					return	null;
				}
			}
			return	s2State;
		}
	};

	protected QState	s211State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s211", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s211", event.sig_, event.ticket_);
					return	null;
				}
				case g: {
					mediator_.Execute("s211", event.sig_, event.ticket_);
					Q_TRAN(s0State);
					return	null;
				}
			}
			return	s21State;
		}
	};

	protected QState	s1State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_INIT_SIG: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s11State);
					return	null;
				}
				case b: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s11State);
					return	null;
				}
				case c: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s2State);
					return	null;
				}
				case f: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s211State);
					return	null;
				}
				case a: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s1State);
					return	null;
				}
				case d: {
					mediator_.Execute("s1", event.sig_, event.ticket_);
					Q_TRAN(s0State);
					return	null;
				}
			}
			return	s0State;
		}
	};

	protected QState	s11State	= new QState() {
		public QState handler(QEvent event) {
			switch (event.sig_) {
				case QHsm.Q_ENTRY_SIG: {
					mediator_.Execute("s11", event.sig_, event.ticket_);
					return	null;
				}
				case QHsm.Q_EXIT_SIG: {
					mediator_.Execute("s11", event.sig_, event.ticket_);
					return	null;
				}
				case g: {
					mediator_.Execute("s11", event.sig_, event.ticket_);
					Q_TRAN(s211State);
					return	null;
				}
			}
			return	s1State;
		}
	};
}

