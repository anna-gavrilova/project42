package com.example.anna_gavrilova.project42.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.anna_gavrilova.project42.models.UserModel;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<UserModel> getAll();

    @Query("SELECT * FROM users WHERE id LIKE :id")
    UserModel getUser(int id);

    @Query("SELECT * FROM users WHERE email LIKE :email AND password LIKE :password")
    UserModel loginUser(String email, String password);

    @Query("SELECT COUNT(*) FROM users")
    int countUsers();

    @Insert
    long[] insertAll(UserModel... users);
}
