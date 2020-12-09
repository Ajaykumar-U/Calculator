package com.example.calculator.historyRecycler;

import java.util.ArrayList;
import java.util.List;

public class HistoryList {
    public ArrayList<Pojo> getData(){
        Pojo p1=new Pojo("Quetion","Answer");
        ArrayList<Pojo> data = new ArrayList<>();
        data.add(p1);
        return data;
    }
}
