package com.example.anna_gavrilova.project42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anna_gavrilova.project42.db.InitializeDB;
import com.example.anna_gavrilova.project42.db.DB;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //DB.deleteAppDatabase(this);
        InitializeDB.initializeDB(DB.getAppDatabase(this));

        final Button about = (Button) findViewById(R.id.btnAbout);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this, About.class);
                startActivity(intent);
            }
        });

        final Button start=(Button) findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this, Cashes.class);
                startActivity(intent);
            }
        });
    }
}
