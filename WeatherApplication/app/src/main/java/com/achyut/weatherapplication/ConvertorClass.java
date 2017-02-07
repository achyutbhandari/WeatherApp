package com.achyut.weatherapplication;

import android.util.Log;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bhand on 2/3/2017.
 */

public class ConvertorClass {

    public static Date getDate(long datelong) {
        Date cdate ;
        try {

            cdate = new Date(datelong * 1000);

        }
        catch (Exception e) {
            java.text.SimpleDateFormat inputFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            try {
                cdate = inputFormat.parse(String.valueOf(datelong*1000));

            }
            catch (ParseException e2) {
                cdate = new Date(); // make the error somewhat obvious

                e2.printStackTrace();
            }
        }
        return  cdate ;
    }

    public static Date getDay(long datelong) {
        Date cdate ;
        try {

            cdate = new Date(datelong * 1000);

        }
        catch (Exception e) {
            java.text.SimpleDateFormat inputFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            try {
                cdate = inputFormat.parse(String.valueOf(datelong*1000));

            }
            catch (ParseException e2) {
                cdate = new Date(); // make the error somewhat obvious

                e2.printStackTrace();
            }
        }
        return  cdate ;
    }

}
