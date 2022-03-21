package com.example.donationapp_w22;

import java.util.ArrayList;

public class DonationManager {

    ArrayList allDonations = new ArrayList(0);

    public void addDonation(Donation d){
        allDonations.add(d);
    }
}
