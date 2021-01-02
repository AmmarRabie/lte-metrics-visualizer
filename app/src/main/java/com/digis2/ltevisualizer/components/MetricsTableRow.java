package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;
import com.digis2.ltevisualizer.common.utils.Legend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * display one entry of LTE
 */
public class MetricsTableRow extends LinearLayoutCompat {

    private final MetricTextView[] valuesViews = new MetricTextView[3];

    public MetricsTableRow(@NonNull Context context) {
        this(context, null);
    }

    public MetricsTableRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);

        LayoutInflater.from(getContext()).inflate(R.layout.item_table, this);

        int[] ids = {R.id.tr_txt_val1, R.id.tr_txt_val2, R.id.tr_txt_val3};
        for (int i = 0; i < ids.length; i++) valuesViews[i] = findViewById(ids[i]);
    }

    public void setMetrics(LTEMetricsModel metrics) {
        // display order defined here
        final String[] names = {"SINR", "RSRP", "RSRQ"};
        final int[] values = {metrics.getSINR(), metrics.getRSRP(), metrics.getRSRQ()};

        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            valuesViews[i].setText(String.valueOf(v));
            valuesViews[i].setProgressColor(Legend.calcColor(getContext(), names[i], v));
            valuesViews[i].setProgressPercentage(Legend.calcProgress(getContext(), names[i], v));
        }
    }
}
