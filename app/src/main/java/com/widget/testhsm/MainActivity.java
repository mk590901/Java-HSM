package com.widget.testhsm;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.widget.testhsm.implementation.Samek_9BContextObject;
import com.widget.testhsm.implementation.Samek_9BMediator;
import com.widget.testhsm.implementation.Samek_9BQHsmScheme;
import com.widget.testhsm.implementation.Samek_9BWrapper;
import com.widget.testhsm.support.GuiLogger;
import com.widget.testhsm.support.Interceptor;
import com.widget.testhsm.support.Logger;
import com.widget.testhsm.support.ObjectEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String TAG = "hsm";

    private Samek_9BQHsmScheme hsmStateMachine;
    private Samek_9BMediator mediator;
    private Samek_9BContextObject contextObject;
    private Samek_9BWrapper wrapper;
    private final Logger logger = new Logger();
    private final GuiLogger contextLogger = new GuiLogger(this);
    private final Interceptor interceptor = new Interceptor();

    private StringAdapter stringAdapter;
    private RecyclerView verticalRecyclerView;

    private final List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        createStateMachine();
        setupLayout();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initStateMachine();
    }

    private void createStateMachine() {
        Log.d(TAG,"initStateMachine");
        contextObject = new Samek_9BContextObject(contextLogger);
        mediator = new Samek_9BMediator(contextObject, interceptor, contextLogger);
        hsmStateMachine = new Samek_9BQHsmScheme(mediator, logger);
        wrapper = new Samek_9BWrapper(hsmStateMachine, mediator);
    }

    private void initStateMachine() {
        contextObject.init();
    }

    private void setupLayout() {

        verticalRecyclerView = findViewById(R.id.verticalRecyclerView);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        // Add dividers to the verticalRecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        verticalRecyclerView.addItemDecoration(dividerItemDecoration);

        //stringList = new ArrayList<>();

        stringAdapter = new StringAdapter(stringList);
        verticalRecyclerView.setAdapter(stringAdapter);

        RecyclerView horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView);
        horizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<String> buttonTexts = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
        ButtonAdapter buttonAdapter = new ButtonAdapter(buttonTexts, contextObject);
        horizontalRecyclerView.setAdapter(buttonAdapter);

        // Enable swipe-to-dismiss
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                stringAdapter.removeString(position);
            }
        });
        itemTouchHelper.attachToRecyclerView(verticalRecyclerView);
    }

    public void addStringToRecyclerView(String newString) {
        stringAdapter.addString(newString);
        verticalRecyclerView.scrollToPosition(stringAdapter.getItemCount() - 1);
    }

}