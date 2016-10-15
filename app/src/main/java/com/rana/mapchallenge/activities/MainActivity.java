package com.rana.mapchallenge.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.rana.mapchallenge.R;
import com.rana.mapchallenge.database.Favorite;

public class MainActivity extends AppCompatActivity {
    int PLACE_PICKER_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewFavorite(View view) {

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);

        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            Log.e("Erro ", "play services");
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Added Place: %s", place.getName());
                String address = place.getName() + "\n" +
                        place.getAddress() + "\n";
                Favorite favorite = new Favorite(place.getLatLng().latitude, place.getLatLng().longitude, address);
                favorite.save();

                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void showFavoritePlaces(View view) {
        Intent intent = new Intent(this, ShowPointsOnMap.class);
        startActivity(intent);
    }
}
