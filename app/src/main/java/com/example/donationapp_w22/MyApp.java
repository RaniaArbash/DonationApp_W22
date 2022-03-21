package com.example.donationapp_w22;

import android.app.Application;

public class MyApp extends Application {


    DatabaseManager dbManager = new DatabaseManager();

    DonationManager manager = new DonationManager();
    Donation mainDonation = new Donation();



}
