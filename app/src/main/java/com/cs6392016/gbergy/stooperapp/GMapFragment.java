package com.cs6392016.gbergy.stooperapp;

import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A placeholder fragment containing a simple view.
 */
public class GMapFragment extends Fragment implements OnMapReadyCallback {

    public GMapFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng parkSlope = new LatLng(40.668031, -73.976928);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parkSlope, 17));
        //   User location
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                googleMap.addMarker(new MarkerOptions()
                .position(parkSlope)
                .title("User")
                .snippet("Your location"));
        // Item Locations
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.666630, -73.977553))
                .title("Bike")
                .snippet("Brand New Bike!!")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.668225, -73.975622))
                .title("Text Book")
                .snippet("Great condition CS text books")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng( 40.666914, -73.974988))
                .title("Chair")
                .snippet("cool dining room chair ")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.666409, -73.977113))
                .title("Boots")
                .snippet("awesome work boots, too small for me")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.669385, -73.977923))
                .title("Blender")
                .snippet("great working condition")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

    }

}

