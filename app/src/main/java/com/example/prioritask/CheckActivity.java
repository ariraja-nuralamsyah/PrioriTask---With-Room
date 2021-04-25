package com.example.prioritask;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CheckActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private BottomNavigationView menu_bawah;
    private DataTugasViewModel mDataTugasViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_list_item);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Intent intent = getIntent();
        TextView txt_title = (TextView) findViewById(R.id.textJudul);
        TextView txt_description = (TextView) findViewById(R.id.textDesc);
        txt_title.setText(intent.getStringExtra("tittle"));
        txt_description.setText(intent.getStringExtra("description"));
        Button del = (Button) findViewById(R.id.delButton);
        mDataTugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(DataTugasViewModel.class);
        del.setOnClickListener(View -> {
            mDataTugasViewModel.delete(intent.getStringExtra("tittle"));
            finish();
        });
    }
}
