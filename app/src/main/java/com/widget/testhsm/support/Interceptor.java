package com.widget.testhsm.support;

import java.util.Hashtable;

public class Interceptor {
    public static final int INVALID_TICKET = -1;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    private int counter_ = 0;
    private Hashtable<Integer, Object> container_ = new Hashtable<Integer, Object>();

    public int PutTicket(Object object) {
        int result = INVALID_TICKET;
        if (object == null)
            return result;
        result = Generate();
        if (result == INVALID_TICKET)
            return result;
        if (container_.containsKey(result)) {
            result = INVALID_TICKET;
            return result;
        }
        try {
            container_.put(result, object);
        }
		catch (Exception exception) {
        }

        return result;
    }

    public Object GetTicket(int ticket) {
        Object result = null;
        if (!container_.containsKey(ticket))
            return result;
        result = container_.get(ticket);
        container_.remove(ticket);
        return result;
    }

    private int Generate() {
        if (counter_ == MAX_VALUE)
            counter_ = 0;
        return counter_++;
    }

    public int Size() {
        return container_.size();
    }
}
