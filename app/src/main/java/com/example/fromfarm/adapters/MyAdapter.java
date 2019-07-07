package com.example.fromfarm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fromfarm.ItemModel;
import com.example.fromfarm.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ItemModel> listItems;
    private Context context;

    public MyAdapter(List<ItemModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_cardview,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemModel itemModelObject=listItems.get(position);

        holder.imageViewItem.setImageResource(R.drawable.icon_cow_100px);
        holder.textViewName.setText(itemModelObject.getName());
        holder.textViewPrice.setText(itemModelObject.getPrice());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewItem;
        public TextView textViewName;
        public TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItem=itemView.findViewById(R.id.imageViewItem);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewPrice =itemView.findViewById(R.id.textViewPrice);
        }
    }

}
