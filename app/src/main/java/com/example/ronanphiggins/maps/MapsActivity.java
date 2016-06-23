package com.example.ronanphiggins.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(this.getResources().getColor(R.color.teal));


        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("info", "yep");
            }
        });
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

        int malperc = 20;
        int femperc = 40;


        for (int i = 20; i++; i < 20 ) {


            System.out.log(i)
        }

        // Add a marker in Sydney and move the camera
        LatLng ucd = new LatLng(53.306723, -6.223215);
        LatLng trinity = new LatLng(53.343262, -6.257071);
        //LatLng dit = new LatLng(53.338866, -6.268493);
        mMap.addMarker(new MarkerOptions().position(ucd).title(malperc + "%" + "" + "Males").icon(BitmapDescriptorFactory.fromResource(R.drawable.tab3)));
        mMap.addMarker(new MarkerOptions().position(trinity).title(femperc + "%" + "" + "Females").icon(BitmapDescriptorFactory.fromResource(R.drawable.tab3)));
        //mMap.addMarker(new MarkerOptions().position(dit).title("DIT Library").icon(BitmapDescriptorFactory.fromResource(R.drawable.tab3)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(trinity));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 11.0f ) );

    }
}
