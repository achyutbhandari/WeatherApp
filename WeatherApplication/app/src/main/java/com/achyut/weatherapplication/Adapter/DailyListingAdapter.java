package com.achyut.weatherapplication.Adapter ;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.achyut.weatherapplication.ConvertorClass;
import com.achyut.weatherapplication.R;
import com.achyut.weatherapplication.rest.response.Datum__;

import java.text.DateFormat;
import java.util.ArrayList;

import retrofit2.Call;


/**
 * Created by bhand on 2/2/2017.
 */

public class DailyListingAdapter extends RecyclerView.Adapter<DailyListingAdapter.WeatherViewHolder> {

    ArrayList<Datum__> itemList;
    Context context;

    public DailyListingAdapter(Context context, ArrayList<Datum__> itemList) {
        this.itemList = itemList;
        this.context = context;
    }



    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_daily, parent, false);
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(layoutView);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        DateFormat dateFormat = android.text.format.DateFormat.getMediumDateFormat(context) ;
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        holder.time.setText("" + dateFormat.format(ConvertorClass.getDate(itemList.get(position).getTime())));
        holder.summary.setText("" + itemList.get(position).getSummary());
        holder.sunrise.setText("Sunrise : " + timeFormat.format(ConvertorClass.getDate(itemList.get(position).getSunriseTime())));
        holder.sunset.setText("Sunset : " + timeFormat.format(ConvertorClass.getDate(itemList.get(position).getSunsetTime())));
        holder.temperatureMax.setText("Maximum Temperature : " + (int)((itemList.get(position).getTemperatureMax()-32)/1.8)+
                (char) 0x00B0 + "c");
        holder.temperatureMin.setText("Minimum Temperature : " + (int)((itemList.get(position).getTemperatureMin()-32)/1.8)+
                (char) 0x00B0 + "c");
        holder.humidity.setText("Humidity :" + itemList.get(position).getHumidity()*100 +"%");
        holder.pressure.setText("Pressure : " + itemList.get(position).getPressure()+" mb");
        holder.visibility.setText("Visibility :" + itemList.get(position).getVisibility());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private TextView time, summary, sunrise, sunset, temperatureMax, temperatureMin, humidity, pressure, visibility;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            summary = (TextView) itemView.findViewById(R.id.tv_summary);
            sunrise = (TextView) itemView.findViewById(R.id.tv_sunrise);
            sunset = (TextView) itemView.findViewById(R.id.tv_sunset);
            temperatureMax = (TextView) itemView.findViewById(R.id.tv_temperatureMax);
            temperatureMin = (TextView) itemView.findViewById(R.id.tv_temperatureMin);
            humidity = (TextView) itemView.findViewById(R.id.tv_humidity);
            pressure = (TextView) itemView.findViewById(R.id.tv_pressure);
            visibility = (TextView) itemView.findViewById(R.id.tv_visibility);

        }
    }
}