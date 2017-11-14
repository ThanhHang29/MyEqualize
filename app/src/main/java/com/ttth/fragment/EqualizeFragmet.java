package com.ttth.fragment;

import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.ttth.adapter.EqualizeRecyclerAdapter;
import com.ttth.model.ItemEqualize;
import com.ttth.myequalize.R;

import java.util.ArrayList;

/**
 * Created by HangPC on 11/11/2017.
 */

public class EqualizeFragmet extends Fragment implements View.OnClickListener, EqualizeRecyclerAdapter.OnItemClick{

    private SeekBar sb60Hz, sb150Hz, sb400Hz, sb1Khz, sb2KHz, sb15KHz;
    private ArrayList<ItemEqualize> arrEqualizes;
    private RecyclerView mRecyclerView;
    private EqualizeRecyclerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        arrEqualizes = new ArrayList<>();
        arrEqualizes.add(new ItemEqualize(getString(R.string.normal)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.acoutic)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.bass_booster)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.bass_reducer)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.classical)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.dance)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.deep)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.electronic)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.hip_hop)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.jazz)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.latin)));
        arrEqualizes.add(new ItemEqualize(getString(R.string.loudness)));


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equalize,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sb60Hz = view.findViewById(R.id.sb_60Hz);
        sb150Hz = view.findViewById(R.id.sb_150Hz);
        sb400Hz = view.findViewById(R.id.sb_400Hz);
        sb1Khz = view.findViewById(R.id.sb_1KHz);
        sb2KHz = view.findViewById(R.id.sb_2_4Hz);
        sb15KHz = view.findViewById(R.id.sb_15KHz);

        mRecyclerView = view.findViewById(R.id.rv_recyclerview);

        getOptionEqualize();
        setSeekBarOnClick();
    }

    private void getOptionEqualize() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new EqualizeRecyclerAdapter(arrEqualizes);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setmOnItemClick(this);
    }

    private void setSeekBarOnClick() {
        sb60Hz.setOnClickListener(this);
        sb150Hz.setOnClickListener(this);
        sb400Hz.setOnClickListener(this);
        sb1Khz.setOnClickListener(this);
        sb2KHz.setOnClickListener(this);
        sb15KHz.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sb_60Hz:
                break;
            case R.id.sb_150Hz:
                break;
            case R.id.sb_400Hz:
                break;
            case R.id.sb_1KHz:
                break;
            case R.id.sb_2_4Hz:
                break;
            case R.id.sb_15KHz:
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        // // TODO: 11/14/2017  
    }
}
