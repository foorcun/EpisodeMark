package com.example.episodemark.presentation.show_all_activity.subwidget.recycler_widget;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.episodemark.R;
import com.example.episodemark.ShowAllActivity;
import com.example.episodemark.entity.Series;

import java.util.List;

public class SeriesAdapter  extends RecyclerView.Adapter<SeriesViewHolder> {

    //ilgili activity
    ShowAllActivity showAllActivity;

    // ilgili data listesi
    List<Series> seriesList;

//    Context context;

    public SeriesAdapter(ShowAllActivity showAllActivity, List<Series> seriesList) {
        this.showAllActivity = showAllActivity;
        this.seriesList = seriesList;
    }


    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_all_activity_recycler_model_layout,parent,false);

        SeriesViewHolder seriesViewHolder = new SeriesViewHolder(itemView);

        // handle item clicks here

        seriesViewHolder.setOnClickListener(new SeriesViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //
                String title = seriesList.get(position).getDiziName();
                Log.d("series_adapter","tiklandi. position: " + position);
                Log.d("series_adapter",seriesList.get(position).getDiziName());
                Toast.makeText(showAllActivity,"title bu: " + title,Toast.LENGTH_SHORT).show();
            }
        });

        return  seriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, int position) {
        holder.mTitle.setText(seriesList.get(position).getDiziName());


    }

    @Override
    public int getItemCount() {
return seriesList.size();
    }
}
