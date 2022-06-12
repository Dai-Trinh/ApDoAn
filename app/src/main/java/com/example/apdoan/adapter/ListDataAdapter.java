package com.example.apdoan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apdoan.R;
import com.example.apdoan.model.ListData;

import java.util.List;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder> {

    public static final int TYPE_DOAN = 1;
    public static final int TYPE_NAME = 2;

    private List<ListData> dataList;
    private Context mContext;

    public void setData(List<ListData> list, Context context){
        this.dataList = list;
        this.mContext = context;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }

    @NonNull
    @Override
    public ListDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_listdata, parent, false);
        return new ListDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListDataViewHolder holder, int position) {
        ListData listData = dataList.get(position);
        if(listData == null){
            return;
        }

        if(holder.getItemViewType() == TYPE_DOAN){
            LinearLayoutManager linearLayoutManager =new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
            holder.rcvData.setLayoutManager(linearLayoutManager);
            holder.rcvData.setFocusable(false);
            DoAnAdapter doAnAdapter = new DoAnAdapter();
            doAnAdapter.setDaTa(listData.getDoAnDS(), mContext);
            holder.rcvData.setAdapter(doAnAdapter);
        }

        if(holder.getItemViewType() == TYPE_NAME){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
            holder.rcvData.setLayoutManager(linearLayoutManager);
            holder.rcvData.setFocusable(false);
            NamDSApdapter namDSApdapter = new NamDSApdapter();
            namDSApdapter.setData(listData.getNameDS());
            holder.rcvData.setAdapter(namDSApdapter);
        }

    }

    @Override
    public int getItemCount() {
        if(dataList != null){
            return dataList.size();
        }
        return 0;
    }

    protected class ListDataViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rcvData;
        public ListDataViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvData = itemView.findViewById(R.id.recyclerViewData);

        }
    }
}
