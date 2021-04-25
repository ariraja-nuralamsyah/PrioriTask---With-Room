package com.example.prioritask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

class DataTugasViewHolder extends RecyclerView.ViewHolder {
    private final TextView tittleItemView;
    private final TextView dateItemView;
    private final EditText descItemView;
    private final TextView viaItemView;
    private final TextView levelItemView;
    private final TextView checkItemView;
    LinearLayout linearLayout;
    Button submit;

    public DataTugasViewHolder(View itemView) {
        super(itemView);
        tittleItemView = (TextView) itemView.findViewById(R.id.textTittle);
        dateItemView = (TextView) itemView.findViewById(R.id.textDate);
        viaItemView = (TextView) itemView.findViewById(R.id.textVia);
        levelItemView = (TextView) itemView.findViewById(R.id.level);
        descItemView = (EditText) itemView.findViewById(R.id.Description);
        checkItemView = (Button) itemView.findViewById(R.id.submit);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        submit = (Button) itemView.findViewById(R.id.submit);
    }

    public void bind(String tittle, String dates, String description, String via, String level,  String status) {
        tittleItemView.setText(tittle);
        dateItemView.setText(dates);
        viaItemView.setText(via);
        levelItemView.setText(level);
        descItemView.setText(description);
        checkItemView.setText(status);
    }

    static DataTugasViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_detail, parent, false);
        return new DataTugasViewHolder(view);
    }
}
