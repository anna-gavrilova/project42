package com.example.anna_gavrilova.project42.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tags")
public class TagModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    public TagModel(String name) {
        this.name = name;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    @Override
    public String toString() { return this.name; }
}
