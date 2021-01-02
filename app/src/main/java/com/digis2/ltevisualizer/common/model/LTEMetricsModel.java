package com.digis2.ltevisualizer.common.model;

/**
 * Model to hold all LTE metrics data (SINR, RSRP, RSRQ)
 */
public class LTEMetricsModel {
    private int RSRP;
    private int RSRQ;
    private int SINR;

    public LTEMetricsModel(int RSRP, int RSRQ, int SINR) {
        this.RSRP = RSRP;
        this.RSRQ = RSRQ;
        this.SINR = SINR;
    }

    public int getRSRP() {
        return RSRP;
    }

    public void setRSRP(int RSRP) {
        this.RSRP = RSRP;
    }

    public int getRSRQ() {
        return RSRQ;
    }

    public void setRSRQ(int RSRQ) {
        this.RSRQ = RSRQ;
    }

    public int getSINR() {
        return SINR;
    }

    public void setSINR(int SINR) {
        this.SINR = SINR;
    }
}
