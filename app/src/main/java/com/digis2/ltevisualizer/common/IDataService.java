package com.digis2.ltevisualizer.common;

import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import java.util.Timer;

import androidx.annotation.NonNull;

/**
 * Schema for providing application data
 */
public interface IDataService {


    /**
     * provide random valid values of {@link LTEMetricsModel} only one time
     *
     * @param callback Async pattern for providing the data
     * @see #getRandomMetrics(Get)
     */
    void getRandomMetrics(@NonNull Get<LTEMetricsModel> callback);

    /**
     * provide random valid values of {@link LTEMetricsModel} continuously every periodMillis
     *
     * @param callback Async pattern for providing the data
     * @see #getRandomMetrics(Get)
     */
    Timer poolRandomMetrics(long periodMillis, final Get<LTEMetricsModel> callback);


    /**
     * define a general callback of Get operation
     *
     * @param <D> type of data returned after each fetching success
     */
    abstract class Pool<D> {

        public Pool(long millis) {
        }

        public abstract void onDataFetched(D data);

        public void onDataNotAvailable() {
        }

        public void onError(String cause) {
        }
    }

    /**
     * define the general callback of Get operation
     *
     * @param <D> type of data returned after fetching success
     */
    abstract class Get<D> {
        public abstract void onDataFetched(D data);

        public void onDataNotAvailable() {
        }

        public void onError(String cause) {
        }
    }
}
