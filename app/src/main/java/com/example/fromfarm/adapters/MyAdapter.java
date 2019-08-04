package com.example.fromfarm.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fromfarm.ItemModel;
import com.example.fromfarm.R;
import com.example.fromfarm.activities.ItemDetailsActivity;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        ItemModel itemModelObject=listItems.get(position);

        holder.imageViewItem.setImageResource(Integer.parseInt(itemModelObject.getImageURL()));
        holder.textViewName.setText(itemModelObject.getName());
        holder.textViewPrice.setText(itemModelObject.getPrice());

        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),ItemDetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("imageUrl",listItems.get(position).getImageURL());
                bundle.putString("name",listItems.get(position).getName());
                bundle.putString("price",listItems.get(position).getPrice());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageViewItem;
        public TextView textViewName;
        public TextView textViewPrice;
        public CardView itemCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewItem=itemView.findViewById(R.id.imageViewItem);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewPrice =itemView.findViewById(R.id.textViewPrice);
            itemCardView=itemView.findViewById(R.id.itemCardView);
        }
    }

}
