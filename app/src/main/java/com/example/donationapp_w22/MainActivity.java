package com.example.donationapp_w22;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);

        paypal = findViewById(R.id.paypal);
        credicCard = findViewById(R.id.credit_card);
        sharing_checkbox = findViewById(R.id.sharing_checkbox);
        donation_amout = findViewById(R.id.donation_amount);
        donate_btn = findViewById(R.id.donate_btn);

        myDonation =  ((MyApp)getApplication()).mainDonation;

        Log.d("donation"," is sharing " +  String.valueOf(myDonation.isShared));
        Log.d("donation","payment method" + String.valueOf(myDonation.payment_method));

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
        Toast.makeText(this,myDonation.getDonationReport(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.donate_btn:
                if (validate()){
                    double amount = Double.parseDouble(donation_amout.getText().toString());
                    myDonation.amount = amount;
                    //report();
                    // I need to open the Report Activity
                   // we need Intent Object

                    Intent myIntent = new Intent(this,Report.class);// messaging object
                    myIntent.putExtra("Name","Donation App");
                    myIntent.putExtra("year",2022);
                    myIntent.putExtra("month",1);

                    startActivity(myIntent);

                }else {
                    builder.setTitle("Error!!!");
                    builder.setMessage("You have to enter all values ...");
                    builder.setCancelable(true);
                    builder.setNegativeButton("OK",null);

                    builder.show();
                }
                break;
            case R.id.sharing_checkbox:
                myDonation.isShared = true;
                Log.d("donation"," is sharing " +  String.valueOf(myDonation.isShared));
                Log.d("donation","payment method" + String.valueOf(myDonation.payment_method));

                break;
            case R.id.paypal:
                myDonation.payment_method = 1;

                Log.d("donation"," is sharing " +  String.valueOf(myDonation.isShared));
                Log.d("donation","payment method" + String.valueOf(myDonation.payment_method));

                break;
            case R.id.credit_card:
                myDonation.payment_method = 0;

                Log.d("donation"," is sharing " +  String.valueOf(myDonation.isShared));
                Log.d("donation","payment method" + String.valueOf(myDonation.payment_method));

                break;
        }
    }
}