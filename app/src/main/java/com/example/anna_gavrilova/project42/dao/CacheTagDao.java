package com.example.anna_gavrilova.project42.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.anna_gavrilova.project42.models.CacheModel;
import com.example.anna_gavrilova.project42.models.CacheTagModel;

import java.util.List;

@Dao
public interface CacheTagDao {
    @Query("SELECT caches.* FROM caches, cachetags WHERE cachetags.tagId LIKE :id AND cachetags.cacheId = caches.id")
    List<CacheModel> getWithTag(int id);

    @Insert
    long[] insertAll(CacheTagModel... cacheTagModels);
}
