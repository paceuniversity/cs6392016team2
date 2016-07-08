package com.cs6392016.gbergy.stooperapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Createlisting extends Fragment {


    public Createlisting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_createlisting, container, false);


        final EditText ettitle = (EditText) v.findViewById(R.id.edtitle);
        final EditText etcategory = (EditText) v.findViewById(R.id.edcategory);
        final EditText etcondition = (EditText) v.findViewById(R.id.edcondition);
        final EditText etaddress = (EditText) v.findViewById(R.id.edstreet);
        final EditText etcity = (EditText) v.findViewById(R.id.edcity);
        final Button sbbtn = (Button) v.findViewById(R.id.subbtn);

        sbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = ettitle.getText().toString();
                final String category = etcategory.getText().toString();
                final String condition = etcondition.getText().toString();
                final String address = etaddress.getText().toString();
                final String city = etcity.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                startActivity(new Intent(getActivity(), Login.class));
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setMessage("Account with that username already exist. Please try again.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                CreateRequest createRequest = new CreateRequest(title, category, condition, address, city, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(createRequest);
            }
        });







        return v;
    }

}
