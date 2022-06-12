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
import com.example.apdoan.adapter.DoAnAdapter;
import com.example.apdoan.adapter.DoAnAdapter1;
import com.example.apdoan.model.DoAn;

import java.util.ArrayList;
import java.util.List;

public class fragment_new extends Fragment {

    RecyclerView rcvNew;
    DoAnAdapter1 doAnAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_new, container, false);
        rcvNew = view.findViewById(R.id.recycvlerNew);
        rcvNew.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvNew.setLayoutManager(linearLayoutManager);
        rcvNew.setFocusable(false);
        doAnAdapter = new DoAnAdapter1();
        doAnAdapter.setDaTa(getDoAn(), view.getContext());
        rcvNew.setAdapter(doAnAdapter);
        return view;
    }

    private List<DoAn> getDoAn(){
        List<DoAn> doAnListNew = new ArrayList<>();
        doAnListNew.add(new DoAn("Bánh cuốn", "Giá: 20.000", R.drawable.mon_an_1, "Nguyên liệu: Bột gạo, thịt, mọc nhĩ"));
        doAnListNew.add(new DoAn("Cá kho", "Giá: 50.000", R.drawable.mon_an_2, "Nguyên liệu: Cá, tương, ớt, gia vị"));
        doAnListNew.add(new DoAn("Cơm cuốn", "Giá: 30.000", R.drawable.mon_an_3, "Nguyên liệu: Gạo, rong biển, cà rốt"));
        return doAnListNew;
    }
}
