package com.example.apdoan.model;

import java.io.Serializable;

public class DoAn implements Serializable {
    private String tenDoAn;
    private String Gia;
    private int hinhAnh;
    private String nguyenLieu;


    public DoAn(String tenDoAn, String gia, int hinhAnh, String nguyenLieu) {
        this.tenDoAn = tenDoAn;
        Gia = gia;
        this.hinhAnh = hinhAnh;
        this.nguyenLieu = nguyenLieu;
    }

    public String getTenDoAn() {
        return tenDoAn;
    }

    public void setTenDoAn(String tenDoAn) {
        this.tenDoAn = tenDoAn;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(String nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}
