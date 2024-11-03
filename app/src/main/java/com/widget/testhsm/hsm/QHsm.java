package com.widget.testhsm.hsm;

public abstract class QHsm {
    private QState state_;
    private QState[] path_ = new QState[MAX_NEST_DEPTH];

    public static final int Q_EMPTY_SIG = 0;
    public static final int Q_INIT_SIG  = 1;
    public static final int Q_ENTRY_SIG = 2;
    public static final int Q_EXIT_SIG  = 3;
    public static final int Q_USER_SIG  = 4;

    private static final int MAX_NEST_DEPTH = 256;	//	6

    private static final QEvent EMPTY_EVT = new QEvent(Q_EMPTY_SIG);
    private static final QEvent INIT_EVT  = new QEvent(Q_INIT_SIG);
    private static final QEvent ENTRY_EVT = new QEvent(Q_ENTRY_SIG);
    private static final QEvent EXIT_EVT  = new QEvent(Q_EXIT_SIG);

    protected static interface QState {
        public abstract QState handler(QEvent e);
    }

    abstract public void init(QEvent e);

    protected void init_tran(QState initial) {
        state_ = initial;

        QState s = top;                      // an HSM starts in the top state
        do {                                       // drill into the target...
            byte ip = 0;                        // transition entry path index
            QState t = state_;
            path_[0] = t;
            for (t = t.handler(EMPTY_EVT); t != s; t = t.handler(EMPTY_EVT)) {
                path_[++ip] = t;
            }
            assert ip < MAX_NEST_DEPTH;        // entry path must not overflow
            do {       // retrace the entry path in reverse (desired) order...
                path_[ip].handler(ENTRY_EVT);               // enter path_[ip]
            } while (--ip >= 0);
            s = state_;
        } while (s.handler(INIT_EVT) == null);
    }

    protected static final QState top = new QState() {
        public QState handler(QEvent e) {
            return null;
        }
    };

    protected void Q_TRAN(QState target) {
        state_ = target;
    }

    public void dispatch(QEvent e) {
        QState s;
        QState t = state_;

        path_[1] = t;  // save the current state in case a transition is taken
        state_ = null;          // make sure that a transition will be noticed

        do {                            // process the event hierarchically...
            s = t;
            t = s.handler(e);        // invoke state handler through pointer s
        } while (t != null);

        if (state_ != null) {                             // transition taken?
            QState src = s;                    // the source of the transition
            byte ip = -1;                       // transition entry path index
            byte iq;                     // helper transition entry path index

            path_[0] = state_;         // save the new state (target of tran.)
            state_ = path_[1];                    // restore the current state

                     // exit current state to the transition source path_[1]...
            for (s = path_[1]; s != src; ) {
                t = s.handler(EXIT_EVT);
                if (t != null) {                      // exit action unhandled
                    s = t;                           // t points to superstate
                }
                else {                                  // exit action handled
                    s = s.handler(EMPTY_EVT);       // find out the superstate
                }
            }

            t = path_[0];

            if (src == t) {   // (a) check source==target (transition to self)
                src.handler(EXIT_EVT);                      // exit the source
                ip = 0;                                    // enter the target
            }
            else {
                t = t.handler(EMPTY_EVT);              // superstate of target
                if (src == t) {             // (b) check source==target->super
                    ip = 0;                                // enter the target
                }
                else {
                    s = src.handler(EMPTY_EVT);           // superstate of src
                    if (s == t) {    // (c) check source->super==target->super
                        src.handler(EXIT_EVT);              // exit the source
                        ip = 0;                            // enter the target
                    }
                    else {
                        if (s == path_[0]) {// (d) check source->super==target
                            src.handler(EXIT_EVT);          // exit the source
                        }
                        else {  // (e) rest of source==target->super->super...
                                // and store the entry path along the way

                            iq = 0;             // indicate that LCA not found
                            ip = 1;         // enter target and its superstate
                            path_[1] = t;     // save the superstate of target
                            t = t.handler(EMPTY_EVT);
                            while (t != null) {
                                path_[++ip] = t;       // store the entry path
                                if (t == src) {           // is it the source?
                                    iq = 1;         // indicate that LCA found
                                               // entry path must not overflow
                                    assert ip < MAX_NEST_DEPTH;
                                    --ip;           // do not enter the source
                                    t = null;            // terminate the loop
                                }
                                else {  // it is not the source, keep going up
                                    t = t.handler(EMPTY_EVT);
                                }
                            }
                            if (iq == 0) {           // the LCA not found yet?

                                               // entry path must not overflow
                                assert ip < MAX_NEST_DEPTH;

                                src.handler(EXIT_EVT);      // exit the source

                                     // (f) check the rest of source->super
                                     //             == target->super->super...

                                iq = ip;
                                do {
                                    if (s == path_[iq]) {  // is this the LCA?
                                        t = s;   // indicate that LCA is found
                                        ip = (byte)(iq - 1);//do not enter LCA
                                        iq = -1;         // terminate the loop
                                    }
                                    else {
                                        --iq;// try lower superstate of target
                                    }
                                } while (iq >= 0);

                                if (t == null) {         // LCA not found yet?
                                         // (g) check each source->super->...
                                         // for each target->super...

                                    do {
                                        t = s.handler(EXIT_EVT);     // exit s
                                        if (t != null) {         // unhandled?
                                            s = t;   // t points to super of s
                                        }
                                        else {          // exit action handled
                                            s = s.handler(EMPTY_EVT);
                                        }
                                        iq = ip;
                                        do {
                                            if (s == path_[iq]) {   // is LCA?
                                                           // do not enter LCA
                                                ip = (byte)(iq - 1);
                                                iq = -1;   // break inner loop
                                                s = null;  // break outer loop
                                            }
                                            else {
                                                --iq;
                                            }
                                        } while (iq >= 0);
                                    } while (s != null);
                                }
                            }
                        }
                    }
                }
            }
                       // retrace the entry path in reverse (desired) order...
            for (; ip >= 0; --ip) {
                path_[ip].handler(ENTRY_EVT);               // enter path_[ip]
            }
            s = path_[0];                    // stick the target into register
            state_ = s;                            // update the current state

                                         // drill into the target hierarchy...
            while (s.handler(INIT_EVT) == null) {
                t = state_;

                path_[0] = t;
                ip = 0;
                for (t = t.handler(EMPTY_EVT); t != s;
                     t = t.handler(EMPTY_EVT))
                {
                    path_[++ip] = t;
                }
                assert ip < MAX_NEST_DEPTH;    // entry path must not overflow

                do {   // retrace the entry path in reverse (correct) order...
                    path_[ip].handler(ENTRY_EVT);           // enter path_[ip]
                } while ((--ip) >= 0);
                s = state_;
            }
        }
        else {
            state_ = path_[1];                    // restore the current state
        }
    }
}
