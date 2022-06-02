package com.example.p2_practica6;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private GameSurfaceView pongSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pongSurfaceView = (GameSurfaceView) findViewById(R.id.game);
        pongSurfaceView.setTextView((TextView) findViewById(R.id.text));
    }
}