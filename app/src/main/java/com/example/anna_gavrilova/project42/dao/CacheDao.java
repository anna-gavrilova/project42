package com.example.anna_gavrilova.project42.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.anna_gavrilova.project42.models.CacheModel;

import java.util.List;

@Dao
public interface CacheDao {
    @Query("SELECT * FROM caches")
    List<CacheModel> getAll();

    @Query("SELECT * FROM caches WHERE id LIKE :id")
    CacheModel getCache(int id);

    @Update()
    void update(CacheModel cacheModel);

    @Delete()
    void delete(CacheModel cacheModel);

    @Insert
    long[] insertAll(CacheModel... caches);
}
