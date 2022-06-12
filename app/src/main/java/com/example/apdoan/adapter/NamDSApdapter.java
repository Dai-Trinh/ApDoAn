package com.example.apdoan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apdoan.R;
import com.example.apdoan.model.NameDS;

import java.util.List;

public class NamDSApdapter extends RecyclerView.Adapter<NamDSApdapter.NameViewHoler> {


    private List<NameDS> dsList;

    public void setData(List<NameDS> ds){
        this.dsList = ds;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NameViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_name, parent, false);
        return new NameViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHoler holder, int position) {
        NameDS name = dsList.get(position);
        if(name == null){
            return;
        }
        holder.txtName.setText(name.getTenDanhSach());

    }

    @Override
    public int getItemCount() {
        if(dsList != null){
            return dsList.size();
        }
        return 0;
    }

    protected class NameViewHoler extends RecyclerView.ViewHolder{

        TextView txtName;

        public NameViewHoler(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.item_name);
        }
    }


}
