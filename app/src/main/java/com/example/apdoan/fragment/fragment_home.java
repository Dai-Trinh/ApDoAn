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
import com.example.apdoan.adapter.ListDataAdapter;
import com.example.apdoan.model.DoAn;
import com.example.apdoan.model.ListData;
import com.example.apdoan.model.NameDS;

import java.util.ArrayList;
import java.util.List;

public class fragment_home extends Fragment {

    private ListDataAdapter listDataAdapter;
    private RecyclerView rcvHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_home, container, false);
        rcvHome = view.findViewById(R.id.recyclerViewHome);
        rcvHome.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        rcvHome.setLayoutManager(linearLayoutManager);
        rcvHome.setFocusable(false);
        listDataAdapter = new ListDataAdapter();
        listDataAdapter.setData(getListData(), view.getContext());
        rcvHome.setAdapter(listDataAdapter);
        return view;
    }

    private List<ListData> getListData(){
        List<ListData> listData = new ArrayList<>();

        List<NameDS> nameDS = new ArrayList<>();
        nameDS.add(new NameDS("New"));
        List<NameDS> nameDS2 = new ArrayList<>();
        nameDS2.add(new NameDS("Favorite"));

        List<DoAn> doAnList = new ArrayList<>();
        doAnList.add(new DoAn("Bánh cuốn", "Giá: 20.000", R.drawable.mon_an_1, "Nguyên liệu: Bột gạo, thịt, mọc nhĩ"));
        doAnList.add(new DoAn("Cá kho", "Giá: 50.000", R.drawable.mon_an_2, "Nguyên liệu: Cá, tương, ớt, gia vị"));
        doAnList.add(new DoAn("Cơm cuốn", "Giá: 30.000", R.drawable.mon_an_3, "Nguyên liệu: Gạo, rong biển, cà rốt"));

        List<DoAn> doAnList2 = new ArrayList<>();
        doAnList2.add(new DoAn("Xôi", "Giá: 70.000", R.drawable.mon_an_4, "Nguyên liệu: Gạo nếp, lá tạo màu sắc"));
        doAnList2.add(new DoAn("Bánh mì", "Giá: 15.000", R.drawable.mon_an_5, "Nguyên liệu: Bánh mì, pate, xúc xích"));

        listData.add(new ListData(ListDataAdapter.TYPE_NAME, nameDS, null));
        listData.add(new ListData(ListDataAdapter.TYPE_DOAN, null, doAnList));
        listData.add(new ListData(ListDataAdapter.TYPE_NAME, nameDS2, null));
        listData.add(new ListData(ListDataAdapter.TYPE_DOAN, null, doAnList2));


        return listData;
    }
}
