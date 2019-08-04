package com.example.fromfarm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fromfarm.R;

public class FarmTypeActivity extends AppCompatActivity {

    CardView cardCropFarm,cardDairyFarm,cardPoultryFarm,cardFishFarm;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_type);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(FarmTypeActivity.this, R.color.color_custom_blue));
        }

        cardCropFarm=findViewById(R.id.cardCropFarm);
        cardDairyFarm=findViewById(R.id.cardDairyFarm);
        cardPoultryFarm=findViewById(R.id.cardPoultryFarm);
        cardFishFarm=findViewById(R.id.cardFishFarm);

        intent=new Intent(getApplicationContext(),ItemListActivity.class);

        cardCropFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Crop farm selected",Toast.LENGTH_SHORT).show();
                intent.putExtra("type","crop");
                startActivity(intent);
            }
        });

        cardDairyFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Dairy farm selected",Toast.LENGTH_SHORT).show();
                intent.putExtra("type","diary");
                startActivity(intent);
            }
        });

        cardPoultryFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Poultry farm selected",Toast.LENGTH_SHORT).show();
                intent.putExtra("type","poultry");
                startActivity(intent);
            }
        });

        cardFishFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Fish farm selected",Toast.LENGTH_SHORT).show();
                intent.putExtra("type","fish");
                startActivity(intent);
            }
        });
    }
}
