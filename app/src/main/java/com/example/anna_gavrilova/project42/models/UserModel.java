package com.example.anna_gavrilova.project42.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return this.email; }
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return this.password; }

    @Override
    public String toString() { return this.email; }
}
