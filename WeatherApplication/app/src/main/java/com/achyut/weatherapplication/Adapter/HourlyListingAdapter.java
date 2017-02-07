package com.achyut.weatherapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.achyut.weatherapplication.ConvertorClass;
import com.achyut.weatherapplication.R;
import com.achyut.weatherapplication.rest.response.Datum_;

import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by bhand on 2/3/2017.
 */

public class HourlyListingAdapter extends RecyclerView.Adapter<HourlyListingAdapter.WeatherViewHolders> {

    ArrayList<Datum_> itemList;
    Context context;

    public HourlyListingAdapter(Context context, ArrayList<Datum_> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public WeatherViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_hourly, parent, false);
        WeatherViewHolders weatherViewHolder = new WeatherViewHolders(layoutView);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolders holder, int position) {

        DateFormat dateFormat = android.text.format.DateFormat.getMediumDateFormat(context);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context) ;
        holder.time.setText(""+ dateFormat.format(ConvertorClass.getDate(itemList.get(position).getTime()))+" - "+
        timeFormat.format(ConvertorClass.getDate(itemList.get(position).getTime())));
        holder.summary.setText("" + itemList.get(position).getSummary());
        holder.temperature.setText("Temperature : " + (int)((itemList.get(position).getTemperature()-32)/1.8)+
                (char) 0x00B0 + "c");
        holder.humidity.setText("Humidity :" + itemList.get(position).getHumidity()*100 +"%");
        holder.pressure.setText("Pressure : " + itemList.get(position).getPressure()+" mb");
        holder.visibility.setText("Visibility :" + itemList.get(position).getVisibility());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public static class WeatherViewHolders extends RecyclerView.ViewHolder {
        private TextView time, summary, temperature, humidity, pressure, visibility;

        public WeatherViewHolders(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv_time);
            summary = (TextView) itemView.findViewById(R.id.tv_summary);
            temperature = (TextView) itemView.findViewById(R.id.tv_temperature);
            humidity = (TextView) itemView.findViewById(R.id.tv_humidity);
            pressure = (TextView) itemView.findViewById(R.id.tv_pressure);
            visibility = (TextView) itemView.findViewById(R.id.tv_visibility);
        }
    }
}
