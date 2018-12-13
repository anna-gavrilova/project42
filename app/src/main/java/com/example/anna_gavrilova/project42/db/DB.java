package com.example.anna_gavrilova.project42.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.anna_gavrilova.project42.dao.CacheDao;
import com.example.anna_gavrilova.project42.dao.CacheRatingDao;
import com.example.anna_gavrilova.project42.dao.CacheTagDao;
import com.example.anna_gavrilova.project42.dao.TagDao;
import com.example.anna_gavrilova.project42.dao.UserDao;
import com.example.anna_gavrilova.project42.models.CacheModel;
import com.example.anna_gavrilova.project42.models.CacheRatingModel;
import com.example.anna_gavrilova.project42.models.CacheTagModel;
import com.example.anna_gavrilova.project42.models.TagModel;
import com.example.anna_gavrilova.project42.models.UserModel;

@Database(entities =
        {
            UserModel.class,
            CacheModel.class,
            CacheRatingModel.class,
            CacheTagModel.class,
            TagModel.class
        }, version = 1)
public abstract class DB extends RoomDatabase {

    private static DB INSTANCE;

    public abstract UserDao userDao();
    public abstract CacheDao cacheDao();
    public abstract CacheRatingDao cacheRatingDao();
    public abstract TagDao tagDao();
    public abstract CacheTagDao cacheTagDao();

    public static DB getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), DB.class, "cache-db")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void deleteAppDatabase(Context context) {
        context.deleteDatabase("cache-db");
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}