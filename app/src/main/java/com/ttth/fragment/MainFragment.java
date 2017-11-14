package com.ttth.fragment;

import android.content.Intent;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ttth.myequalize.MainActivity;
import com.ttth.myequalize.R;
import com.ttth.myservice.MyService;
import com.ttth.view.EqualizerView;

/**
 * Created by HangPC on 11/11/2017.
 */

public class MainFragment extends Fragment implements View.OnClickListener , SeekBar.OnSeekBarChangeListener{
    private static final String KEY_IS_RUNNING = "key_is_running";
    private Button btnStart, btnStop, btnNext;
    private SeekBar sbBarWith, sbAnimationDuration, sbCount;
    private TextView tvBarWith, tvAnimationDuration, tvCount;
    private EqualizerView mEqualizerView;
    private boolean isRunning;
    private int progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData(savedInstanceState);
    }

    private void getData(Bundle bundle) {
       if (bundle != null){
           isRunning = bundle.getBoolean(KEY_IS_RUNNING);
       }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnStart = view.findViewById(R.id.btn_start);
        btnStop = view.findViewById(R.id.btn_stop);
        btnNext = view.findViewById(R.id.btn_next);

        sbBarWith = view.findViewById(R.id.sb_bar_width);
        sbAnimationDuration = view.findViewById(R.id.sb_animation_duration_seekbar);
        sbCount = view.findViewById(R.id.sb_bar_count_seekbar);

        tvBarWith = view.findViewById(R.id.bar_width_textview);
        tvAnimationDuration = view.findViewById(R.id.tv_animation_duration);
        tvCount = view.findViewById(R.id.tv_bar_count_seekbar);

        mEqualizerView = view.findViewById(R.id.equalizer);

        initView();
        initSetOnClick();
        initSeekBarClick();

    }

    private void initView() {
        if (isRunning)mEqualizerView.animateBars();
    }

    private void initSeekBarClick() {
        sbBarWith.setOnSeekBarChangeListener(this);
        sbAnimationDuration.setOnSeekBarChangeListener(this);
        sbCount.setOnSeekBarChangeListener(this);
    }


    private void initSetOnClick() {
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                mEqualizerView.animateBars();
                isRunning = true;

                Intent intent = new Intent(getActivity(), MyService.class);
                getActivity().startService(intent);

                break;
            case R.id.btn_stop:
                mEqualizerView.stopBars();
                isRunning = false;

                Intent intent1 = new Intent(getActivity(), MyService.class);
                getActivity().stopService(intent1);
                break;

            case R.id.btn_next:
                // go to Equalize fragment
                ((MainActivity)getActivity()).replaceFragment(new EqualizeFragmet(), R.id.fl_fragment);

                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()){
            case R.id.sb_bar_width:

                int width = (i <= 0) ? -1 : (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());

                mEqualizerView.setBarWidth(width);
                tvBarWith.setText("Bar width: "+((i)) + " dp");
                break;
            case R.id.sb_animation_duration_seekbar:

                mEqualizerView.setAnimationDuration((i + 1) * 100);
                tvAnimationDuration.setText("Animation duration: "+((i + 1) * 100) + " ms");
                break;
            case R.id.sb_bar_count_seekbar:

                mEqualizerView.setBarCount(i + 1);
                tvCount.setText("Bar count: "+(i + 1) + " bars used");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if (isRunning) mEqualizerView.animateBars();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_IS_RUNNING, isRunning);
    }
}
