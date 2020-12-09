package com.example.calculator.historyRecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyDialogFragment extends DialogFragment implements InfHistoryCallback {

    ArrayList<Pojo> data;
    HistoryList historyList=new HistoryList();
    String queHis,ansHis;

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.history_dialog_fragment,container,false);
        recyclerView=view.findViewById(R.id.rvOutputList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        data = historyList.getData();
        recyclerView.setAdapter(new CustomAdapter(data));
        return view;
    }

    @Override
    public void resultHistory(String Question, String Answer) {
        queHis=Question;
        ansHis=Answer;
    }
}