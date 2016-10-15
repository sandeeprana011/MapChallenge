package com.rana.mapchallenge.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rana.mapchallenge.R;
import com.rana.mapchallenge.database.Favorite;

import java.util.List;

public class ShowPointsOnMap extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_points_on_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        List<Favorite> favoriteList = Favorite.listAll(Favorite.class);
        for (Favorite favorite : favoriteList) {
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(favorite.getLatitude(), favorite.getLongitude()))
                    .title(favorite.getAddress()));
        }

    }
}
