/*
 * Copyright 2009-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import com.aoindustries.util.StringUtility;
import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class NetDeviceBitRateResult extends TableMultiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long txBitsPerSecond;
    private final long rxBitsPerSecond;
    private final long txPacketsPerSecond;
    private final long rxPacketsPerSecond;
    private final long bpsLow;
    private final long bpsMedium;
    private final long bpsHigh;
    private final long bpsCritical;

    public NetDeviceBitRateResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        String error
    ) {
        super(time, latency, alertLevel, error);
        this.txBitsPerSecond = -1;
        this.rxBitsPerSecond = -1;
        this.txPacketsPerSecond = -1;
        this.rxPacketsPerSecond = -1;
        this.bpsLow = -1;
        this.bpsMedium = -1;
        this.bpsHigh = -1;
        this.bpsCritical = -1;
    }

    public NetDeviceBitRateResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        long txBitsPerSecond,
        long rxBitsPerSecond,
        long txPacketsPerSecond,
        long rxPacketsPerSecond,
        long bpsLow,
        long bpsMedium,
        long bpsHigh,
        long bpsCritical
    ) {
        super(time, latency, alertLevel, null);
        this.txBitsPerSecond = txBitsPerSecond;
        this.rxBitsPerSecond = rxBitsPerSecond;
        this.txPacketsPerSecond = txPacketsPerSecond;
        this.rxPacketsPerSecond = rxPacketsPerSecond;
        this.bpsLow = bpsLow;
        this.bpsMedium = bpsMedium;
        this.bpsHigh = bpsHigh;
        this.bpsCritical = bpsCritical;
    }

    @Override
    public int getRowDataSize() {
        return 5;
    }

    @Override
    public Object getRowData(int index) {
        switch(index) {
            case 0: return txBitsPerSecond==-1 ? null : new ApproximateDisplayExactBitRate(txBitsPerSecond);
            case 1: return rxBitsPerSecond==-1 ? null : new ApproximateDisplayExactBitRate(rxBitsPerSecond);
            case 2: return txPacketsPerSecond==-1 ? null : new ApproximateDisplayExactBitRate(txPacketsPerSecond);
            case 3: return rxPacketsPerSecond==-1 ? null : new ApproximateDisplayExactBitRate(rxPacketsPerSecond);
            case 4: {
                return
                    (bpsLow==-1 ? "-" : StringUtility.getApproximateBitRate(bpsLow))
                    + " / "
                    + (bpsMedium==-1 ? "-" : StringUtility.getApproximateBitRate(bpsMedium))
                    + " / "
                    + (bpsHigh==-1 ? "-" : StringUtility.getApproximateBitRate(bpsHigh))
                    + " / "
                    + (bpsCritical==-1 ? "-" : StringUtility.getApproximateBitRate(bpsCritical))
                ;
            }
            default: throw new IndexOutOfBoundsException();
        }
    }

    public long getTxBitsPerSecond() {
        return txBitsPerSecond;
    }

    public long getRxBitsPerSecond() {
        return rxBitsPerSecond;
    }

    public long getTxPacketsPerSecond() {
        return txPacketsPerSecond;
    }

    public long getRxPacketsPerSecond() {
        return rxPacketsPerSecond;
    }

    public long getBpsLow() {
        return bpsLow;
    }

    public long getBpsMedium() {
        return bpsMedium;
    }

    public long getBpsHigh() {
        return bpsHigh;
    }

    public long getBpsCritical() {
        return bpsCritical;
    }
}
