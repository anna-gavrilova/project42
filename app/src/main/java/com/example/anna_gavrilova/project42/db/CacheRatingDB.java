package com.example.anna_gavrilova.project42.db;

import android.util.Log;

import com.example.anna_gavrilova.project42.models.CacheRatingModel;

import java.util.List;

public class CacheRatingDB {
    public static double addRating(DB db, CacheRatingModel cacheRatingModel) {
        db.cacheRatingDao().insertAll(cacheRatingModel);
        return getRating(db, cacheRatingModel.getCacheId());
    }

    public static double getRating(DB db, int id) {
        List<CacheRatingModel> ratings = db.cacheRatingDao().getRating(id);
        double d = 0;
        for (CacheRatingModel cr: ratings) {
            d += cr.getRating();
        }
        return d / ratings.size();
    }
}
