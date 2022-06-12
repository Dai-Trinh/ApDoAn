package com.example.apdoan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apdoan.R;
import com.example.apdoan.adapter.DoAnAdapter1;
import com.example.apdoan.model.DoAn;

import java.util.ArrayList;
import java.util.List;

public class fragment_favorite extends Fragment {

    RecyclerView rcvFavorite;
    DoAnAdapter1 doAnAdapter2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_favorite, container, false);
        rcvFavorite = view.findViewById(R.id.recyclerViewFavorite);
        rcvFavorite.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvFavorite.setLayoutManager(linearLayoutManager);
        rcvFavorite.setFocusable(false);
        doAnAdapter2 = new DoAnAdapter1();
        doAnAdapter2.setDaTa(getDoAnFavoite(), view.getContext());
        rcvFavorite.setAdapter(doAnAdapter2);
        return view;
    }

    private List<DoAn> getDoAnFavoite(){
        List<DoAn> doAnListF = new ArrayList<>();
        doAnListF.add(new DoAn("Xôi", "Giá: 70.000", R.drawable.mon_an_4, "Nguyên liệu: Gạo nếp, lá tạo màu sắc"));
        doAnListF.add(new DoAn("Bánh mì", "Giá: 15.000", R.drawable.mon_an_5, "Nguyên liệu: Bánh mì, pate, xúc xích"));
        return  doAnListF;
    }
}
