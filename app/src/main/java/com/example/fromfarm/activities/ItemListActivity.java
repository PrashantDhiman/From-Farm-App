package com.example.fromfarm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.fromfarm.ItemModel;
import com.example.fromfarm.adapters.MyAdapter;
import com.example.fromfarm.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ItemModel> listItems;

    private ItemModel itemModelObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        Intent intent=getIntent();
        String farmType=intent.getStringExtra("type");

        recyclerView=findViewById(R.id.recyclerViewItemList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        listItems=new ArrayList<>();

        if(farmType.equals("crop")){
            itemModelObject=new ItemModel(String.valueOf(R.drawable.icon_corn_96px),"Crop","₹5000");
        }else if(farmType.equals("diary")){
            itemModelObject=new ItemModel(String.valueOf(R.drawable.icon_cow_100px),"Diary","₹500");
        }else if(farmType.equals("poultry")){
            itemModelObject=new ItemModel(String.valueOf(R.drawable.icon_eggs_96px),"Poultry","₹100");
        }else if(farmType.equals("fish")){
            itemModelObject=new ItemModel(String.valueOf(R.drawable.icon_fish_96px),"Fish","₹600");
        }
        
        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

        for(int i=0;i<20;i++){
            listItems.add(itemModelObject);
        }

        adapter=new MyAdapter(listItems,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
