package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Common metric class for LTE metrics that enable progress color filling
 */
public class MetricTextView extends androidx.appcompat.widget.AppCompatTextView {

    public MetricTextView(@NonNull Context context) {
        this(context, null);
    }

    public MetricTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        // TODO: set the background shape for progress and color rendering
//        setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.bg_filler));
    }

    /**
     * Set background color without changing percentage progress level
     *
     * @param color color to set in string format like "#006699"
     */
    public void setProgressColor(String color) {
        // TODO
    }

    /**
     * set background percentage level as progress
     *
     * @param percentage from 0 to 100
     */
    public void setProgressPercentage(int percentage) {
        getBackground().setLevel(percentage * 100);
    }
}
