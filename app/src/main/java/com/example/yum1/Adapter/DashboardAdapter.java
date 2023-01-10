package com.example.yum1.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yum1.R;
import com.example.yum1.Restaurant;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyHolderView> {
    
    Context context;
    ArrayList<Restaurant> list;

    public DashboardAdapter(Context context, ArrayList<Restaurant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DashboardAdapter.MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.dashboard_card_item, parent,false);
        return new MyHolderView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.MyHolderView holder, int position) {
        Restaurant restaurant = list.get(position);
        holder.title.setText(restaurant.getName());
        holder.location.setText(restaurant.getLocation());
        holder.rating.setText(Double.toString(restaurant.getRating()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolderView extends RecyclerView.ViewHolder {
        TextView title,location,rating;
        ImageView image;

        public MyHolderView(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.dashboard_card_title);
            location = itemView.findViewById(R.id.dashboard_card_location);
            rating = itemView.findViewById(R.id.dashboard_card_rating);
            image = itemView.findViewById(R.id.dashboard_card_imgview);
        }
    }
}
