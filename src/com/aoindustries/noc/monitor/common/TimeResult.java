/*
 * Copyright 2009-2012 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.monitor.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class TimeResult extends TableMultiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long skew;

    public TimeResult(MonitoringPoint monitoringPoint, long time, long latency, AlertLevel alertLevel, String error) {
        super(monitoringPoint, time, latency, alertLevel, error);
        this.skew = Long.MIN_VALUE;
    }

    public TimeResult(MonitoringPoint monitoringPoint, long time, long latency, AlertLevel alertLevel, long skew) {
        super(monitoringPoint, time, latency, alertLevel, null);
        this.skew = skew;
    }

    public long getSkew() {
        return skew;
    }

    @Override
    public int getRowDataSize() {
        return 1;
    }

    @Override
    public TimeSpan getRowData(int index) {
        switch(index) {
            case 0: return new TimeSpan(skew);
            default: throw new IndexOutOfBoundsException();
        }
    }
}