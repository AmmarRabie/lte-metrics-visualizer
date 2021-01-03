package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MetricsTable extends FrameLayout {
    private static final String TAG = "MetricsTable";
    private ViewGroup contentContainerView;

    public MetricsTable(@NonNull Context context) {
        this(context, null);
    }

    public MetricsTable(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
//        setOrientation(VERTICAL);

        // add the header from the resource file
        inflate(getContext(), R.layout.metrics_table, this);

        contentContainerView = (ViewGroup) findViewById(R.id.metrics_table_content_container);
//        ((NestedScrollView) getParent()).fullScroll(View.FOCUS_DOWN);
    }

    public void addValue(@NonNull LTEMetricsModel metrics, boolean auto_scroll) {
        MetricsTableRow row = new MetricsTableRow(getContext());
        row.setMetrics(metrics);
        contentContainerView.addView(row);
        if (auto_scroll)
            ((ScrollView) contentContainerView.getParent()).fullScroll(View.FOCUS_DOWN);
    }

    public void addValue(@NonNull LTEMetricsModel metrics) {
        addValue(metrics, true);
    }
}
