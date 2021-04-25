package com.example.prioritask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private BottomNavigationView menu_bawah;
    public Button level ;
    private Scene list_item;
    private Scene list_item_detail;
    private Scene currentScene;
    private Transition transition;
    private boolean detailClicked = false;
    public DataTugasListAdapter list;
    private DataTugasViewModel mDataTugasViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        loadFragment(new dataFragment());
        menu_bawah = findViewById(R.id.menu_bawah);
        menu_bawah.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home:
                //aksi ketika home di klik
                fragment = new dataFragment();
                break;
            case R.id.selesai:
                //aksi ketika profile di klik
                //fragment = new selesaiFragment();

                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void onClick2(View view){
        if(detailClicked == false){
            detailClicked = true;
            view.findViewById(R.id.detailed).setRotation(90);
            view.findViewById(R.id.Description).setVisibility(View.VISIBLE);
            view.findViewById(R.id.textVia).setVisibility(View.VISIBLE);
            view.findViewById(R.id.level).setVisibility(View.VISIBLE);
            view.findViewById(R.id.textDescription).setVisibility(View.VISIBLE);
            view.findViewById(R.id.submit).setVisibility(View.VISIBLE);
            view.findViewById(R.id.Via).setVisibility(View.VISIBLE);
        }else{
            detailClicked = false;
            view.findViewById(R.id.detailed).setRotation(360);
            view.findViewById(R.id.Description).setVisibility(View.GONE);
            view.findViewById(R.id.textVia).setVisibility(View.GONE);
            view.findViewById(R.id.level).setVisibility(View.GONE);
            view.findViewById(R.id.textDescription).setVisibility(View.GONE);
            view.findViewById(R.id.submit).setVisibility(View.GONE);
            view.findViewById(R.id.Via).setVisibility(View.GONE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}