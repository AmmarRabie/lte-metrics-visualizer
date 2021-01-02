package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

public class MetricsTable extends LinearLayoutCompat {
    private static final String TAG = "MetricsTable";

    public MetricsTable(@NonNull Context context) {
        this(context, null);
    }

    public MetricsTable(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.i(TAG, "MetricsTable: constructed");
        init();
    }


    private void init() {
        setOrientation(VERTICAL);

        Log.i(TAG, "init: init of table");
        inflate(getContext(), R.layout.header_metrics_table, this);
    }

    public void addValue(@NonNull LTEMetricsModel metrics) {
//        int metricRSRP = metrics.getRSRP(),
//                metricRSRQ = metrics.getRSRQ(),
//                metricSINR = metrics.getSINR();
        MetricsTableRow row = new MetricsTableRow(getContext());
        row.setMetrics(metrics);
        addView(row);
    }
}
