package com.widget.testhsm.support;

import android.util.Log;

import com.widget.testhsm.MainActivity;
import com.widget.testhsm.interfaces.ILogger;

import java.util.ArrayList;
import java.util.List;

public class GuiLogger implements ILogger {

    final String TAG = "hsm";
    final List<String> _logger = new ArrayList<>();
    final MainActivity activity;

    public GuiLogger(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void trace(final String string) {
        _logger.add(string);
    }

    @Override
    public String string() {
        String result = "";
        for (int i = 0; i < _logger.size(); i++) {
            result += _logger.get(i) + ((i == (_logger.size() - 1) || (i == 0)) ? "" : ";");
        }
        return result;
    }

    @Override
    public String toTrace() {
        String result = "";
        if (_logger.size() < 2) {
            return result;
        }
        for (int i = 1; i < _logger.size(); i++) {
            result += _logger.get(i) + (i == (_logger.size() - 1) ? "" : " ");
        }
        return result;
    }

    @Override
    public void clear(final String label) {
        _logger.clear();
        if (!label.isEmpty()) {
            _logger.add(label);
        }
    }

    @Override
    public void printTrace() {
        String text = string();
        Log.d(TAG, text);
        activity.addStringToRecyclerView(text);
    }
}
