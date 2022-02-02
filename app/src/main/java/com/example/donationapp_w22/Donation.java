package com.example.donationapp_w22;

import android.os.Parcel;
import android.os.Parcelable;

public class Donation implements Parcelable {
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

    protected Donation(Parcel in) {
        amount = in.readDouble();
        payment_method = in.readInt();
        isShared = in.readByte() != 0;
    }

    public static final Creator<Donation> CREATOR = new Creator<Donation>() {
        @Override
        public Donation createFromParcel(Parcel in) {
            return new Donation(in);
        }

        @Override
        public Donation[] newArray(int size) {
            return new Donation[size];
        }
    };

    String getDonationReport(){
        String p = (payment_method == 1)? "PayPal" : "Credit Card";
        return "Thank You For Your Donation with "+amount+ "$, Using " + p +" method!!";
    }

    public String toString(){
        String p = (payment_method == 1)? "PayPal" : "Credit Card";
        return "Donation with " + amount + "$, using "+ p +"method!!";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(amount);
        parcel.writeInt(payment_method);
        parcel.writeByte((byte) (isShared ? 1 : 0));
    }
}
