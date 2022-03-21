package com.example.donationapp_w22;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseManager {

    interface DatabaseListener {
        void onListReady (List<Donation> list);
        void onAddDone();
    }

    DatabaseListener listener;
    static DonationDataBase db;
    ExecutorService databaseExecutor =
            Executors.newFixedThreadPool(4);
    Handler mainThread_Handler = new Handler(Looper.getMainLooper());



    private static void buildDBInstance(Context context){
        db = Room.databaseBuilder(context,
                DonationDataBase.class, "donation_db").build();
    }

    public DonationDataBase getDb(Context context){
        if (db == null)
            buildDBInstance(context);
        return db;
    }


    public void saveNewDonation(Donation newDonation){
        databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                db.donationDao().addNewDonationToDB(newDonation);

                mainThread_Handler.post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onAddDone();
                    }
                });
            }
        });
    }


    public  void getAllDonations(){
        databaseExecutor.execute(new Runnable() {
            @Override
            public void run() {
                List<Donation> list =  db.donationDao().getAll();
                mainThread_Handler.post(new Runnable() { // go to main thread
                    @Override
                    public void run() {
                        listener.onListReady(list);
                    }
                });
            }
        });

    }


}
