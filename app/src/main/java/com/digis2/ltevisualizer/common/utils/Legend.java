package com.digis2.ltevisualizer.common.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Util class that interprets the content of legend.json file
 */
public class Legend {


    private static class MetricCalculator {
        private static final String TAG = "MetricCalculator";
        private static JSONObject legendRoot; // just read the file once
        protected Context context;
        protected String name;
        protected int min;
        protected int max;

        public MetricCalculator(Context context, String name, int min, int max) {
            this.context = context;
            this.name = name;
            this.min = min;
            this.max = max;
            if (legendRoot == null) { // just read the file once
                String legendStr = IO.readFileFromAssets(context, "legend.json");
                try {
                    legendRoot = new JSONObject(legendStr);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e(TAG, "MetricCalculator: Can't parse legend.json file", e);
                }
            }
        }

        public int calcProgress(int value) {
            if (value < min) {
                Log.w(TAG, "calcProgress: value %i is less than min %i defined in constructor, " +
                        "set it as min in this calculation only");
                return 0;
            }
            if (value > max) {
                Log.w(TAG, "calcProgress: value %i is higher than max %i defined in constructor, " +
                        "set it as max in this calculation only");
                return 100;
            }
            float percentage = (value * 1.0f - min) / (max - min); // always from 0.0 to 1.0
//            return Math.min(Math.round(percentage), 100);
            return Math.round(Math.abs(percentage * 100));
        }

        public String calcColor(int value) {
            try {
                JSONArray valuesArrJson = legendRoot.getJSONArray(name);
                for (int i = 0; i < valuesArrJson.length(); i++) {
                    JSONObject current = valuesArrJson.getJSONObject(i);
                    String from = current.getString("From");
                    String to = current.getString("To");
                    boolean minValid = from.equals("Min") || value >= Float.parseFloat(from);
                    boolean maxValid = to.equals("Max") || value <= Float.parseFloat(to);
                    if (minValid && maxValid) return current.getString("Color");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG, "calcColor: parsing error", e);
            }
            return null;
        }
    }

    public static final class SINRCalculator extends MetricCalculator {
        public SINRCalculator(Context context) {
            super(context, "SINR", -1, 31);
        }
    }

    public static final class RSRPCalculator extends MetricCalculator {
        public RSRPCalculator(Context context) {
            super(context, "RSRP", -111, -59);
        }
    }

    public static final class RSRQCalculator extends MetricCalculator {
        public RSRQCalculator(Context context) {
            super(context, "RSRQ", -21, -2);
        }
    }



    /**
     * factory method, converts value to the correct color
     *
     * @param name  name of the metric (e.g "SINR")
     * @param value value of the KPI
     * @return corresponding color of the value
     */
    public static String calcColor(Context context, String name, int value) {
        return getCalculator(context, name).calcColor(value);
    }

    /**
     * factory method, converts value to the correct progress percentage
     *
     * @param name  name of the metric (e.g "SINR")
     * @param value value of the KPI
     * @return corresponding progress percentage from 0 to 100
     */
    public static int calcProgress(Context context, String name, int value) {
        return getCalculator(context, name).calcProgress(value);
    }

    private static MetricCalculator getCalculator(Context context, String name){
        MetricCalculator calc = null;
        switch (name){
            case "SINR":
                calc = new SINRCalculator(context);
                break;
            case "RSRP":
                calc = new RSRPCalculator(context);
                break;
            case "RSRQ":
                calc = new RSRQCalculator(context);
                break;
            default:
                throw new IllegalArgumentException("name should be one of SINR, RSRP, RSRQ");
        }
        return calc;
    }
}
