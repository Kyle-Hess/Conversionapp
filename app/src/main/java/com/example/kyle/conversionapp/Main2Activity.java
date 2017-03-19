package com.example.kyle.conversionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button buttonLength;
    private Button buttonSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonLength = (Button)findViewById(R.id.buttonLength);
        buttonSpeed = (Button)findViewById(R.id.buttonSpeed);



        buttonLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLength = new Intent(Main2Activity.this, MainActivity.class);
                intentLength.putExtra("unit", "length");
//                String length = "length";
//                MainActivity mainActivity = new MainActivity();
//                mainActivity.dataAdapter(length);
                startActivity(intentLength);
            }
        });

        buttonSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSpeed = new Intent(Main2Activity.this, MainActivity.class);
                intentSpeed.putExtra("unit", "speed");
//                String speed = "speed";
//                MainActivity mainActivity = new MainActivity();
//                mainActivity.dataAdapter(speed);
                startActivity(intentSpeed);

            }
        });
    }
}
