package com.example.apdoan.adapter;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apdoan.MainActivity3;
import com.example.apdoan.R;
import com.example.apdoan.model.DoAn;

import java.util.List;

public class DoAnAdapter extends RecyclerView.Adapter<DoAnAdapter.DoAnViewHolder> {

    private List<DoAn> mListDoAn;
    private Context contextDoAn;

    public void setDaTa(List<DoAn> list, Context context){
        this.mListDoAn = list;
        this.contextDoAn = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DoAnViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_doan, parent, false);
        return new DoAnViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoAnViewHolder holder, int position) {
        DoAn doAn = mListDoAn.get(position);
        if(doAn == null){
            return;
        }

        holder.imgHinhAnh.setImageResource(doAn.getHinhAnh());
        holder.txtTenDoAn.setText(doAn.getTenDoAn());
        holder.txtGia.setText(doAn.getGia());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDetail(doAn);
            }
        });

    }

    private void goDetail(DoAn doAn){
        Intent intent = new Intent(contextDoAn, MainActivity3.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object", doAn);
        intent.putExtras(bundle);
        contextDoAn.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListDoAn != null){
            return mListDoAn.size();
        }
        return 0;
    }

    protected class DoAnViewHolder extends RecyclerView.ViewHolder{

        ImageView imgHinhAnh;
        TextView txtTenDoAn;
        TextView txtGia;
        LinearLayout linearLayout;

        public DoAnViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHinhAnh = itemView.findViewById(R.id.imageViewHinhAnh);
            txtTenDoAn = itemView.findViewById(R.id.textViewTenMonAn);
            txtGia = itemView.findViewById(R.id.textViewGia);
            linearLayout = itemView.findViewById(R.id.layoutDoAn);
        }
    }
}
