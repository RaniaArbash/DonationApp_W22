package com.example.donationapp_w22;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Donation {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "donation_amout")
    double amount;
    int payment_method; // 0 for credit card and 1 for paypal

    @Ignore
    boolean isShared;



    public Donation(double amount, int payment_method, boolean isShared) {
        this.amount = amount;
        this.payment_method = payment_method;
        this.isShared = isShared;
    }

    public Donation() {
    }
}
