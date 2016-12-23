package com.example.johann.bandspace;

/**
 * Created by Johann on 12/12/2016.
 */


import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Recorder
{

    private MediaRecorder myRecorder;
    private MediaPlayer myPlayer;
    private String outputFile = null;
    private Button startBtn;
    private Button stopBtn;
    private Button playBtn;
    private Button stopPlayBtn;
    private TextView text;




    public void start(View view)
    {
        try
        {
            myRecorder.prepare();
            myRecorder.start();
        }
        catch (IllegalStateException e)
        {

            e.printStackTrace();
        } catch (IOException e) {
            // prepare() fails
            e.printStackTrace();
        }

        text.setText("Recording Point: Recording");
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);

        Snackbar.make(view, "Recording Audio", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


    }

    public void stop(View view) {
        try {
            myRecorder.stop();
            myRecorder.release();
            myRecorder = null;

            stopBtn.setEnabled(false);
            playBtn.setEnabled(true);
            text.setText("Recording Point: Stop recording");


            Snackbar.make(view, "Recording Ended", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();


        } catch (IllegalStateException e) {
            //  it is called before start()
            e.printStackTrace();
        } catch (RuntimeException e) {
            // no valid audio/video data has been received
            e.printStackTrace();
        }
    }

    public void play(View view) {
        try {
            myPlayer = new MediaPlayer();
            myPlayer.setDataSource(outputFile);
            myPlayer.prepare();
            myPlayer.start();

            playBtn.setEnabled(false);
            stopPlayBtn.setEnabled(true);
            text.setText("Recording Point: Playing");

            Snackbar.make(view, "Listen Up", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void stopPlay(View view)
    {
        try {
            if (myPlayer != null) {
                myPlayer.stop();
                myPlayer.release();
                myPlayer = null;
                playBtn.setEnabled(true);
                stopPlayBtn.setEnabled(false);
                text.setText("Recording Point: Stop playing");

                Snackbar.make(view, "Stopping!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}