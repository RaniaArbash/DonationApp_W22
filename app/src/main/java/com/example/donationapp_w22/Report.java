package com.example.donationapp_w22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Report extends AppCompatActivity
        implements
        DatabaseManager.DatabaseListener{

ListView listOfDonations;

DonationBaseAdapter adapter;
DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        listOfDonations = findViewById(R.id.donationList);
         DonationManager manager = ((MyApp)getApplication()).manager;
         dbManager = ((MyApp)getApplication()).dbManager;
        dbManager.listener = this;
        adapter = new DonationBaseAdapter(manager.allDonations,this);
        listOfDonations.setAdapter(adapter);
        listOfDonations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dbManager.deleteDonation((Donation) manager.allDonations.get(i));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem searchViewMenuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) searchViewMenuItem.getActionView();
        String searchFor = searchView.getQuery().toString();

        if (!searchFor.isEmpty()) {// toronto
            searchView.setIconified(false);
            searchView.setQuery(searchFor, false);
        }


        searchView.setQueryHint("Search for donation more that .... ");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                dbManager.getAllDonationsBiggerThan(Double.parseDouble(query));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public void onListReady(List<Donation> list) {
        adapter.listOfDonations = new ArrayList<>(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onAddDone() {

    }

    @Override
    public void onDeleteDone() {
        dbManager.getAllDonations();
    }
}