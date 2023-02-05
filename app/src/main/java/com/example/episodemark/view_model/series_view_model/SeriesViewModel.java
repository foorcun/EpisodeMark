package com.example.episodemark.view_model.series_view_model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.episodemark.entity.Series;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SeriesViewModel extends ViewModel {
    //field variables
    MutableLiveData<List<Series>> seriesList = new MutableLiveData<>();

    //repository
    FirebaseFirestore db;

    public SeriesViewModel() {

        seriesList.postValue(new ArrayList<Series>());
        db = FirebaseFirestore.getInstance();
//        getSeries();

    }

    public void getSeriesDB(){

        db.collection("diziler")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                    pd.dismiss();
                        List<Series> newSeriesList = new ArrayList<>();
                        for(DocumentSnapshot doc: task.getResult()){
//                            Model model = new Model(null,doc.getString("diziName"),null);
//                            modelList.add(model);
                            Series series = new Series(0,null,doc.getString("diziName"));
                            newSeriesList.add(series);

                            Log.d("MainViewModel",series.toString());
                        }
                        seriesList.postValue(newSeriesList);

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //an error
//                    pd.dismiss();
                        Log.d("MainViewModel","onFailure calisti");

//                    Toast.makeText(ListActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public LiveData<List<Series>> getSeriesList() {
        return seriesList;
    }

}
