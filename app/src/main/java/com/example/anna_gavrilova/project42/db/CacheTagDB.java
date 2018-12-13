package com.example.anna_gavrilova.project42.db;

import com.example.anna_gavrilova.project42.models.CacheModel;

import java.util.List;

public class CacheTagDB {
    public static List<CacheModel> getWithTag(DB db, int tagId) {
        return db.cacheTagDao().getWithTag(tagId);
    }
}
