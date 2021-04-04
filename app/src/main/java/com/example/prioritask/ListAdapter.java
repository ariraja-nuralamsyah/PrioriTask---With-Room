package com.example.prioritask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    ArrayList<DataTugas> dataHolder;

    public ListAdapter(ArrayList<DataTugas> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tittle.setText(dataHolder.get(position).getTittle());
        holder.date.setText(dataHolder.get(position).getDates());
        holder.desciption.setText(dataHolder.get(position).getDescription());
        holder.via.setText(dataHolder.get(position).getVia());
        holder.level.setText(dataHolder.get(position).getLevel());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView tittle;
        private TextView date;
        private EditText desciption;
        private TextView via;
        private TextView level;

        public ListViewHolder(View itemView){
            super(itemView);
            tittle = (TextView) itemView.findViewById(R.id.textTittle);
            date = (TextView) itemView.findViewById(R.id.textDate);
            via = (TextView) itemView.findViewById(R.id.textVia);
            level = (TextView) itemView.findViewById(R.id.level);
            desciption = (EditText) itemView.findViewById(R.id.Description);
        }
    }
}
