package com.ttth.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.ttth.model.MySong;

/**
 * Created by HangPC on 11/12/2017.
 */

public class MyService extends Service {
    public static final String TAG = "My service";
    private MySong mMySong;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"----------onBind");
        return null;
    }


    @Override
    public void onDestroy() {
        Log.e(TAG,"----------on destroy");
        if (mMySong != null){
            mMySong.stop();
        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"----------on start command");
        if (mMySong != null){
            mMySong.play();
        }
        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onCreate() {
        Log.e(TAG,"----------onCreate");
        mMySong = new MySong(this);
        super.onCreate();
    }
}
