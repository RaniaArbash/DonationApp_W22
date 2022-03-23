package com.example.donationapp_w22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DonationBaseAdapter extends BaseAdapter {
ArrayList<Donation> listOfDonations;
Context context;

    public DonationBaseAdapter(ArrayList<Donation> listOfDonations, Context context) {
        this.listOfDonations = listOfDonations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfDonations.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfDonations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view = LayoutInflater.from(context).inflate(R.layout.base_adapter_row_layout,null);

       TextView amountText = view.findViewById(R.id.list_amount);
       TextView paymentMethodText = view.findViewById(R.id.list_pmethod);
        String method;
        method = (listOfDonations.get(i).payment_method == 1)? "PayPal" : "Credit Card";

        amountText.setText(String.valueOf(listOfDonations.get(i).amount));
       paymentMethodText.setText(method);

      // img.setImageResource(R.drawable.img);
        return view;
    }
}
