package com.cs6392016.gbergy.stooperapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {
    Intent intent;


    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_contact_us, container, false);

        final ImageButton greg = (ImageButton)v.findViewById(R.id.gregbtn);
        greg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:411"));
                startActivity(intent);
            }
        });
        final ImageButton tony = (ImageButton)v.findViewById(R.id.tonybtn);
        tony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6465731388"));
                startActivity(intent);
            }
        });
        final ImageButton jones = (ImageButton)v.findViewById(R.id.jonesbtn);
        jones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6468316127"));
                startActivity(intent);
            }
        });


        return v;
    }

}
