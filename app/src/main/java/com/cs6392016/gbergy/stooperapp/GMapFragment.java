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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A placeholder fragment containing a simple view.
 */
public class GMapFragment extends Fragment implements OnMapReadyCallback {

    //private GoogleMap gMap;

    public GMapFragment() {
    }
    //final View v =  inflater.inflate(R.layout.fragment_login, container, false);
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        com.google.android.gms.maps.GMapFragment fragment;
//        fragment = (com.google.android.gms.maps.GMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
//        fragment.getMapAsync(this);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng parkSlope = new LatLng(40.668974, -73.976753);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(parkSlope, 15));
        googleMap.addMarker(new MarkerOptions().position(parkSlope).title("Park Slope, Brooklyn"));
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }
}



