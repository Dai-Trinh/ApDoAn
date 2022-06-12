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

public class DoAnAdapter1 extends RecyclerView.Adapter<DoAnAdapter1.DoAnViewHolder1> {

    private List<DoAn> mListDoAn;
    private Context contextDoAn;

    public void setDaTa(List<DoAn> list, Context context){
        this.mListDoAn = list;
        this.contextDoAn = context;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DoAnViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_doan2, parent, false);
        return new DoAnViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoAnViewHolder1 holder, int position) {
        DoAn doAn = mListDoAn.get(position);
        if(doAn == null){
            return;
        }

        holder.imgHinhAnh1.setImageResource(doAn.getHinhAnh());
        holder.txtTenDoAn1.setText(doAn.getTenDoAn());
        holder.txtGia1.setText(doAn.getGia());
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goDeTail2(doAn);
            }
        });

    }

    private void goDeTail2(DoAn doAn){
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

    protected class DoAnViewHolder1 extends RecyclerView.ViewHolder{

        ImageView imgHinhAnh1;
        TextView txtTenDoAn1;
        TextView txtGia1;
        LinearLayout linearLayout2;

        public DoAnViewHolder1(@NonNull View itemView) {
            super(itemView);
            imgHinhAnh1 = itemView.findViewById(R.id.imageViewHinhAnh1);
            txtTenDoAn1 = itemView.findViewById(R.id.textViewTenMonAn1);
            txtGia1 = itemView.findViewById(R.id.textViewGia1);
            linearLayout2 = itemView.findViewById(R.id.lauoutDoAn2);
        }
    }
}
