package com.widget.testhsm.hsm;

public class QEvent {
    public int sig_	= 0;
    public int ticket_ = 0;
    
    public QEvent() {
        sig_ 	= 0;
        ticket_ = 0;
    }
    
    public QEvent(int s) {
        sig_ 	= s;
        ticket_ = 0;
    }
    
    public QEvent(int s, int ticket) {
        sig_ 	= s;
        ticket_ = ticket;
    }
    
} 