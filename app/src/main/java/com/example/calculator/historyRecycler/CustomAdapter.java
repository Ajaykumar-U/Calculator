package com.example.calculator.historyRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculator.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    ArrayList<Pojo> data;

    public CustomAdapter(ArrayList<Pojo> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Item = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list, parent, false);
        return new ViewHolder(Item);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder)holder;
        Pojo pojo = data.get(position);
        holder1.question.setText(pojo.getQuestions());
        holder1.answer.setText(pojo.getAnswers());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView question,answer;

        public ViewHolder(View view) {
            super(view);
            this.question = view.findViewById(R.id.tvQueHis);
            this.answer = view.findViewById(R.id.tvAnsHis);
        }

    }
}

