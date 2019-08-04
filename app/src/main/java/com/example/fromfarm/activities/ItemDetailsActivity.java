package com.example.fromfarm.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fromfarm.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ItemDetailsActivity extends AppCompatActivity {

    private TextView itemNameTextView,itemPriceTextView;
    private ImageView itemImage;
    private FloatingActionButton buyItemFab;
    private CoordinatorLayout itemDetailCoordinatorLayout;

    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemDetailCoordinatorLayout=findViewById(R.id.itemDetailCoordinatorLayout);
        itemNameTextView=findViewById(R.id.itemNameDetails);
        itemPriceTextView=findViewById(R.id.itemPriceDetails);
        itemImage=findViewById(R.id.itemImageDetails);
        buyItemFab=findViewById(R.id.buyItemFab);

        Intent intent=getIntent();
        String imageUrl=intent.getStringExtra("imageUrl");
        String name=intent.getStringExtra("name");
        String price=intent.getStringExtra("price");

        itemNameTextView.setText(name);
        itemPriceTextView.setText(price);

        itemImage.setImageResource(Integer.parseInt(imageUrl));

        buyItemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(ItemDetailsActivity.this);
                alertDialog.setMessage("Do you want to buy this item")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                snackbar.make(itemDetailCoordinatorLayout,"Item bought",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Later",null)
                        .show();
            }
        });

    }
}
