package com.digis2.ltevisualizer.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

import com.digis2.ltevisualizer.R;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

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
        setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.bg_filler));
    }

    /**
     * Set background color without changing percentage progress level
     *
     * @param color color to set in string format like "#006699"
     */
    public void setProgressColor(String color) {
        ClipDrawable clipDrawable = (ClipDrawable) getBackground();
        GradientDrawable rectDrawable = (GradientDrawable) clipDrawable.getDrawable();
        Objects.requireNonNull(rectDrawable).setColor(Color.parseColor(color));
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
