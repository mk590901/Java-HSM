package com.widget.testhsm;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.widget.testhsm.hsm.QEvent;
import com.widget.testhsm.implementation.Samek_9BContextObject;
import com.widget.testhsm.implementation.Samek_9BMediator;
import com.widget.testhsm.implementation.Samek_9BQHsmScheme;
import com.widget.testhsm.support.Interceptor;
import com.widget.testhsm.support.Logger;

public class MainActivity extends AppCompatActivity {

    final String TAG = "hsm";

    //private IMediator	mediator_ 	= null;
    private Samek_9BQHsmScheme hsmStateMachine = null;
    private Samek_9BMediator mediator = null;
    private Samek_9BContextObject contextObject = null;
    private Logger logger = new Logger();
    private Interceptor interceptor = new Interceptor();
    ;
    private boolean init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupLayout();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initStateMachine() {
        Log.d(TAG,"initStateMachine");
        contextObject = new Samek_9BContextObject(logger);
        mediator = new Samek_9BMediator(contextObject, interceptor, logger);
        hsmStateMachine = new Samek_9BQHsmScheme(mediator, logger);
        hsmStateMachine.init(new QEvent(Samek_9BQHsmScheme.INIT));
    }

    private void setupLayout() {
        TextView press = findViewById(R.id.press);
        press.setOnClickListener(v -> {
            Log.d(TAG,"done press");
            if (!init) {
                initStateMachine();
                init = true;
            }
            else {
                hsmStateMachine.dispatch(new QEvent(Samek_9BQHsmScheme.f));
            }
        });
    }
}