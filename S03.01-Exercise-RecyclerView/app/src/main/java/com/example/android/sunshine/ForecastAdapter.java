// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// OK (15) Add a class file called ForecastAdapter

package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


// OK (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    // OK (23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // OK (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {

    }

    // OK (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // OK (17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
        // OK (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;

        // OK (19) Create a constructor for this class that accepts a View as a parameter
        // OK (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // OK (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView

        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    }

    // OK (24) Override onCreateViewHolder
    // OK (25) Within onCreateViewHolder, inflate the list item xml into a view
    // OK (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }

    // OK (27) Override onBindViewHolder
    // OK (28) Set the text of the TextView to the weather for this list item's position
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
       String weatherForThisDay = mWeatherData[position];
       forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }

    // OK (29) Override getItemCount
    // OK (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    @Override
    public int getItemCount() {
        if (null == mWeatherData) return 0;
        return mWeatherData.length;
    }

    // OK (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // OK (32) After you save mWeatherData, call notifyDataSetChanged
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
}
