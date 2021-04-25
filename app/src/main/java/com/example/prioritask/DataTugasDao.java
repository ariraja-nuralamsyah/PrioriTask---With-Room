package com.example.prioritask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataTugasDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DataTugas dataTugas);

    @Query("DELETE FROM tugas_table WHERE tittle = :Dtittle")
    void delete(String Dtittle);

    @Query("SELECT * FROM tugas_table ORDER BY tittle ASC")
    LiveData<List<DataTugas>> getAlphabetizedTugas();

}
