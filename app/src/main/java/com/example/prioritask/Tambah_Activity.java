package com.example.prioritask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class Tambah_Activity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private EditText mTittle;
    private EditText mDateDay;
    private EditText mDateMonth;
    private EditText mDateYears;
    private EditText mDesc;
    private EditText mVia;
    private EditText mLevel;
    private String mStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_tambah);
        mTittle = findViewById(R.id.editTitle);
        mDateDay = findViewById(R.id.editDateDay);
        mDateMonth = findViewById(R.id.editDateMonth);
        mDateYears = findViewById(R.id.editDateYear);
        mDesc = findViewById(R.id.editDesc);
        mVia = findViewById(R.id.editVia);
        mLevel = findViewById(R.id.editLevel);
        mStatus = "Check";


        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mTittle.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String tittle = mTittle.getText().toString();
                String dates = mDateDay.getText().toString() + "-" + mDateMonth.getText().toString() + "-" + mDateYears.getText().toString();
                String desc = mDesc.getText().toString();
                String via = mVia.getText().toString();
                String level = mLevel.getText().toString();
                String status = mStatus;
                DataTugas tugas = new DataTugas(tittle, dates,  via, level, "23.59", desc, status);
                replyIntent.putExtra(EXTRA_REPLY, tittle);
                replyIntent.putExtra("dates", dates);
                replyIntent.putExtra("description", desc);
                replyIntent.putExtra("via", via);
                replyIntent.putExtra("level", level);
                replyIntent.putExtra("status", status);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}