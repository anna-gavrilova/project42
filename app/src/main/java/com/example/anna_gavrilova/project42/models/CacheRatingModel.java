package com.example.anna_gavrilova.project42.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "cacherating", foreignKeys = {
        @ForeignKey(entity = UserModel.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = CASCADE),
        @ForeignKey(entity = CacheModel.class,
                parentColumns = "id",
                childColumns = "cacheId",
                onDelete = CASCADE)
})
public class CacheRatingModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "rating")
    private double rating;

    @ColumnInfo(name = "cacheId")
    private int cacheId;

    @ColumnInfo(name = "userId")
    private int userId;

    public CacheRatingModel(int cacheId, int userId, double rating) {
        this.cacheId = cacheId;
        this.userId = userId;
        this.rating = rating;
    }

    public void setRating(double rating) { this.rating = rating; }
    public double getRating() { return this.rating; }
    public void setCacheId(int cacheId) { this.cacheId = cacheId; }
    public int getCacheId() { return this.cacheId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getUserId() { return this.userId; }
    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }

    @Override
    public String toString() {
        return String.valueOf(this.cacheId) + " " + String.valueOf(this.userId) + " " + String.valueOf(this.rating);
    }
}
