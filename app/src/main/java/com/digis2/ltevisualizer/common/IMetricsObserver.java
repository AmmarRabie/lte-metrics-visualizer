package com.digis2.ltevisualizer.common;

import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

/**
 * custom observer class for metrics changing
 */
public interface IMetricsObserver {
    /**
     * called when new item requested and added to the subject
     *
     * @param item new LTEMetrics item
     */
    void onNewItem(LTEMetricsModel item);

    /**
     * called when subject is clear of data
     */
    void onClearAll();
}