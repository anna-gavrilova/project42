package com.example.anna_gavrilova.project42;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.MessageDigest;
import java.util.Map;


public class CachePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_page);

        final TextView ratingText=(TextView) findViewById(R.id.txtRating);
        ImageView img = (ImageView) findViewById(R.id.imgMap);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(CachePage.this, CacheMap.class);
                //Dummy data again
                i.putExtra("lat",43.650007);
                i.putExtra("long",-79.385866);
                startActivity(i);
            }
        });

        RatingBar rb=(RatingBar) findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // Do what you want
                if(fromUser){
                    ratingBar.setRating(rating);
                    //send rating;
                    //var smth=getrating;
                    //setTextto snth();
                    ratingText.setText("2.1");


                }
            }
        });

        //dummy data
        rb.setRating(3.5f);


        ImageView email=(ImageView) findViewById(R.id.imgEmail);
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                //dummy data
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"anna@webrun.ca"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello from TryAndFindMe");
                emailIntent.putExtra(Intent.EXTRA_TEXT   , "Hello, the following is the cache that "+"%username"+" shared with you!\n "+
                                                                    "Latitude: "+" 123.456"+" Langitude: "+ "456.133\n"+
                                                                     "Try and find it!");


                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(CachePage.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageView tweet=(ImageView) findViewById(R.id.imgTwitter);
        tweet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent tweet = new Intent(Intent.ACTION_VIEW);
                tweet.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + Uri.encode("Hey I just found a cache!\n"+
                        "Latitude: "+" 123.456"+" Langitude: "+ "456.133\n"+
                        "Try and find it too!")));
                try {
                    startActivity(tweet);
                    finish();
                    Log.i("Finished", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(CachePage.this, "There is no Twitter client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        printHash();

    }

    private void printHash(){
        try{
            PackageInfo info=getPackageManager()
                    .getPackageInfo("com.example.anna_gavrilova.project42", PackageManager.GET_SIGNATURES);
            for(Signature signature:info.signatures){
                MessageDigest md= MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("Sign", Base64.encodeToString(md.digest(),Base64.DEFAULT));
            }

        }catch(Exception e){e.printStackTrace();}
    }


}
