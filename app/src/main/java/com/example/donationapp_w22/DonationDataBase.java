package com.example.donationapp_w22;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Donation.class}, version = 1)
    public abstract class DonationDataBase extends RoomDatabase {
        public abstract DonationDAO donationDao();
}
