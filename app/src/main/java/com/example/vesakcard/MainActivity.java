package com.example.vesakcard;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private ImageButton soundbtn;




    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_MOVE) :
                startActivity(new Intent(MainActivity.this, greeting_page.class));
                return true;
            default :
                return super.onTouchEvent(event);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.song2);
        soundbtn =(ImageButton) findViewById(R.id.soundbutton);
        soundbtn.setOnClickListener(this);


        // hide activity bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }


    @Override
    public void onClick(View v) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            Toast.makeText(MainActivity.this, "song is paused", Toast.LENGTH_SHORT).show();
            soundbtn.setBackgroundResource(R.drawable._359138);

        }else{
            mediaPlayer.start();
            Toast.makeText(MainActivity.this, "song is playing", Toast.LENGTH_SHORT).show();
            soundbtn.setBackgroundResource(R.drawable.volume);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.pause();
        mediaPlayer.release();
    }
}