package com.example.anna_gavrilova.project42.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "caches", foreignKeys = @ForeignKey(entity = UserModel.class,
                                                        parentColumns = "id",
                                                        childColumns = "userId",
                                                        onDelete = CASCADE))
public class CacheModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "latitude")
    private double latitude;

    @ColumnInfo(name = "notes")
    private String notes;

    @ColumnInfo(name = "userId")
    private int userId;

    public CacheModel(String name, double latitude, double longitude, String notes, int userId) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notes = notes;
        this.userId = userId;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
    public void setName(String val) { this.name = val; }
    public String getName() { return this.name; }
    public void setLatitude(double val) { this.latitude = val; }
    public double getLatitude() { return this.latitude; }
    public void setLongitude(double val) { this.longitude = val; }
    public double getLongitude() { return this.longitude; }
    public void setNotes(String val) { this.notes = val; }
    public String getNotes() { return this.notes; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getUserId() { return this.userId; }

    @Override
    public String toString() { return this.name; }
}
