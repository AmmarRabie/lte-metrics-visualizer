package com.digis2.ltevisualizer.visualizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.IMetricsObserver;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import androidx.fragment.app.Fragment;

/**
 * Responsible for rendering the metrics line chart, container
 */
public class ChartFragment extends Fragment implements IMetricsObserver {
    private static final String TAG = "ChartFragment";

    private ViewGroup rootView;

    public ChartFragment() {
        // Required empty public constructor
    }


    public static ChartFragment newInstance(String param1, String param2) {
        return new ChartFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_chart, container, false);
        rootView = (ViewGroup) parent.findViewById(R.id.frg_chart_container);
        return parent;
    }

    @Override
    public void onNewItem(LTEMetricsModel item) {
        TextView newView = new TextView(getContext());
        newView.setText(String.valueOf(item.getSINR()));
        rootView.addView(newView);
    }

    @Override
    public void onClearAll() {

    }
}