package com.example.prioritask;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataTugasViewModel extends AndroidViewModel {

    private DataTugasRepository mRepository;

    private final LiveData<List<DataTugas>> mAllDataTugas;

    public DataTugasViewModel (Application application) {
        super(application);
        mRepository = new DataTugasRepository(application);
        mAllDataTugas = mRepository.getAllWords();
    }

    LiveData<List<DataTugas>> getAllWords() { return mAllDataTugas; }

    public void insert(DataTugas dataTugas) { mRepository.insert(dataTugas); }
    public void delete(String Dtittle){mRepository.delete(Dtittle);}
}
