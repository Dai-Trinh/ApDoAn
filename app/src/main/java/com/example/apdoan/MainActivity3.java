package com.example.apdoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apdoan.model.DoAn;

public class MainActivity3 extends AppCompatActivity {
    ImageView imgView;
    TextView txt1, txt2, txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imgView = findViewById(R.id.imageViewMain3);
        txt1 = findViewById(R.id.textviewNameMain);
        txt2 = findViewById(R.id.textviewGiaMain);
        txt3 = findViewById(R.id.textviewNguyenLieuMain);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        DoAn doAn = (DoAn) bundle.get("object");
        imgView.setImageResource(doAn.getHinhAnh());
        txt1.setText(doAn.getTenDoAn());
        txt2.setText(doAn.getGia());
        txt3.setText(doAn.getNguyenLieu());


    }
}