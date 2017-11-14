package com.ttth.model;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.util.Log;

import com.ttth.myequalize.R;

/**
 * Created by HangPC on 11/12/2017.
 */

public class MySong {
    private MediaPlayer mediaPlayer;

    public MySong(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.eyesonme);
        mediaPlayer.setLooping(true);

        Equalizer equalizer = new Equalizer(0, mediaPlayer.getAudioSessionId());
        Log.e("??????",""+equalizer.getProperties());
    }
    public void play(){
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
    }
    public void stop(){
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    public void fastForward(int msec){
        mediaPlayer.seekTo(msec);
    }
}
