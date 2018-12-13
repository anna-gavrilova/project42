package com.example.anna_gavrilova.project42;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CacheMap extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private double clat;
    private double clang;
    private double mylat;
    private double mylang;
    private static final int LOCATION_CODE = 1;
    private LocationManager locationManager;
    //MarkerOptions mark=new MarkerOptions().title("Me");;
    Marker mark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        clat = this.getIntent().getExtras().getDouble("lat");
        clang = this.getIntent().getExtras().getDouble("long");


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_CODE);
        }

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mark=mMap.addMarker(new MarkerOptions()
                .position(new LatLng(mylat, mylang))
                .title("Me"));
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(clat, clang))
                .title("Cache"));
        mark.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.me));
        // Add a marker in Sydney and move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(mylat, mylang)));
        requestDirections();
    }

    @Override
    public void onLocationChanged(Location location) {

        if(mMap!=null){
            LatLng pos=new LatLng(location.getLatitude(),location.getLongitude());
            mark.setPosition(pos);
            mMap.animateCamera(CameraUpdateFactory.newLatLng(pos));
            mylat=location.getLatitude();
            mylang=location.getLongitude();

        }
        else{
            mylat=location.getLatitude();
            mylang=location.getLongitude();
        }
        requestDirections();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void requestDirections(){
        StringBuilder sb;

        Object[] dataTransfer=new Object[4];
        sb=new StringBuilder();
        sb.append("https://maps.googleapis.com/maps/api/directions/json?");
        sb.append("origin="+mylat+","+mylang);
        sb.append("&destination="+clat+","+clang);
        sb.append("&key=AIzaSyBJL35Pgto00Eq0hHprDu0d_xbl4EoAODs");
        sb.append("&alternatives=true");

        DirectionsData getDirectionsData= new DirectionsData(getApplicationContext());
        dataTransfer[0]=mMap;
        dataTransfer[1]=sb.toString();
        dataTransfer[2]=new LatLng(mylat,mylang);
        dataTransfer[3]=new LatLng(clat,clang);

        getDirectionsData.execute(dataTransfer);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public void onPause(){
        super.onPause();
        locationManager.removeUpdates(this);

    }
}
