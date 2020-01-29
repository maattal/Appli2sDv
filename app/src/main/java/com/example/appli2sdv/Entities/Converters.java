package com.example.appli2sdv.Entities;

import android.location.Location;
import android.text.format.DateFormat;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converters
{
    //et tous les trucs que tas besoin
    //il sait choisir selon ce quil recoit et ce quil remvoie
    @TypeConverter
    public static Location stringToLocation(String fromRoom) {
        if (fromRoom != "") {
            String[] latlong = fromRoom.split(",");
            double latitude = Double.parseDouble(latlong[0]);
            double longitude = Double.parseDouble(latlong[1]);
            Location location = new Location("");
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            return location;
        }
        return null;
    }


    @TypeConverter
    public static String locationToString(Location location) {
        if (location!= null){
            return Location.convert(location.getLatitude(), Location.FORMAT_DEGREES) + "," + Location.convert(location.getLongitude(), Location.FORMAT_DEGREES);
        }
        return "";
    }

    @TypeConverter
    public static Enums.Type_Parcel getType(Integer numeral){
        for(Enums.Type_Parcel ds : Enums.Type_Parcel.values()){
            if(ds.ordinal() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static int TypeToInetger(Enums.Type_Parcel parcelType) {
        return parcelType.ordinal();
    }

    @TypeConverter
    public static Enums.Status_Parcel getStatus(Integer numeral){
        for(Enums.Status_Parcel ds : Enums.Status_Parcel.values()){
            if(ds.ordinal() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static int StatusToInetger(Enums.Status_Parcel status) {
        return status.ordinal();
    }
    @TypeConverter
    public static Enums.Weight_Parcel getWeight(Integer numeral){
        for(Enums.Weight_Parcel ds : Enums.Weight_Parcel.values()){
            if(ds.ordinal() == numeral){
                return ds;
            }
        }
        return null;
    }

    @TypeConverter
    public static int WeightToInetger(Enums.Weight_Parcel weight) {
        return weight.ordinal();
    }

    @TypeConverter
    public static Date getDate(String mystring)
    {
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

            date = formatter.parse(mystring);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @TypeConverter
    public static String DateToString(Date mydate)
    {
        return DateFormat.format("yyyy.MM.dd", mydate).toString();
    }

}
