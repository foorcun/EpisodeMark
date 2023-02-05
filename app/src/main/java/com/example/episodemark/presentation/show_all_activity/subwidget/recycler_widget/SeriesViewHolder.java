package com.example.episodemark.presentation.show_all_activity.subwidget.recycler_widget;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.episodemark.R;
import com.example.episodemark.view_model.series_view_model.SeriesViewModel;

public class SeriesViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;
    View mView;

    public SeriesViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

        mTitle = itemView.findViewById(R.id.rTitle);

        // related with Click
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });
    }

    // related with Click
    private  SeriesViewHolder.ClickListener mClickListener;

    public interface ClickListener{
        void onItemClick(View view,int position);
    }
    public void setOnClickListener(SeriesViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }
}
