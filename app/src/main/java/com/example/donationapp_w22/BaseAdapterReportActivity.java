package com.example.donationapp_w22;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BaseAdapterReportActivity extends AppCompatActivity {

    ListView baseAdapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseadpaterlist);

        baseAdapterList = findViewById(R.id.baseAdapterList);
        ArrayList<Donation> list = ((MyApp)getApplication()).manager.allDonations;

        DonationBaseAdapter adapter = new DonationBaseAdapter(list,this);
        baseAdapterList.setAdapter(adapter);

    }


}
