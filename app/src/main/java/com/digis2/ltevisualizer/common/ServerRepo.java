package com.digis2.ltevisualizer.common;

import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import java.util.Timer;

import androidx.annotation.NonNull;

public class ServerRepo implements IDataService {

    @Override
    public void getRandomMetrics(@NonNull Get<LTEMetricsModel> callback) {
        // TODO
    }

    @Override
    public Timer poolRandomMetrics(long periodMillis, Get<LTEMetricsModel> callback) {
        // TODO, make use of getRandomMetrics
        return null;
    }
}
