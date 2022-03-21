package com.example.donationapp_w22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Report extends AppCompatActivity {
TextView reportTV;
ListView listOfDonations;

Spinner collegeSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        int year = getIntent().getExtras().getInt("year");
        String valueFromFA =  getIntent().getExtras().getString("Name");

        Donation objectFromMainActivity = getIntent().getExtras().getParcelable("currentDonationObj");

        if (getIntent().hasExtra("month")){
            Log.d("Second Activity", String.valueOf(year));
            Log.d("Second Activity", valueFromFA);
            Log.d("Second Activity", String.valueOf(getIntent().getExtras().getInt("month")));
        }

        //Donation mainDonationObj = ((MyApp)getApplication()).mainDonation;
        reportTV = findViewById(R.id.reportText);
        listOfDonations = findViewById(R.id.donationList);


        String[] colores = new String[] {"Red","Green","Black"};
        String[] colleges = new String[] {"Seneca","Humber","Niagra College"};


        DonationManager manager = ((MyApp)getApplication()).manager;
        int size = manager.allDonations.size();
        String[] allDonationsArray = new String[size];
        for (int i = 0 ;i< size ;i ++){
            allDonationsArray[i] = manager.allDonations.get(i).toString();
        }


        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.item_row_layout,R.id.donation_row,allDonationsArray);
        listOfDonations.setAdapter(adapter);


       ArrayAdapter spinnerAdapter = new ArrayAdapter(this,R.layout.item_row_layout,R.id.donation_row,colleges);
        collegeSpinner = findViewById(R.id.college_spinner);

        collegeSpinner.setAdapter(spinnerAdapter);


        reportTV.setText(objectFromMainActivity.getDonationReport());

    }
}