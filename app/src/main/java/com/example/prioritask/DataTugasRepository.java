package com.example.prioritask;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class DataTugasRepository {

    private DataTugasDao mdataTugasDao;
    private LiveData<List<DataTugas>> mAllDataTugas;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    DataTugasRepository(Application application) {
        DataTugasDatabase db = DataTugasDatabase.getDatabase(application);
        mdataTugasDao = db.dataTugasDao();
        mAllDataTugas = mdataTugasDao.getAlphabetizedTugas();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<DataTugas>> getAllWords() {
        return mAllDataTugas;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(DataTugas dataTugas) {
        DataTugasDatabase.databaseWriteExecutor.execute(() -> {
            mdataTugasDao.insert(dataTugas);
        });
    }
    void delete(String Dtittle){
        DataTugasDatabase.databaseWriteExecutor.execute(()->{
            mdataTugasDao.delete(Dtittle);
        });
    }
}
