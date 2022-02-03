package com.exapl.volleyweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ClubViewHolder>
{
    private Context context;

            List<Club> clubs;

             RecyclerViewAdapter(Context context ,List<Club> clubs)

             {
                 this.context=context;
        this.clubs = clubs;

        }



                   @Override
              public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
               ClubViewHolder cvh = new ClubViewHolder(view);
             return cvh;
     }

               @Override
     public void onBindViewHolder(@NonNull RecyclerViewAdapter.ClubViewHolder holder, int position) {

                   Club cl=clubs.get(position);
//                   holder.min.setText(cl.getTemp());
                holder.sunny.setText(cl.getSunrise());
                   holder.text1.setText(cl.getDt());
                   holder.max.setText("25'c");
                   holder.min.setText("8'c");
//                   System.out.println("DDDDDDDDDDDDDDDD    " + cl.getDt());
//                   holder.max.setText(cl.getTemp());
//                   holder.max.setText(clubs.get(position).name);
//                   holder.sunset1.setImageResource(clubs.get(position).logoid);

 }

         @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        }

               @Override
  public int getItemCount() {
      return
              clubs.size();
       }

    public static class ClubViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView text1,sunny,min,max;
        ImageView sunset1;

        ClubViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            text1 = (TextView)itemView.findViewById(R.id.text1);
            sunset1 = (ImageView)itemView.findViewById(R.id.sunset1);
            sunny = (TextView)itemView.findViewById(R.id.sunny);
            min = (TextView)itemView.findViewById(R.id.min);
            max = (TextView)itemView.findViewById(R.id.max);
        }
    }

       }


//    @Override
//    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
//        Stores stores = storesList.get(position);
//
//        holder.storeName.setText(stores.getName());
//        holder.addressOfStore.setText(stores.getAddress());
//        holder.StoreLat.setText(stores.getStorelatitude());
//        holder.StoreLong.setText(stores.getStorelongitude());
//    }
//
//    @Override
//    public int getItemCount() {
//        return storesList.size();
//    }
//
//public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
//    public TextView storeName;
//    public TextView addressOfStore;
//    public ImageView storeImage;
//    public TextView StoreLong;
//    public TextView StoreLat;