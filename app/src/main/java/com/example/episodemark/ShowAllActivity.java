package com.example.episodemark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.episodemark.entity.Series;
import com.example.episodemark.presentation.show_all_activity.subwidget.recycler_widget.SeriesAdapter;
import com.example.episodemark.view_model.series_view_model.SeriesViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShowAllActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SeriesAdapter adapter;

    ProgressDialog pd;

    // ViewModel
    SeriesViewModel seriesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        //navbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Series");


        //initialize ViewModel
        seriesViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);

        // initialize Adapter
        recyclerView = findViewById(R.id.recycler_shows);
        //        //set recyclerview properties
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //empty Adapter
        //adapter
        adapter = new SeriesAdapter(ShowAllActivity.this, new ArrayList<Series>());

        //set adapter
        recyclerView.setAdapter(adapter);


        seriesViewModel.getSeriesDB(); // get data from Database
        seriesViewModel.getSeriesList().observe(this, new Observer<List<Series>>() {
            @Override
            public void onChanged(List<Series> series) {

                //adapter
                adapter = new SeriesAdapter(ShowAllActivity.this, series);

                //set adapter
                recyclerView.setAdapter(adapter);

            }
        });




    }
}