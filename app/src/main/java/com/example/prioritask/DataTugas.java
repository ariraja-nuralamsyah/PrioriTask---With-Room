package com.example.prioritask;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tugas_table")
public class DataTugas {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tittle")
    String tittle;
    @NonNull
    @ColumnInfo(name = "dates")
    String dates;
    @NonNull
    @ColumnInfo(name = "via")
    String via;
    @NonNull
    @ColumnInfo(name = "level")
    String level;
    @NonNull
    @ColumnInfo(name = "jam")
    String jam;
    @NonNull
    @ColumnInfo(name = "description")
    String description;
    @NonNull
    @ColumnInfo(name = "status")
    String status;

    public DataTugas(@NonNull String tittle, String dates, String via, String level, String jam, String description, String status) {
        this.tittle = tittle;
        this.dates = dates;
        this.via = via;
        this.level = level;
        this.jam = jam;
        this.description = description;
        this.status = status;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
