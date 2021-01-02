package com.digis2.ltevisualizer.common;

import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.annotation.NonNull;

/**
 * In-application simple implementation of DataService, for mocking
 */
public class MockRepo implements IDataService {
    @Override
    public void getRandomMetrics(@NonNull Get<LTEMetricsModel> callback) {

    }

    @Override
    public void poolRandomMetrics(long periodMillis, Get<LTEMetricsModel> callback) {

    }
}
