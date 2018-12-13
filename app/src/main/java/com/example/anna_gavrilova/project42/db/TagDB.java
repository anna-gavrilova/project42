package com.example.anna_gavrilova.project42.db;

import com.example.anna_gavrilova.project42.models.TagModel;
import java.util.List;

public class TagDB {
    public static TagModel addTag(DB db, TagModel obj) {
        db.tagDao().insertAll(obj);
        return obj;
    }

    public static List<TagModel> getAll(DB db) {
        return db.tagDao().getAll();
    }
}
