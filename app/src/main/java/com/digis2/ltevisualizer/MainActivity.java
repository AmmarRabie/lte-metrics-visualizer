package com.digis2.ltevisualizer;

import android.os.Bundle;
import android.util.Log;

import com.digis2.ltevisualizer.common.IDataService;
import com.digis2.ltevisualizer.common.MockRepo;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MockRepo mockRepo = new MockRepo();
        mockRepo.poolRandomMetrics(1000, new IDataService.Get<LTEMetricsModel>() {
            @Override
            public void onDataFetched(LTEMetricsModel data) {
                Log.i(TAG, "onDataFetched: data fetched");
            }
        });
    }
}