package com.example.donationapp_w22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button donate_btn;
    RadioButton paypal;
    RadioButton credicCard;

    CheckBox sharing_checkbox;
    EditText donation_amout;
    Donation myDonation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paypal = findViewById(R.id.paypal);
        credicCard = findViewById(R.id.credit_card);
        sharing_checkbox = findViewById(R.id.sharing_checkbox);
        donation_amout = findViewById(R.id.donation_amount);
        donate_btn = findViewById(R.id.donate_btn);
        myDonation = new Donation();

        paypal.setOnClickListener(this);
        credicCard.setOnClickListener(this);
        donate_btn.setOnClickListener(this);
        sharing_checkbox.setOnClickListener(this);

    }


    public boolean validate(){
        boolean valid = false;
        if (paypal.isChecked() || credicCard.isChecked()){ // validate payment method
            if (!donation_amout.getText().toString().isEmpty()) // validate the amount
                valid = true;
        }
        return valid;
    }

    public void report(){
        String method;
        method = (myDonation.payment_method == 1)? "PayPal" : "Credit Card";
        Toast.makeText(this,"Thank You For Your Donation with "+myDonation.amount+ "$, Using " + method +" method!!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.donate_btn:
                if (validate()){
                    double amount = Double.parseDouble(donation_amout.getText().toString());
                    myDonation.amount = amount;
                    report();
                }
                break;
            case R.id.sharing_checkbox:
                myDonation.isShared = true;
                break;
            case R.id.paypal:
                myDonation.payment_method = 1;
                break;
            case R.id.credit_card:
                myDonation.payment_method = 0;
                break;
        }
    }
}