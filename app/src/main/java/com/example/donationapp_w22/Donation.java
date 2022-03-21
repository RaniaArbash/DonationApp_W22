package com.example.donationapp_w22;

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
}
