package com.example.johann.bandspace;
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.johann.bandspace.R.styleable.AlertDialog;

public class MainActivity extends AppCompatActivity
{
    private MediaRecorder myRecorder;
    private MediaPlayer myPlayer;
    private String outputFile = null;
    private Button startBtn;
    private Button stopBtn;
    private Button playBtn;
    private Button stopPlayBtn;
    private TextView text;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        text = (TextView) findViewById(R.id.text1);
        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/BandSpace.3gpp";

        myRecorder = new MediaRecorder();
        myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        myRecorder.setOutputFile(outputFile);

        startBtn = (Button) findViewById(R.id.BtnRecord);
        startBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Recorder StarRecording = new Recorder();
                StarRecording.start(v);
            }
        });

        stopBtn = (Button) findViewById(R.id.BtnStop);
        stopBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Recorder StopRecording = new Recorder();
                StopRecording.stop(v);
            }
        });

        playBtn = (Button) findViewById(R.id.fabPlay);
        playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Recorder PlayRecording = new Recorder();
                PlayRecording.play(v);
            }
        });

        stopPlayBtn = (Button) findViewById(R.id.BtnStop);
        stopPlayBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Recorder StopPlay = new Recorder();
                StopPlay.stopPlay(v);
            }
        });

    }

}
