package com.example.anna_gavrilova.project42.db;

import com.example.anna_gavrilova.project42.models.UserModel;

import java.util.List;

public class UserDB {
    public static UserModel addUser(DB db, UserModel obj) {
        db.userDao().insertAll(obj);
        return obj;
    }

    public static UserModel getUser(DB db, int id) {
        return db.userDao().getUser(id);
    }

    public static UserModel loginUser(DB db, String email, String password) {
        return db.userDao().loginUser(email, password);
    }

    public static List<UserModel> getAll(DB db) {
        return db.userDao().getAll();
    }

    public static int countUsers(DB db) {
        return db.userDao().countUsers();
    }
}
