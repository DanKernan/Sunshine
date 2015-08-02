package com.kernan.dan.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;



/**
 * A placeholder fragment containing a simple view.
 */

public class ForecastFragment extends Fragment {

    //private ArrayAdapter<String> mForecastAdapter;
    public static  ArrayAdapter<String> mForecastAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }



    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_main, container);

/*
        String[] forecastArray = {
                "Today-Sunny-88/66",
                "Tomorrow-Foggy-70/46",
                "Weds-Cloudy-72/63",
                "Thurs-Rainy-64/61",
                "Fri-Foggy-70/46",
                "Sunday-76/68"
        };
*/

        //List<String> weekforecast = new ArrayList<String>(Arrays.asList(forecastArray));
        mForecastAdapter = new ArrayAdapter<String>(
                getActivity(),//this fragments parent
                R.layout.list_item_forecast,//ID of list item layout
                R.id.list_item_forecast_textview,//ID of textview to populate
                new ArrayList<String>());//made up data
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);


        //displays message when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                String forecast = mForecastAdapter.getItem(pos);
                //Toast.makeText(getActivity(), forecast, Toast.LENGTH_SHORT).show();
                //explicit request to DetailActivity
                Intent intent = new Intent(getActivity(), DetailActivity.class)
                    .putExtra(Intent.EXTRA_TEXT, forecast);
                startActivity(intent);

            }
        });




        return rootView;//inflater.inflate(R.layout.fragment_main, container, false);
    }
    //void void void




}

