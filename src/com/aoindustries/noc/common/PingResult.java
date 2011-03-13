/*
 * Copyright 2009-2011 by AO Industries, Inc.,
 * 7262 Bull Pen Cir, Mobile, Alabama, 36695, U.S.A.
 * All rights reserved.
 */
package com.aoindustries.noc.common;

import java.io.Serializable;

/**
 * @author  AO Industries, Inc.
 */
public class PingResult extends TableMultiResult<Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public PingResult(long time, long latency, AlertLevel alertLevel, String error) {
        super(time, latency, alertLevel, error);
    }

    public PingResult(long time, long latency, AlertLevel alertLevel) {
        super(time, latency, alertLevel, null);
    }

    /**
     * Gets the number of data elements for this result.
     */
    @Override
    public int getRowDataSize() {
        return 0;
    }

    /**
     * Gets the data for one row.  This should not include the time and latency, they are implied.
     * When there is an error, getRowData will not be checked and should return null.
     */
    @Override
    public Object getRowData(int index) {
        throw new IndexOutOfBoundsException();
    }
}
