package com.ttth.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ttth.model.ItemEqualize;
import com.ttth.myequalize.R;

import java.util.ArrayList;

/**
 * Created by HangPC on 11/14/2017.
 */

public class EqualizeRecyclerAdapter extends RecyclerView.Adapter<EqualizeRecyclerAdapter.MyViewHolder> {

    private ArrayList<ItemEqualize> arrEqualizes;
    private OnItemClick mOnItemClick;

    public void setmOnItemClick(OnItemClick mOnItemClick) {
        this.mOnItemClick = mOnItemClick;
    }

    public EqualizeRecyclerAdapter(ArrayList<ItemEqualize> arrEqualizes) {
        this.arrEqualizes = arrEqualizes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(inflater.inflate(R.layout.item_equalize, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (arrEqualizes.size() == 0 || arrEqualizes == null) return;
        holder.tvTitleEqualize.setText(arrEqualizes.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClick.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrEqualizes == null || arrEqualizes.size() == 0 ? 0 : arrEqualizes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitleEqualize;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitleEqualize = itemView.findViewById(R.id.tv_option_equalize);
        }
    }
    public interface OnItemClick{
        void onItemClick(int position);
    }
}
