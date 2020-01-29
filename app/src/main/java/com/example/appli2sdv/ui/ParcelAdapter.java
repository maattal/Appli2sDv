package com.example.appli2sdv.ui;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appli2sdv.Entities.Parcel;
import com.example.appli2sdv.R;
import com.example.appli2sdv.ui.Friends_Packets.Friends_PacketsViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParcelAdapter extends RecyclerView.Adapter<ParcelAdapter.ParcelViewHolder>{

    private Context myCtx;
    List<Parcel> parcelList=new ArrayList<Parcel>();

//    public ParcelAdapter(Context myCtx, List<Parcel> parcelList) {
//        this.myCtx = myCtx;
//        this.parcelList = parcelList;
//    }


        //la on a pas mis un truc de inflater
    public ParcelAdapter(Context context) {
        this.myCtx = context;

    }
class ParcelViewHolder extends RecyclerView.ViewHolder {
    TextView textViewAdress, textViewDelivery, textViewDate, textViewStatus,textViewType,textViewFragile;
    public ParcelViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewStatus = itemView.findViewById(R.id.text_Rview_status);
        textViewDelivery = itemView.findViewById(R.id.text_Rview_type);
        textViewDate = itemView.findViewById(R.id.text_Rview_Date);
        textViewAdress = itemView.findViewById(R.id.text_Rview_Adress);
        textViewType = itemView.findViewById(R.id.text_Rview_type);
        textViewFragile=itemView.findViewById(R.id.text_Rview_fragile);
    }
}

    //une view holder cest ce qui permet d'afficher correctement un element de la database dans la ligne
    @NonNull
    @Override
    public ParcelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myCtx.getApplicationContext()).inflate(R.layout.parcel_item_view, parent, false);
        return new ParcelViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ParcelAdapter.ParcelViewHolder holder, int position) {
        Parcel parcel = parcelList.get(position);
        if (parcel != null) {
            holder.textViewStatus.setText("status: " + parcel.getParcelStatus().name().toString());
            if (parcel.isIs_Fragile() == true) {
                holder.textViewFragile.setText("warning, this packet is fragile");
            } else {
                holder.textViewFragile.setText("this packet dosn't have a fragile contenu");
            }
            holder.textViewType.setText("type: " + parcel.getType_havila().name().toString());
            //holder.textViewDelivery.setText("Expeditor name: " + parcel.getRecipient().getName().toString());
            holder.textViewDate.setText("date: " + dateToString(parcel.getSendParcelDate()));
            holder.textViewAdress.setText("adress: " + parcel.getParcel_latitude() + " " + parcel.getParcel_longitude());
        } else
            holder.textViewStatus.setText("no parcel");
    }
    //je change juste ce quon affiche tahless
    //demader a yair commment on fais pour avoir l'adress si on a  fais lontitude et lagitude
    private String dateToString(Date mydate)
    {
        return new SimpleDateFormat("dd-MM-yyyy").format(mydate);
    }

//    private String locationToString(Location mylocation)
//    {
//        return "banane";//mylocation.getProvider();
//    }
    @Override
    public int getItemCount() {
        if (parcelList != null)
            return parcelList.size();
        else return 0;
    }

    public void setList(List<Parcel> list) {
        this.parcelList=list;
        notifyDataSetChanged();
    }


}
