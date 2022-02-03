//package com.exapl.volleyweather;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.io.ObjectInputStream;
//import java.text.BreakIterator;
//import java.util.List;
//
//class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ClubViewHolder> {
//
//    List<Club.Club1> clubs1;
//
//
//    RecyclerViewAdapter1(Context context, List<Club.Club1> clubs1) {
//        this.clubs1 = clubs1;
//
//    }
//
//    public RecyclerViewAdapter1(List<Club.Club1> clubs1) {
//    }
////
////    public RecyclerViewAdapter1(List<Club.Club1> clubs1) {
////    }
//
//
//    public static class ClubViewHolder extends RecyclerView.ViewHolder {
//        public BreakIterator sunny;
//        CardView cardView1;
//        TextView temp, time1;
//        ImageView img;
//
//        ClubViewHolder(View itemView) {
//            super(itemView);
//            cardView1 = (CardView) itemView.findViewById(R.id.cardView);
//            temp = (TextView) itemView.findViewById(R.id.temp);
//            time1 = (TextView) itemView.findViewById(R.id.time1);
//            img = (ImageView) itemView.findViewById(R.id.img);
//
//        }
//    }
//
//    @Override
//    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler1, parent, false);
//        ClubViewHolder cvh = new ClubViewHolder(view);
//        return cvh;
//    }
//
//    @Override
//    public void onBindViewHolder(ClubViewHolder holder, int position) {
//
////        Club.Club1 cl=clubs1.get(position);
//////           holder.text1.setText(clubs.get(position).name);
////             holder.time1.setText(cl.getTime());
//////                 holder.sunny.setText(cl.getName(position).name);
////                    holder.min.setText(clubs.get(position).name);
////                   holder.max.setText(clubs.get(position).name);
////                   holder.sunset1.setImageResource(clubs.get(position).logoid);
//
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView1) {
//        super.onAttachedToRecyclerView(recyclerView1);
//    }
//
//    @Override
//    public int getItemCount() {
//       return clubs1.size();
//    }
//}