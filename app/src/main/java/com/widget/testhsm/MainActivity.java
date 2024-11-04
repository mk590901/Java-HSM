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

    private Samek_9BQHsmScheme hsmStateMachine = null;
    private Samek_9BMediator mediator = null;
    private Samek_9BContextObject contextObject = null;
    private Samek_9BWrapper wrapper = null;
    private Logger logger = new Logger();
    private GuiLogger contextLogger = new GuiLogger(this);
    private Interceptor interceptor = new Interceptor();

    private StringAdapter stringAdapter;
    RecyclerView verticalRecyclerView;
    private List<String> stringList;

    private boolean init = false;

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
        mediator = new Samek_9BMediator(contextObject, interceptor, /*logger*/contextLogger);
        hsmStateMachine = new Samek_9BQHsmScheme(mediator, logger);
        wrapper = new Samek_9BWrapper(hsmStateMachine, mediator);
        //@hsmStateMachine.init(new QEvent(Samek_9BQHsmScheme.INIT));   //  Ok
        //@wrapper.Init(); //  Ok
        //@contextObject.Init();

    }

    private void initStateMachine() {
        contextObject.Init();
    }

    private void setupLayout() {
        TextView press = findViewById(R.id.press);
        press.setOnClickListener(v -> {
            Log.d(TAG,"done press");
            if (!init) {
                createStateMachine();
                init = true;
            }
            else {
                //@hsmStateMachine.dispatch(new QEvent(Samek_9BQHsmScheme.f));  // Ok
                //@wrapper.Dispatch(new QEvent(Samek_9BQHsmScheme.f)); // Ok
                contextObject.Done(new ObjectEvent(Samek_9BContextObject.f,'f'));
            }
        });

        /*RecyclerView*/ verticalRecyclerView = findViewById(R.id.verticalRecyclerView);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

//        stringList = new ArrayList<>(Arrays.asList(
//                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
//                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"
//        ));

        stringList = new ArrayList<>();

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