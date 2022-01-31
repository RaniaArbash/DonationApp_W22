package com.example.donationapp_w22;

import android.widget.Toast;

public class Donation {
    double amount;
    int payment_method; // 0 for credit card and 1 for paypal
    boolean isShared;

    public Donation(double amount, int payment_method, boolean isShared) {
        this.amount = amount;
        this.payment_method = payment_method;
        this.isShared = isShared;
    }

    public Donation() {
    }

    String getDonationReport(){
        String p = (payment_method == 1)? "PayPal" : "Credit Card";
        return "Thank You For Your Donation with "+amount+ "$, Using " + p +" method!!";
    }
}
