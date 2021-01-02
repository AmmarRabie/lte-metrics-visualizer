package com.digis2.ltevisualizer.common;

import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;

/**
 * In-application simple implementation of DataService, for mocking
 */
public class MockRepo implements IDataService {
    @Override
    public void getRandomMetrics(@NonNull Get<LTEMetricsModel> callback) {
        callback.onDataFetched(new LTEMetricsModel(0, 1, 2));
    }

    @Override
    public Timer poolRandomMetrics(long periodMillis, Get<LTEMetricsModel> callback) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate((new TimerTask() {
            @Override
            public void run() {
                getRandomMetrics(callback);
            }
        }), 0, periodMillis);
        return timer;
    }
}
