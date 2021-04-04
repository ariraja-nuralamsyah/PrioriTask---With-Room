package com.example.prioritask;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    ArrayList<DataTugas> dataHolder;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        DataTugas obj1 = new DataTugas("PPB","24-05-2021","Email","MEDIUM","07:00","1. Aplikasi Prioritask", "Tugas");
        dataHolder.add(obj1);
        DataTugas obj2 = new DataTugas("PPL","25-05-2021","E-Learning","Hard","23:59","1. Mindmap", "Tugas");
        dataHolder.add(obj2);
        DataTugas obj3 = new DataTugas("APSI","26-05-2021","Email","Low","23:00","1. Database", "Tugas");
        dataHolder.add(obj3);
        DataTugas obj4 = new DataTugas("PPL6","30-05-2021","Presentasi","Low","23:00","1. IOT", "Tugas");
        dataHolder.add(obj4);

        recyclerView.setAdapter(new ListAdapter(dataHolder));

        return view;
    }
}