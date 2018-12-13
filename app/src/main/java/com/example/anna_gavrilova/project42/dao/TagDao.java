package com.example.anna_gavrilova.project42.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.anna_gavrilova.project42.models.TagModel;

import java.util.List;

@Dao
public interface TagDao {
    @Query("SELECT * FROM tags")
    List<TagModel> getAll();

    @Insert
    long[] insertAll(TagModel... tagModels);
}
