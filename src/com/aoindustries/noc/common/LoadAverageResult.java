/*
 * Copyright 2009 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class LoadAverageResult extends TableMultiResult<Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final float oneMinute;
    private final float fiveMinute;
    private final float tenMinute;
    private final int runningProcesses;
    private final int totalProcesses;
    private final int lastPID;
    private final float loadLow;
    private final float loadMedium;
    private final float loadHigh;
    private final float loadCritical;

    public LoadAverageResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        String error
    ) {
        super(time, latency, alertLevel, error);
        this.oneMinute = Float.NaN;
        this.fiveMinute = Float.NaN;
        this.tenMinute = Float.NaN;
        this.runningProcesses = Integer.MIN_VALUE;
        this.totalProcesses = Integer.MIN_VALUE;
        this.lastPID = Integer.MIN_VALUE;
        this.loadLow = Float.NaN;
        this.loadMedium = Float.NaN;
        this.loadHigh = Float.NaN;
        this.loadCritical = Float.NaN;
    }

    public LoadAverageResult(
        long time,
        long latency,
        AlertLevel alertLevel,
        float oneMinute,
        float fiveMinute,
        float tenMinute,
        int runningProcesses,
        int totalProcesses,
        int lastPID,
        float loadLow,
        float loadMedium,
        float loadHigh,
        float loadCritical
    ) {
        super(time, latency, alertLevel, null);
        this.oneMinute = oneMinute;
        this.fiveMinute = fiveMinute;
        this.tenMinute = tenMinute;
        this.runningProcesses = runningProcesses;
        this.totalProcesses = totalProcesses;
        this.lastPID = lastPID;
        this.loadLow = loadLow;
        this.loadMedium = loadMedium;
        this.loadHigh = loadHigh;
        this.loadCritical = loadCritical;
    }

    /**
     * Gets the number of data elements for this result.
     */
    @Override
    public int getRowDataSize() {
        return 7;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    @Override
    public Object getRowData(int index) {
        switch(index) {
            case 0: return oneMinute;
            case 1: return fiveMinute;
            case 2: return tenMinute;
            case 3: return runningProcesses;
            case 4: return totalProcesses;
            case 5: return lastPID;
            case 6: {
                return
                    (Float.isNaN(loadLow) ? "-" : Float.toString(loadLow))
                    + " / "
                    + (Float.isNaN(loadMedium) ? "-" : Float.toString(loadMedium))
                    + " / "
                    + (Float.isNaN(loadHigh) ? "-" : Float.toString(loadHigh))
                    + " / "
                    + (Float.isNaN(loadCritical) ? "-" : Float.toString(loadCritical))
                ;
            }
            default: throw new IndexOutOfBoundsException();
        }
    }

    public float getOneMinute() {
        return oneMinute;
    }

    public float getFiveMinute() {
        return fiveMinute;
    }

    public float getTenMinute() {
        return tenMinute;
    }

    public int getRunningProcesses() {
        return runningProcesses;
    }

    public int getTotalProcesses() {
        return totalProcesses;
    }

    public int getLastPID() {
        return lastPID;
    }

    public float getLoadLow() {
        return loadLow;
    }

    public float getLoadMedium() {
        return loadMedium;
    }

    public float getLoadHigh() {
        return loadHigh;
    }

    public float getLoadCritical() {
        return loadCritical;
    }
}
