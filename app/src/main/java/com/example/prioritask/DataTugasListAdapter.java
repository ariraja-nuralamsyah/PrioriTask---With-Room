package com.example.prioritask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataTugasListAdapter extends ListAdapter<DataTugas, DataTugasViewHolder> {
    Context context;
    public DataTugasListAdapter(@NonNull DiffUtil.ItemCallback<DataTugas> diffCallback, Context ct) {
        super(diffCallback);
        context = ct;
    }

    @Override
    public DataTugasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return DataTugasViewHolder.create(parent);
    }


    @Override
    public void onBindViewHolder(@NonNull DataTugasViewHolder holder, int position) {
        DataTugas current = getItem(position);
        holder.bind(current.getTittle(),current.getDates(),current.getDescription(),current.getVia(),current.getLevel(),current.getStatus());
            holder.submit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putString("tittle",current.getTittle());
                    bundle.putString("dates",current.getDates());
                    bundle.putString("via",current.getVia());
                    bundle.putString("level",current.getLevel());
                    bundle.putString("description",current.getDescription());
                    Intent intent = new Intent(context, CheckActivity.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
    }

    static class TugasDiff extends DiffUtil.ItemCallback<DataTugas> {

        @Override
        public boolean areItemsTheSame(@NonNull DataTugas oldItem, @NonNull DataTugas newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataTugas oldItem, @NonNull DataTugas newItem) {
            return oldItem.getTittle().equals(newItem.getTittle());
        }
    }
}
