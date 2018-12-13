package com.example.anna_gavrilova.project42;

import android.content.Intent;
import android.support.constraint.solver.Cache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cashes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashes);
        Cacheq a=new Cacheq("Hexahue","Very difficult one",43.650007,-79.385866);
        Cacheq b=new Cacheq("Hexahue","Very difficult one",43.650007,-79.385866);
        Cacheq e=new Cacheq("Hexahue","Very difficult one",43.650007,-79.385866);
        Cacheq d=new Cacheq("Hexahue","Very difficult one",43.650007,-79.385866);


        List<Cacheq> caches=new ArrayList<Cacheq>();
        caches.add(a);
        caches.add(b);
        caches.add(e);
        caches.add(d);


        final ListView listCaches = findViewById(R.id.lstCaches);
        listCaches.setClickable(true);
        listCaches.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = listCaches.getItemAtPosition(position);
                Map<String, ?> clickedItem = (Map<String, ?>) o;
                Intent i = new Intent(arg0.getContext(), CacheMap.class);
                //i.putExtra("lat", clickedItem.values().toArray()[1].toString());
                i.putExtra("lat",43.650007);
                i.putExtra("long",-79.385866);
                startActivity(i);
            }
        });

        HashMap<String, String> theCaches = new HashMap<>();
        for (Cacheq c: caches) {
            theCaches.put(c.toString(), c.name);
        }

        List<HashMap<String, String>> presenterList = new ArrayList<>();
        SimpleAdapter ada = new SimpleAdapter(this,
                presenterList,
                R.layout.cache_item,
                new String[]{"name", "email"},
                new int[]{R.id.text1, R.id.text2});

        for (Object o : theCaches.entrySet()) {
            HashMap<String, String> res = new HashMap<>();
            Map.Entry pair = (Map.Entry) o;
            res.put("name", pair.getKey().toString());
            res.put("email", pair.getValue().toString());
            presenterList.add(res);
        }
        listCaches.setAdapter(ada);


    }
}
