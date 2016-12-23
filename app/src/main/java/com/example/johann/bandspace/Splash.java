package com.example.johann.bandspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash extends AppCompatActivity
{
    Button Recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent OpenMain = new Intent(Splash.this,MainActivity.class);
        startActivity(OpenMain);
    }
}
