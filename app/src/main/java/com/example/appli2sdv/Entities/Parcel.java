package com.example.appli2sdv.Entities;

import android.location.Location;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Ignore;
import com.google.firebase.database.Exclude;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName="parcels_table")
public class Parcel
{

    @PrimaryKey(autoGenerate = true)private long id;
    private Enums.Status_Parcel parcelStatus;
   private  Enums.Type_Parcel type_havila;
    private Enums.Weight_Parcel weight;
    boolean is_Fragile;
    public Double parcel_latitude;
    public Double parcel_longitude;
    private Location location_parcel;
    //Recipient recipient;
    String DeliveryName ;//donc ca cest le mec qui va etre choisi dans liste des gens qui se sont propose pour la transporter
    private Date sendParcelDate;
//constructors

    public Parcel() {
        location_parcel = new Location("");
        sendParcelDate = new Date();    }

    //getters and setters
    @Exclude
    public Location getLocation_parcel() {
        return location_parcel;
    }

    @Exclude
    public void setLocation_parcel(Location location_parcel) {
        this.location_parcel = location_parcel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enums.Status_Parcel getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(Enums.Status_Parcel parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Enums.Type_Parcel getType_havila() {
        return type_havila;
    }

    public void setType_havila(Enums.Type_Parcel type_havila) {
        this.type_havila = type_havila;
    }

    public Enums.Weight_Parcel getWeight() {
        return weight;
    }

    public void setWeight(Enums.Weight_Parcel weight) {
        this.weight = weight;
    }

    public boolean isIs_Fragile() {
        return is_Fragile;
    }

    public void setIs_Fragile(boolean is_Fragile) {
        this.is_Fragile = is_Fragile;
    }

    @Ignore
    public Double getParcel_latitude() {
        return parcel_latitude;
    }

    @Ignore
    public void setParcel_latitude(Double parcel_latitude) {
        this.parcel_latitude = parcel_latitude;
    }
@Ignore
    public Double getParcel_longitude() {
        return parcel_longitude;
    }
@Ignore
    public void setParcel_longitude(Double parcel_longitude) {
        this.parcel_longitude = parcel_longitude;
    }


    public String getDeliveryName() {
        return DeliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        DeliveryName = deliveryName;
    }

    @Exclude
    public Date getSendParcelDate() {
        return sendParcelDate;
    }
    @Exclude
    public void setSendParcelDate(Date sendParcelDate) {
        this.sendParcelDate = sendParcelDate;
    }

    public String getFBShippingDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(sendParcelDate);
    }


    public void setShippingDate(String shippingDate) {
        try {
            this.sendParcelDate = new SimpleDateFormat("dd/MM/yyyy").parse(shippingDate);
        }
        catch (Exception e){
            this.sendParcelDate = new Date();
        }
    }

}
