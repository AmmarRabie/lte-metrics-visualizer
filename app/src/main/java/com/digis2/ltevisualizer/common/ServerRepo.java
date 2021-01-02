package com.digis2.ltevisualizer.common;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.digis2.ltevisualizer.common.model.LTEMetricsModel;

import org.json.JSONException;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.NonNull;

public class ServerRepo implements IDataService {
    private Context ctx;

    public ServerRepo(@NonNull Context context) {
        ctx = context;
    }

    @Override
    public void getRandomMetrics(@NonNull final Get<LTEMetricsModel> callback) {
        String url = Contract.RandomEntry.URL_THIS;
        JsonObjectRequest randomMetricsReq = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            int RSRP, RSRQ, SINR;
            try {
                RSRP = response.getInt("RSRP");
                RSRQ = response.getInt("RSRQ");
                SINR = response.getInt("SINR");
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onDataNotAvailable(); // Unexpected server response
                return;
            }
            callback.onDataFetched(new LTEMetricsModel(RSRP, RSRQ, SINR));
        }, error -> {
            error.printStackTrace();
            callback.onError(error.getMessage());
        });
        MyRequestQueue.getInstance(ctx).addToRequestQueue(randomMetricsReq);
    }

    @Override
    public Timer poolRandomMetrics(long periodMillis, final Get<LTEMetricsModel> callback) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getRandomMetrics(callback);
            }
        }, 0, periodMillis);
        return timer;
    }

    private final static class Contract {
        public static final String KEY_THIS = "http://51.195.89.92:6000/";

        static final class RandomEntry {
            static final String KEY_THIS = "random";
            static final String URL_THIS = Contract.KEY_THIS + KEY_THIS;

            private RandomEntry() {
            }
        }
    }
}
