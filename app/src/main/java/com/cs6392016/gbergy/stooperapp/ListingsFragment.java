package com.cs6392016.gbergy.stooperapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListingsFragment extends Fragment {

    public ListingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listings, container, false);

        String [] states = {"Record", "Book", "Boots", "Chair", "Table", "Basketball",
                "Bowl", "Blanket", "Picture Frame", "Blender"};
        List<String> statesAL = new ArrayList<String>(Arrays.asList(states));

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listviewitem,
                R.id.textviewitem,
                statesAL);

        ListView lv = (ListView) rootView.findViewById(R.id.listViewLayout);
        lv.setAdapter(stateAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 9) {
                    Log.i("You Clicked", "An Item");

//                    String geoUri = String.format("geo:33.753504,-84.390265?z=10");
//                    Uri geo = Uri.parse(geoUri);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, geo);
//                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
