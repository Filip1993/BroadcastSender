package com.filipkesteli.broadcastsender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSendBroadcast;

    private static final String INTENT_NAME = "com.filipkesteli.broadcastreceiver.Receiver";
    private static final String PARAMETER_NAME = "receiver.param";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);
    }

    private void setupListeners() {
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(INTENT_NAME);
                intent.putExtra(PARAMETER_NAME, getString(R.string.message_from_broadcast_receiver_app));
                sendBroadcast(intent);
            }
        });
    }
}
