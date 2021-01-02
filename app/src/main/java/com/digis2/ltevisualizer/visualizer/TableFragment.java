package com.digis2.ltevisualizer.visualizer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.digis2.ltevisualizer.R;
import com.digis2.ltevisualizer.common.IMetricsObserver;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;
import com.digis2.ltevisualizer.components.MetricsTable;

import androidx.fragment.app.Fragment;

/**
 * Responsible for rendering the metrics table, container
 */
public class TableFragment extends Fragment implements IMetricsObserver {
    private static final String TAG = "TableFragment";

    private MetricsTable talbeView;

    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TableFragment.
     */
    public static TableFragment newInstance() {
        return new TableFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parent = inflater.inflate(R.layout.fragment_table, container, false);
        talbeView = (MetricsTable) parent.findViewById(R.id.metrics_table);
        return parent;
    }

    @Override
    public void onNewItem(LTEMetricsModel item) {
        talbeView.addValue(item);
    }

    @Override
    public void onClearAll() {

    }
}