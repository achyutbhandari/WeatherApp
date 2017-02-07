package com.achyut.weatherapplication;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.achyut.weatherapplication.Adapter.DailyListingAdapter;
import com.achyut.weatherapplication.rest.RetrofitManager;
import com.achyut.weatherapplication.rest.response.Datum__;
import com.achyut.weatherapplication.rest.response.WeatherList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private ArrayList<Datum__> dailyList = new ArrayList<>();
    private DailyListingAdapter dailyListingAdapter  ;


    public DailyFragment() {
        // Required empty public constructor
    }

    public static DailyFragment newInstance(int sectionNumber) {

        Bundle args = new Bundle();

        DailyFragment fragment = new DailyFragment();
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
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(getActivity()) ;
        linearLayoutManagers.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManagers);
        getDailyWeather();
        SharedPreferences  sharedPreferences = getActivity().getSharedPreferences("MyData", Context.MODE_PRIVATE);

        dailyListingAdapter = new DailyListingAdapter(getContext(), dailyList);
        recyclerView.setAdapter(dailyListingAdapter);

        return  rootView ;
    }

    public  void  getDailyWeather(){
        RetrofitManager.getInstance().getWeatherForecast(BuildConfig.TDSAPIKEY, MainActivity.getLatLong(), new Callback<WeatherList>() {
            @Override
            public void onResponse(Call<WeatherList> call, Response<WeatherList> response) {
                if (response.code() == 200) {
                    dailyList.addAll(response.body().getDaily().getData("data"));
                    dailyListingAdapter.notifyDataSetChanged();
                    return;
                }
            }

            @Override
            public void onFailure(Call<WeatherList> call, Throwable t) {

            }
        });

    }

}
