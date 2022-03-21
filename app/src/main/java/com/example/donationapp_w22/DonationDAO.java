package com.example.donationapp_w22;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DonationDAO {

    @Insert
    void addNewDonationToDB(Donation newDonation);

    @Delete
    void deleteDonation(Donation toDeleteDonation);

    @Query("SELECT * FROM Donation")
    List<Donation> getAll();

    @Query("Select * from Donation where donation_amout >= :amout")
    List<Donation> getAllDonationsMoreThan(double amout);

    @Query("Select * from Donation where payment_method == :paymentMethod")
    List<Donation> getAllDonationsWithPM(int paymentMethod);



}
