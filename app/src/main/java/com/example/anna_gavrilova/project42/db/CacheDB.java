package com.example.anna_gavrilova.project42.db;

import com.example.anna_gavrilova.project42.models.CacheModel;
import java.util.List;

public class CacheDB {
    public static CacheModel addCache(DB db, CacheModel cacheModel) {
        db.cacheDao().insertAll(cacheModel);
        return cacheModel;
    }

    public static CacheModel findById(DB db, int id) {
        return db.cacheDao().getCache(id);
    }

    public static void deleteCache(DB db, CacheModel cache) {
        db.cacheDao().delete(cache);
    }

    public static void updateCache(DB db, CacheModel cacheModel) {
        db.cacheDao().update(cacheModel);
    }

    public static List<CacheModel> getAll(DB db) {
        return db.cacheDao().getAll();
    }
}
