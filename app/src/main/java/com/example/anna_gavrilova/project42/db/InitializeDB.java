package com.example.anna_gavrilova.project42.db;

import android.util.Log;

import com.example.anna_gavrilova.project42.models.CacheModel;
import com.example.anna_gavrilova.project42.models.CacheRatingModel;
import com.example.anna_gavrilova.project42.models.CacheTagModel;
import com.example.anna_gavrilova.project42.models.TagModel;
import com.example.anna_gavrilova.project42.models.UserModel;

import java.util.List;

public class InitializeDB {
    public static void initializeDB(DB db) {
        if (db.userDao().countUsers() == 0) {
            long userAnna = db.userDao().insertAll(new UserModel("101084528@georgebrown.ca", "password"))[0];
            long userJesse = db.userDao().insertAll(new UserModel("101075970@georgebrown.ca", "password"))[0];
            long userAdmin = db.userDao().insertAll(new UserModel("admin@georgebrown.ca", "password"))[0];

            long tagEasy = db.tagDao().insertAll(new TagModel("Easy"))[0];
            long tagMedium = db.tagDao().insertAll(new TagModel("Medium"))[0];
            long tagHard = db.tagDao().insertAll(new TagModel("Hard"))[0];

            long cacheOne = db.cacheDao().insertAll(new CacheModel("Hexahue", 43.647497,  -79.461080, "Google Hexahue", (int)userAnna))[0];
            long cacheTwo = db.cacheDao().insertAll(new CacheModel("Shakespeare's Bluster", 43.646340,  -79.462131, "Here's a riddle, uncle. Is the lunatic a gentleman or an ordinary guy?", (int)userJesse))[0];
            long cacheThree = db.cacheDao().insertAll(new CacheModel("Minor Inconvenience", 43.647497,  -79.461080, "This cache is a \"minor inconvenience\".", (int)userAnna))[0];
            long cacheFour = db.cacheDao().insertAll(new CacheModel("We of Bronze", 43.634696,  -79.395756, "Four bronze statues are of we, facing the water is who I be.", (int)userJesse))[0];
            long cacheFive = db.cacheDao().insertAll(new CacheModel("Two Wheels and a Tophat", 43.640358, -79.376519,"Two wheels and a tophat.", (int)userAdmin))[0];

            db.cacheTagDao().insertAll(new CacheTagModel((int)tagEasy, (int)cacheFive));
            db.cacheTagDao().insertAll(new CacheTagModel((int)tagMedium, (int)cacheFour));
            db.cacheTagDao().insertAll(new CacheTagModel((int)tagMedium, (int)cacheThree));
            db.cacheTagDao().insertAll(new CacheTagModel((int)tagHard, (int)cacheTwo));
            db.cacheTagDao().insertAll(new CacheTagModel((int)tagHard, (int)cacheOne));

            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheOne, (int)userJesse, 3.5));
            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheOne, (int)userAdmin, 4.4));

            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheThree, (int)userJesse, 5.0));
            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheThree, (int)userAdmin, 5.0));

            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheFive, (int)userJesse, 1.7));
            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheFive, (int)userAnna, 2.2));

            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheFour, (int)userAdmin, 4.7));
            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheFour, (int)userAnna, 4.9));

            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheTwo, (int)userAdmin, 2.3));
            db.cacheRatingDao().insertAll(new CacheRatingModel((int)cacheTwo, (int)userAnna, 3.0));
//            List<CacheRatingModel> crm = db.cacheRatingDao().getAll();
//            List<CacheModel> cm = db.cacheDao().getAll();
//            for (CacheModel c: cm) {
//                Log.d("CRM", c.toString());
//                Log.d("RATING", String.valueOf(CacheRatingDB.getRating(db, c.getId())));
//            }
//
//            List<CacheModel> ct = CacheTagDB.getWithTag(db, (int)tagHard);
//            for (CacheModel c: ct) {
//                Log.d("WITHTAG", c.toString());
//            }
        }
    }
}
