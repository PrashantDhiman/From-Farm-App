package com.example.fromfarm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        recyclerView=findViewById(R.id.recyclerViewItemList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        listItems=new ArrayList<>();
        
        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

        for(int i=0;i<20;i++){
            ItemModel itemModelObject=new ItemModel("Enter URL Here","Cow","₹50000");
            listItems.add(itemModelObject);
        }

        adapter=new MyAdapter(listItems,getApplicationContext());
        recyclerView.setAdapter(adapter);
    }
}
