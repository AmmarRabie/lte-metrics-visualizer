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
 * Responsible for rendering the metrics table, container
 */
public class TableFragment extends Fragment implements IMetricsObserver {
    private static final String TAG = "TableFragment";

    private ViewGroup rootView;

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
        rootView = (ViewGroup) parent.findViewById(R.id.frg_table_container);
        return parent;
    }

    @Override
    public void onNewItem(LTEMetricsModel item) {
        TextView newView = new TextView(getContext());
        newView.setText(String.valueOf(item.getRSRP()));
        rootView.addView(newView);
    }

    @Override
    public void onClearAll() {

    }
}