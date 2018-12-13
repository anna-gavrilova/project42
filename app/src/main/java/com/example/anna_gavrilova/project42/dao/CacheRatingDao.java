package com.example.anna_gavrilova.project42.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.anna_gavrilova.project42.models.CacheRatingModel;

import java.util.List;

@Dao
public interface CacheRatingDao {
    @Query("SELECT * FROM cacherating")
    List<CacheRatingModel> getAll();

    @Query("SELECT * FROM cacherating WHERE cacheId LIKE :id")
    List<CacheRatingModel> getRating(int id);

    @Insert
    long[] insertAll(CacheRatingModel... cacheRatingModels);
}
