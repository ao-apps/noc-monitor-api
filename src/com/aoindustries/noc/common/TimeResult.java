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
public class TimeResult extends TableMultiResult<TimeSpan> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long skew;

    public TimeResult(long time, long latency, AlertLevel alertLevel, String error) {
        super(time, latency, alertLevel, error);
        this.skew = Long.MIN_VALUE;
    }

    public TimeResult(long time, long latency, AlertLevel alertLevel, long skew) {
        super(time, latency, alertLevel, null);
        this.skew = skew;
    }

    public long getSkew() {
        return skew;
    }

    /**
     * Gets the number of data elements for this result.
     */
    @Override
    public int getRowDataSize() {
        return 1;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    @Override
    public TimeSpan getRowData(int index) {
        switch(index) {
            case 0: return new TimeSpan(skew);
            default: throw new IndexOutOfBoundsException();
        }
    }
}
