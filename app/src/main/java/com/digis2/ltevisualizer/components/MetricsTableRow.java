package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

/**
 * display one entry of LTE
 */
public class MetricsTableRow extends LinearLayoutCompat {

    private MetricTextView value1View;
    private MetricTextView value2View;
    private MetricTextView value3View;

    public MetricsTableRow(@NonNull Context context) {
        super(context);
        init();
    }

    public MetricsTableRow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MetricsTableRow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setOrientation(VERTICAL);

        LayoutInflater.from(getContext()).inflate(R.layout.item_table, this);

        value1View = findViewById(R.id.tr_txt_val1);
        value2View = findViewById(R.id.tr_txt_val2);
        value3View = findViewById(R.id.tr_txt_val3);

//        value1View.setProgressColor("#006699");
//        value2View.setProgressColor("#990000");
//        value3View.setProgressColor("#009900");
//
//        value1View.setProgressPercentage(100);
//        value2View.setProgressPercentage(70);
//        value3View.setProgressPercentage(30);
    }

    public void setMetrics(LTEMetricsModel metrics){
        value1View.setText(String.valueOf(metrics.getSINR()));
        value2View.setText(String.valueOf(metrics.getRSRP()));
        value3View.setText(String.valueOf(metrics.getRSRQ()));
    }
}
