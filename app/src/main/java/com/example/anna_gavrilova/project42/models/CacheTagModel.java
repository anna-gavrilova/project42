package com.example.anna_gavrilova.project42.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "cachetags", foreignKeys = {
        @ForeignKey(entity = TagModel.class,
        parentColumns = "id",
        childColumns = "tagId",
        onDelete = CASCADE),
        @ForeignKey(entity = CacheModel.class,
        parentColumns = "id",
        childColumns = "cacheId",
        onDelete = CASCADE)
})
public class CacheTagModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tagId")
    private int tagId;

    @ColumnInfo(name = "cacheId")
    private int cacheId;

    public CacheTagModel(int tagId, int cacheId) {
        this.tagId = tagId;
        this.cacheId = cacheId;
    }

    public void setTagId(int tagId) { this.tagId = tagId; }
    public int getTagId() { return this.tagId; }
    public void setCacheId(int cacheId) { this.cacheId = cacheId; }
    public int getCacheId() { return this.cacheId; }
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }
}
