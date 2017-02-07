package com.achyut.weatherapplication;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achyut.weatherapplication.Adapter.HourlyListingAdapter;
import com.achyut.weatherapplication.rest.RetrofitManager;
import com.achyut.weatherapplication.rest.response.Datum_;
import com.achyut.weatherapplication.rest.response.WeatherList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private ArrayList<Datum_> hourlyList = new ArrayList<>();
    private HourlyListingAdapter listingAdapter = null;



    public HourlyFragment() {
        // Required empty public constructor
    }

    public static HourlyFragment newInstance(int sectionNumber) {

        Bundle args = new Bundle();

        HourlyFragment fragment = new HourlyFragment();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        getHourlyWeatherList();
        listingAdapter = new HourlyListingAdapter(getContext(), hourlyList );
        recyclerView.setAdapter(listingAdapter);

        return rootView;
    }


    public void getHourlyWeatherList() {
        RetrofitManager.getInstance().getWeatherForecast(BuildConfig.TDSAPIKEY,MainActivity.getLatLong(), new Callback<WeatherList>() {
            @Override
            public void onResponse(Call<WeatherList> call, Response<WeatherList> response) {
                hourlyList.addAll(response.body().getHourly().getData("data"));
                listingAdapter.notifyDataSetChanged();


            }


            @Override
            public void onFailure(Call<WeatherList> call, Throwable t) {

            }
        });

    }

}
