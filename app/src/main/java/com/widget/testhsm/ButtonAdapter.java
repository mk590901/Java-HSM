package com.widget.testhsm;// ButtonAdapter.java
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.widget.testhsm.implementation.Samek_9BContextObject;
import com.widget.testhsm.support.ObjectEvent;

import java.util.List;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    final String TAG = "hsm";

    private final List<String> buttonTexts;
    private final Samek_9BContextObject contextObject;

    public ButtonAdapter(List<String> buttonTexts, Samek_9BContextObject contextObject) {
        this.buttonTexts = buttonTexts;
        this.contextObject = contextObject;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_button, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        final String text = buttonTexts.get(position);
        final String event = text.toLowerCase();
        final int eventId = contextObject.getEventId(event);
        holder.button.setText(text);
        holder.button.setOnClickListener(v -> {
            Log.d(TAG, "->[" + event + " = " + eventId + "]");
            contextObject.done(new ObjectEvent(eventId, event));
        });
    }

    @Override
    public int getItemCount() {
        return buttonTexts.size();
    }

    static class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            button = (Button)itemView;
        }
    }
}
