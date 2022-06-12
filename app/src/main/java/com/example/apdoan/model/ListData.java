package com.example.apdoan.model;

import java.util.List;

public class ListData {

    private int type;
    private List<NameDS> nameDS;
    private List<DoAn> doAnDS;


    public ListData(int type, List<NameDS> nameDS, List<DoAn> doAnDS) {
        this.type = type;
        this.nameDS = nameDS;
        this.doAnDS = doAnDS;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<NameDS> getNameDS() {
        return nameDS;
    }

    public void setNameDS(List<NameDS> nameDS) {
        this.nameDS = nameDS;
    }

    public List<DoAn> getDoAnDS() {
        return doAnDS;
    }

    public void setDoAnDS(List<DoAn> doAnDS) {
        this.doAnDS = doAnDS;
    }
}
