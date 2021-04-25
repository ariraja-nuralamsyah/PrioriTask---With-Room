package com.example.prioritask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import static android.app.Activity.RESULT_OK;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link dataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class dataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
        ArrayList<DataTugas> dataHolder;
        private DataTugasViewModel mDataTugasViewModel;

    public dataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static dataFragment newInstance(String param1, String param2) {
        dataFragment fragment = new dataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);

        final DataTugasListAdapter adapter = new DataTugasListAdapter(new DataTugasListAdapter.TugasDiff(), view.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mDataTugasViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(DataTugasViewModel.class);
        mDataTugasViewModel.getAllWords().observe(getViewLifecycleOwner(), words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), Tambah_Activity.class);
                    startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DataTugas tugas = new DataTugas(data.getStringExtra(Tambah_Activity.EXTRA_REPLY),
                    data.getStringExtra("dates"),
                    data.getStringExtra("via"),
                    data.getStringExtra("level"),
                    "23.59",
                    data.getStringExtra("description"),
                    data.getStringExtra("status"));
            mDataTugasViewModel.insert(tugas);
            Toast.makeText(
                    getContext(),
                    tugas.getTittle(),
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(
                    getContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}