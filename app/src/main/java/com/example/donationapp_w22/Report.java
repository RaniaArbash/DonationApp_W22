package com.example.donationapp_w22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Report extends AppCompatActivity {
TextView reportTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        int year = getIntent().getExtras().getInt("year");
        String valueFromFA =  getIntent().getExtras().getString("Name");

        if (getIntent().hasExtra("month")){
            Log.d("Second Activity", String.valueOf(year));
            Log.d("Second Activity", valueFromFA);
            Log.d("Second Activity", String.valueOf(getIntent().getExtras().getInt("month")));
        }

        Donation mainDonationObj = ((MyApp)getApplication()).mainDonation;
        reportTV = findViewById(R.id.reportText);




        reportTV.setText(mainDonationObj.getDonationReport());

    }
}